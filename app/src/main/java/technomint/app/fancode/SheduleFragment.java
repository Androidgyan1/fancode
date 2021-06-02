package technomint.app.fancode;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import technomint.app.fancode.Adapter.LiveAdapter;
import technomint.app.fancode.Adapter.PagerAdapterShedule2;
import technomint.app.fancode.Adapter.TodayMatchAdapter;
import technomint.app.fancode.Model.CricketModel;
import technomint.app.fancode.Model.LiveModel;
import technomint.app.fancode.Model.TodayMatchModel;

public class SheduleFragment extends Fragment  {

//    RecyclerView sudel_recycle;
//    List<TodayMatchModel> appList;
//
   private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shedule,container,false);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab1_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Cricket"));
        tabLayout.addTab(tabLayout.newTab().setText("FootBall"));
        tabLayout.addTab(tabLayout.newTab().setText("Hockey"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        final PagerAdapterShedule2 adapter = new PagerAdapterShedule2
                (getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });




        ///recycle

//        sudel_recycle = view.findViewById(R.id.result);
//
//        appList = new ArrayList<>();
//
//        ///resultTab
//
//        ////livematch
//
//        appList.add(new TodayMatchModel("Match#15 T10","1d 8h","Kolkata Knight Rider","Tribango Knight Rider",R.drawable.kkr,R.drawable.tkr,"9Sun, MAy2021","Watch live at 11:00 Pm"));
//        final LinearLayoutManager managerbestsearch3 = new LinearLayoutManager(getActivity());
//        managerbestsearch3.setOrientation(LinearLayoutManager.VERTICAL);
//        sudel_recycle.setLayoutManager(managerbestsearch3);
//
//        TodayMatchAdapter adaptorbestsearch3 = new TodayMatchAdapter(getActivity(),appList);
//
//        sudel_recycle.setAdapter(adaptorbestsearch3);
//
//





//        tabLayout=view.findViewById(R.id.tabLayout);

        return view;
    }



    }
