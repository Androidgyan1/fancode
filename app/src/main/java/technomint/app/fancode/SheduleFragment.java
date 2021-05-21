package technomint.app.fancode;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import technomint.app.fancode.Adapter.LiveAdapter;
import technomint.app.fancode.Adapter.TodayMatchAdapter;
import technomint.app.fancode.Model.CricketModel;
import technomint.app.fancode.Model.LiveModel;
import technomint.app.fancode.Model.TodayMatchModel;

public class SheduleFragment extends Fragment implements View.OnClickListener {

    RecyclerView sudel_recycle;
    List<TodayMatchModel> appList;

    TabLayout tabLayout;

    ColorStateList def;
    TextView item1;
    TextView item2;
    TextView item3;
    TextView select;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shedule,container,false);



        ///recycle

        sudel_recycle = view.findViewById(R.id.result);

        appList = new ArrayList<>();

        ///resultTab

        ////livematch

        appList.add(new TodayMatchModel("Match#15 T10","1d 8h","Kolkata Knight Rider","Tribango Knight Rider",R.drawable.kkr,R.drawable.tkr,"9Sun, MAy2021","Watch live at 11:00 Pm"));
        final LinearLayoutManager managerbestsearch3 = new LinearLayoutManager(getActivity());
        managerbestsearch3.setOrientation(LinearLayoutManager.VERTICAL);
        sudel_recycle.setLayoutManager(managerbestsearch3);

        TodayMatchAdapter adaptorbestsearch3 = new TodayMatchAdapter(getActivity(),appList);

        sudel_recycle.setAdapter(adaptorbestsearch3);




        item1 = view.findViewById(R.id.item1);
        item2 = view.findViewById(R.id.item2);
        item3 = view.findViewById(R.id.item3);
        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        select = view.findViewById(R.id.select);
        def = item2.getTextColors();



        tabLayout=view.findViewById(R.id.tabLayout);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.item1){
            select.animate().x(0).setDuration(100);
            item1.setTextColor(Color.YELLOW);
            item2.setTextColor(def);
            item3.setTextColor(def);
        } else if (view.getId() == R.id.item2){
            item1.setTextColor(def);
            item2.setTextColor(Color.YELLOW);
            item3.setTextColor(def);
            int size = item2.getWidth();
            select.animate().x(size).setDuration(100);
        } else if (view.getId() == R.id.item3){
            item1.setTextColor(def);
            item3.setTextColor(Color.YELLOW);
            item2.setTextColor(def);
            int size = item2.getWidth() * 2;
            select.animate().x(size).setDuration(100);
        }
    }



    }
