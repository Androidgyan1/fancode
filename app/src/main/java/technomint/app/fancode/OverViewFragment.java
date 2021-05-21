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
import technomint.app.fancode.Adapter.OverviewAdapter;
import technomint.app.fancode.Model.CricketModel;
import technomint.app.fancode.Model.LiveModel;
import technomint.app.fancode.Model.OverviewModel;

public class OverViewFragment extends Fragment {

    RecyclerView overview;
    List<OverviewModel> appList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_over_view,container,false);
        overview = view.findViewById(R.id.overview_recycle);

        appList = new ArrayList<>();


        appList.add(new OverviewModel("Match","Match1 VSport ECS Germany"));
        final LinearLayoutManager managerbestsearch3 = new LinearLayoutManager(getActivity());
        managerbestsearch3.setOrientation(LinearLayoutManager.HORIZONTAL);
        overview.setLayoutManager(managerbestsearch3);

        OverviewAdapter adaptorbestsearch3 = new OverviewAdapter(getActivity(),appList);

        overview.setAdapter(adaptorbestsearch3);


        return view;
    }
}