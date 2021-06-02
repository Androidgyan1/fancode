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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import technomint.app.fancode.Adapter.CricketAdapter;
import technomint.app.fancode.Adapter.EndTabAdapter;
import technomint.app.fancode.Adapter.LiveAdapter;
import technomint.app.fancode.Adapter.NewsAdapter;
import technomint.app.fancode.Adapter.TrandingAdapter;
import technomint.app.fancode.Config.Config;
import technomint.app.fancode.Indicator.CirclePagerIndicatorDecoration;
import technomint.app.fancode.Model.CricketModel;
import technomint.app.fancode.Model.EndTabModel;
import technomint.app.fancode.Model.GridModel;
import technomint.app.fancode.Model.LiveModel;
import technomint.app.fancode.Model.NewsModel;
import technomint.app.fancode.Model.TrandingModel;

import static android.content.ContentValues.TAG;

public class CricketFragment extends Fragment {

    RecyclerView mList1,tranding,news,livematch;
    List<CricketModel> appList;
    List<TrandingModel> trandingList;
    List<NewsModel> newsModelList;
    List<LiveModel> liveModelList;

    String league_id = "";
    String league = "";
    String trandingleague = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cricket,container,false);
////featured match method
        getCourseDetails(league_id);

        /////new Method

        getNewsDetails(league);

        ////tranding
        getTrandingDetails(trandingleague);


///recycle category
        mList1 = view.findViewById(R.id.featuredmatch);
        tranding = view.findViewById(R.id.trandring);
        news = view.findViewById(R.id.news);
        livematch = view.findViewById(R.id.livematch);



        appList = new ArrayList<>();
        trandingList = new ArrayList<>();
        newsModelList = new ArrayList<>();
        liveModelList = new ArrayList<>();

        ////livematch

        liveModelList.add(new LiveModel(R.drawable.live,"100","CSK 187/8 vs Mi 178/5(19.5)"));
        final LinearLayoutManager managerbestsearch3 = new LinearLayoutManager(getActivity());
        managerbestsearch3.setOrientation(LinearLayoutManager.HORIZONTAL);
        livematch.setLayoutManager(managerbestsearch3);
        livematch.addItemDecoration(new CirclePagerIndicatorDecoration());

        LiveAdapter adaptorbestsearch3 = new LiveAdapter(getActivity(),liveModelList);

        livematch.setAdapter(adaptorbestsearch3);


















///news


















        ///trandingmatch















        ///featurematch

        appList.add(new CricketModel());
        final LinearLayoutManager managerbestsearch = new LinearLayoutManager(getActivity());
        managerbestsearch.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList1.setLayoutManager(managerbestsearch);

        CricketAdapter adaptorbestsearch = new CricketAdapter(getActivity(),appList);

        mList1.setAdapter(adaptorbestsearch);






        return view;

    }

    private void getTrandingDetails(String trandingleague) {

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

                        JSONArray highlight=jsonObject.getJSONArray("highlight");

                        for (int i=0; i<highlight.length(); i++) {

                            jsonObject1 = highlight.getJSONObject(i);
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm");
                            TrandingModel categoryModel = new TrandingModel();
                            categoryModel.setImage(R.drawable.banner);
                            categoryModel.setName(jsonObject1.getString("title"));
                            categoryModel.setDate(convertTime(jsonObject1.getString("updatedate")));
                            categoryModel.setHighlight("Highlight");
                            //categoryModel.setImg(jsonObject1.getInt("img"));


                            //adding the hero to herolist
                            trandingList.add(categoryModel);
                        }

                        // a success toast message.

                        setRvadapterTrandingCategory(trandingList);


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
              //  @Override
                //public byte[] getBody() throws AuthFailureError {
                  //  String str = String.valueOf(jsonObject);
                    //return str.getBytes();
             //   }
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

    private void setRvadapterTrandingCategory(List<TrandingModel> trandingList) {

        final LinearLayoutManager manager1 = new LinearLayoutManager(getActivity());
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        tranding.setLayoutManager(manager1);

        TrandingAdapter myAdaptercategory = new TrandingAdapter(getActivity(),trandingList) ;
        tranding.setAdapter(myAdaptercategory);





    }

    private void getNewsDetails(String league) {

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

                        JSONArray news_normal=jsonObject.getJSONArray("news_normal");

                        for (int i=0; i<news_normal.length(); i++) {

                            jsonObject1 = news_normal.getJSONObject(i);

                            NewsModel categoryModel = new NewsModel();
                            categoryModel.setImg(R.drawable.news);
                            categoryModel.setId(jsonObject1.getString("id"));
                            categoryModel.setTitle(jsonObject1.getString("title"));
                            categoryModel.setDescription(jsonObject1.getString("description"));
                            //categoryModel.setImg(jsonObject1.getInt("img"));


                            //adding the hero to herolist
                            newsModelList.add(categoryModel);
                        }

                        // a success toast message.

                        setRvadapterNewsCategory(newsModelList);


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
               /// @Override
                //public byte[] getBody() throws AuthFailureError {
                  //  String str = String.valueOf(jsonObject);
                    //return str.getBytes();
             //   }
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

    private void setRvadapterNewsCategory(List<NewsModel> newsModelList) {
        final LinearLayoutManager manager1 = new LinearLayoutManager(getActivity());
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        news.setLayoutManager(manager1);

        NewsAdapter myAdaptercategory = new NewsAdapter(getActivity(),newsModelList) ;
        news.setAdapter(myAdaptercategory);



    }


    private void getCourseDetails(String toString) {

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

                      JSONArray matches=jsonObject.getJSONArray("matches");

                        for (int i=0; i<matches.length(); i++) {

                            jsonObject1 = matches.getJSONObject(i);

                            CricketModel categoryModel = new CricketModel();

                            categoryModel.setId(jsonObject1.getString("id"));
                            categoryModel.setUnique_id(jsonObject1.getString("unique_id"));
                            categoryModel.setTitle(jsonObject1.getString("title"));
                            categoryModel.setChampionship(jsonObject1.getString("championship"));
                            categoryModel.setTeamtitle1(jsonObject1.getString("teamtitle1"));
                            categoryModel.setTeamtitle2(jsonObject1.getString("teamtitle2"));
                            categoryModel.setMatchdata(jsonObject1.getString("matchdata"));


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
               /// @Override
              //  public byte[] getBody() throws AuthFailureError {
                  //  String str = String.valueOf(jsonObject);
                  ///  return str.getBytes();
              //  }
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

    private void setRvadapterCategory(List<CricketModel> appList) {
        final LinearLayoutManager manager1 = new LinearLayoutManager(getActivity());
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList1.setLayoutManager(manager1);

        CricketAdapter myAdaptercategory = new CricketAdapter(getActivity(),appList) ;
        mList1.setAdapter(myAdaptercategory);
        mList1.addItemDecoration(new CirclePagerIndicatorDecoration());




    }


    private String convertTime(String time) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format1 = new SimpleDateFormat("hh:mm aa ,MM/dd");
        java.util.Date date = null;

        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String convertedDate = format1.format(date);

        return convertedDate;
    }




}