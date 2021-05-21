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
import technomint.app.fancode.Adapter.ScoreAdapter;
import technomint.app.fancode.Model.CommentryModel;
import technomint.app.fancode.Model.ScoreModel;

public class ScoreFragment extends Fragment {

    RecyclerView score;
    List<ScoreModel> appList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score,container,false);

        score = view.findViewById(R.id.score);

        appList = new ArrayList<>();

        appList.add(new ScoreModel("Austin","11","18","1","0","61.1"));
        final LinearLayoutManager managerbestsearch3 = new LinearLayoutManager(getActivity());
        managerbestsearch3.setOrientation(LinearLayoutManager.HORIZONTAL);
        score.setLayoutManager(managerbestsearch3);

        ScoreAdapter adaptorbestsearch3 = new ScoreAdapter(getActivity(),appList);

        score.setAdapter(adaptorbestsearch3);



        return view;
    }
}