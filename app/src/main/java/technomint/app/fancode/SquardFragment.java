package technomint.app.fancode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import technomint.app.fancode.Adapter.SportGridAdapter;
import technomint.app.fancode.Adapter.SquardAdapter;

public class SquardFragment extends Fragment {
    GridView gridView;

    String[] values = {
            "Cricket", "FootBall"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_squard,container,false);

        gridView = (GridView) view.findViewById(R.id.griview_squard);

        SquardAdapter gridAdapter = new SquardAdapter(getActivity(), values);

        gridView.setAdapter(gridAdapter);



        return view;
    }



}