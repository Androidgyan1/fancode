package technomint.app.fancode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import technomint.app.fancode.Adapter.CricketAdapter;
import technomint.app.fancode.Adapter.LiveAdapter;
import technomint.app.fancode.Adapter.NewsAdapter;
import technomint.app.fancode.Adapter.TrandingAdapter;
import technomint.app.fancode.Model.CricketModel;
import technomint.app.fancode.Model.LiveModel;
import technomint.app.fancode.Model.NewsModel;
import technomint.app.fancode.Model.TrandingModel;

public class CricketFragment extends Fragment {

    RecyclerView mList1,tranding,news,livematch;
    List<CricketModel> appList;
    List<TrandingModel> trandingList;
    List<NewsModel> newsModelList;
    List<LiveModel> liveModelList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cricket,container,false);

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

        LiveAdapter adaptorbestsearch3 = new LiveAdapter(getActivity(),liveModelList);

        livematch.setAdapter(adaptorbestsearch3);


















///news
        newsModelList.add(new NewsModel(R.drawable.news));
        final LinearLayoutManager managerbestsearch2 = new LinearLayoutManager(getActivity());
        managerbestsearch2.setOrientation(LinearLayoutManager.HORIZONTAL);
        news.setLayoutManager(managerbestsearch2);

        NewsAdapter adaptorbestsearch2 = new NewsAdapter(getActivity(),newsModelList);

        news.setAdapter(adaptorbestsearch2);


















        ///trandingmatch

        trandingList.add(new TrandingModel(R.drawable.trending,"Delhi vs Hyderabad","Highlight","100","7 may2021","07:00"));
        final LinearLayoutManager managerbestsearch1 = new LinearLayoutManager(getActivity());
        managerbestsearch1.setOrientation(LinearLayoutManager.HORIZONTAL);
        tranding.setLayoutManager(managerbestsearch1);

        TrandingAdapter adaptorbestsearch1 = new TrandingAdapter(getActivity(),trandingList);

        tranding.setAdapter(adaptorbestsearch1);















        ///featurematch

        appList.add(new CricketModel("Pakistan Super League T20","Knight Rider vs Tribango Knight Rider","KKR","TKR",R.drawable.kkr,R.drawable.trinbago,"Tue 6 May","12 Pm"));
        final LinearLayoutManager managerbestsearch = new LinearLayoutManager(getActivity());
        managerbestsearch.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList1.setLayoutManager(managerbestsearch);

        CricketAdapter adaptorbestsearch = new CricketAdapter(getActivity(),appList);

        mList1.setAdapter(adaptorbestsearch);






        return view;

    }
}