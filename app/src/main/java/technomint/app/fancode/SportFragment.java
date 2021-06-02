package technomint.app.fancode;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import technomint.app.fancode.Adapter.GridViewAdapter;
import technomint.app.fancode.Config.Config;
import technomint.app.fancode.Model.GridModel;

import static android.content.ContentValues.TAG;


public class SportFragment extends Fragment {

    Button ci;

    private ArrayList<GridModel> list_data;

    private RecyclerView gridView;
    public String categoryId;

    ProgressBar sportProgress;

    String[] values = {
            "Cricket", "FootBall", "BasketBall", "Esport", "VolleyBall", "Kabbadi",
            "Others"
    } ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sport,container,false);

        ci = view.findViewById(R.id.ci);

        getCourseDetails();

        gridView = (RecyclerView) view.findViewById(R.id.griview);
        list_data=new ArrayList<>();

        sportProgress = view.findViewById(R.id.sport_progress);

        ci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Activity_Match_Category.class);
                startActivity(i);
            }
        });


        return view;
    }

    private void getCourseDetails() {


        StringRequest stringRequest =new StringRequest(Request.Method.POST, Config.SportCategoryFragment, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getActivity(),response,Toast.LENGTH_LONG).show();

                sportProgress.setVisibility(View.VISIBLE);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("data");
                    for (int i=0; i<array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);

                        GridModel listData =  new GridModel();

                        listData.setId(ob.getString("id"));
                         listData.setName(ob.getString("name"));
                        list_data.add(listData);
                        Log.d(TAG, "onResponse: " + response);
                        final LinearLayoutManager managerbestsearch3 = new LinearLayoutManager(getActivity());
                        gridView.setLayoutManager(managerbestsearch3);

                        int numberOfColumns = 2;
                        gridView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));

                        GridViewAdapter adaptorbestsearch3 = new GridViewAdapter(getActivity(),R.layout.grid_sportitem,list_data);

                        gridView.setAdapter(adaptorbestsearch3);

                        sportProgress.setVisibility(View.GONE);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    sportProgress.setVisibility(View.GONE);

                }


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                sportProgress.setVisibility(View.GONE);

            }
        }){
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }


        };
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    }
