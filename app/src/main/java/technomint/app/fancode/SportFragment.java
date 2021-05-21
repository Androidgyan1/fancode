package technomint.app.fancode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import technomint.app.fancode.Adapter.SportGridAdapter;

public class SportFragment extends Fragment {

    GridView gridView;

    String[] values = {
            "Cricket", "FootBall", "BasketBall", "Esport", "VolleyBall", "Kabbadi",
            "Others"
    } ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sport,container,false);

        gridView = (GridView) view.findViewById(R.id.griview);

        SportGridAdapter gridAdapter = new SportGridAdapter(getActivity(), values);

        gridView.setAdapter(gridAdapter);

        return view;
    }
}