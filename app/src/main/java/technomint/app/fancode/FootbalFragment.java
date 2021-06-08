package technomint.app.fancode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import technomint.app.fancode.Adapter.CricketAdapter;
import technomint.app.fancode.Adapter.LiveAdapter;
import technomint.app.fancode.Adapter.NewsFragmentAdapter;
import technomint.app.fancode.Config.Config;
import technomint.app.fancode.Model.CricketModel;
import technomint.app.fancode.Model.LiveModel;
import technomint.app.fancode.Model.NewsFragmentModel;

import static android.content.ContentValues.TAG;

public class FootbalFragment extends Fragment {

    RecyclerView news_recycle;
    List<NewsFragmentModel> appList;
    String league_id = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_footbal,container,false);

        ///recycle category
        news_recycle = view.findViewById(R.id.news_recycle);

        appList = new ArrayList<>();

        getCourseDetails(league_id);

        ////livematch


        return view;
    }

    private void getCourseDetails(String league_id) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("league_id", "3");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        if (queue!=null) {

            StringRequest request = new StringRequest(Request.Method.POST, Config.LeagueCategoryFragment, new com.android.volley.Response.Listener<String>() {


                @Override
                public void onResponse(String response) {

                    try {///code likha tha app c

                        ///
                        //is part me bhi valodation lagao ki data aaaray me response he ki nahi
                        // on below line passing our response to json object.
                        JSONObject jsonObject1 = new JSONObject(response);

                        JSONObject jsonObject = jsonObject1.getJSONObject("data");


                        Log.d(TAG, "onResponse: " + response);
                        // on below line we are checking if the response is null or not.

                        JSONArray news_trending=jsonObject.getJSONArray("news_trending");

                        for (int i=0; i<news_trending.length(); i++) {

                            jsonObject1 = news_trending.getJSONObject(i);

                            NewsFragmentModel categoryModel = new NewsFragmentModel();
                            categoryModel.setNews_image(R.drawable.banner);

                            categoryModel.setNews_title(jsonObject1.getString("title"));
                            categoryModel.setDescripation_news(jsonObject1.getString("description").replaceAll("<(.*?)\\>"," "));
                            categoryModel.setTitle_min(jsonObject1.getString("updatedate"));


                            //adding the hero to herolist
                            appList.add(categoryModel);
                        }

                        // a success toast message.

                        setRvadapterCategory(appList);


                    } catch (JSONException e) {
                        e.printStackTrace();

                        Toast.makeText(getActivity(),"Data not found",Toast.LENGTH_SHORT).show();
                    }

                }
            }, new com.android.volley.Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // method to handle errors.
                    Toast.makeText(getActivity(), "Fail to get course" + error, Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public byte[] getBody() throws AuthFailureError {
                    String str = String.valueOf(jsonObject);
                    return str.getBytes();
                }
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

               /* @Override
                protected Map<String, String> getParams() {

                    // below line we are creating a map for storing our values in key and value pair.
                    Map<String, String> params = new HashMap<String, String>();

                    // on below line we are passing our key and value pair to our parameters.
                    params.put("league_id", category_id);

                    // at last we are returning our params.
                    return params;
                }*/
            };
            // below line is to make
            // a json object request.
            queue.add(request);

        }else {
            Toast.makeText(getActivity(),"not found",Toast.LENGTH_SHORT).show();
        }



    }

    private void setRvadapterCategory(List<NewsFragmentModel> appList) {

        final LinearLayoutManager manager1 = new LinearLayoutManager(getActivity());
        manager1.setOrientation(LinearLayoutManager.VERTICAL);
        news_recycle.setLayoutManager(manager1);

        NewsFragmentAdapter myAdaptercategory = new NewsFragmentAdapter(getActivity(),appList) ;
        news_recycle.setAdapter(myAdaptercategory);



    }
}