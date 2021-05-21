package technomint.app.fancode.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import technomint.app.fancode.Model.LiveModel;
import technomint.app.fancode.Model.NewsModel;
import technomint.app.fancode.Model.OverviewModel;
import technomint.app.fancode.R;

public class OverviewAdapter extends RecyclerView.Adapter<OverviewAdapter.MyViewHolder> {

    private Context context;
    private List<OverviewModel> best;

    public OverviewAdapter(Context context, List<OverviewModel> best) {
        this.context = context;
        this.best = best;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       // ImageView mImage;
        TextView overview_match,overview_matchsummary;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

           // mImage = itemView.findViewById(R.id.liveimage);
            overview_match = itemView.findViewById(R.id.overview_match);
            overview_matchsummary = itemView.findViewById(R.id.overview_matchsummary);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_overview,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OverviewModel app = best.get(position);

      //  holder.mImage.setImageResource(app.getLiveImage());
        holder.overview_match.setText(app.getOverview_match());
        holder.overview_matchsummary.setText(app.getOverview_matchsummary());

    }

    @Override
    public int getItemCount() {
        return best.size();
    }


}