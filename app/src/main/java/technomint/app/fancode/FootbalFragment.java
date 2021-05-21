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

import technomint.app.fancode.Adapter.LiveAdapter;
import technomint.app.fancode.Adapter.NewsFragmentAdapter;
import technomint.app.fancode.Model.CricketModel;
import technomint.app.fancode.Model.LiveModel;
import technomint.app.fancode.Model.NewsFragmentModel;

public class FootbalFragment extends Fragment {

    RecyclerView news_recycle;
    List<NewsFragmentModel> appList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_footbal,container,false);

        ///recycle category
        news_recycle = view.findViewById(R.id.news_recycle);

        appList = new ArrayList<>();

        ////livematch

        appList.add(new NewsFragmentModel(R.drawable.live,"35 min","Title of News","descripation of news"));
        final LinearLayoutManager managerbestsearch3 = new LinearLayoutManager(getActivity());
        managerbestsearch3.setOrientation(LinearLayoutManager.VERTICAL);
        news_recycle.setLayoutManager(managerbestsearch3);

        NewsFragmentAdapter adaptorbestsearch3 = new NewsFragmentAdapter(getActivity(),appList);

        news_recycle.setAdapter(adaptorbestsearch3);





        return view;
    }
}