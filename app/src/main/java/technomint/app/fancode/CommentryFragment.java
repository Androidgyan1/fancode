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

import technomint.app.fancode.Adapter.CommentryAdapter;
import technomint.app.fancode.Adapter.OverviewAdapter;
import technomint.app.fancode.Model.CommentryModel;
import technomint.app.fancode.Model.OverviewModel;

public class CommentryFragment extends Fragment {

    RecyclerView commentry;
    List<CommentryModel> appList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_commentry,container,false);
        commentry = view.findViewById(R.id.commentry_recyle);

        appList = new ArrayList<>();

        appList.add(new CommentryModel("43.6","0","Tom Haines","No runs"));
        final LinearLayoutManager managerbestsearch3 = new LinearLayoutManager(getActivity());
        managerbestsearch3.setOrientation(LinearLayoutManager.HORIZONTAL);
        commentry.setLayoutManager(managerbestsearch3);

        CommentryAdapter adaptorbestsearch3 = new CommentryAdapter(getActivity(),appList);

        commentry.setAdapter(adaptorbestsearch3);



        return view;
    }
}