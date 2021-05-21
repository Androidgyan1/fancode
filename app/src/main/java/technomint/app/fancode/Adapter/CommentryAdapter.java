package technomint.app.fancode.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import technomint.app.fancode.Model.CommentryModel;
import technomint.app.fancode.Model.OverviewModel;
import technomint.app.fancode.R;

public class CommentryAdapter extends RecyclerView.Adapter<CommentryAdapter.MyViewHolder> {

    private Context context;
    private List<CommentryModel> best;

    public CommentryAdapter(Context context, List<CommentryModel> best) {
        this.context = context;
        this.best = best;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // ImageView mImage;
        TextView over_commentry,over_run,commentry_match,commentry_matchsummary;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // mImage = itemView.findViewById(R.id.liveimage);
            over_commentry = itemView.findViewById(R.id.over_commentry);
            over_run = itemView.findViewById(R.id.over_run);
            commentry_match = itemView.findViewById(R.id.commentry_match);
            commentry_matchsummary = itemView.findViewById(R.id.commentry_matchsummary);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.commentry_second_item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CommentryModel app = best.get(position);

        //  holder.mImage.setImageResource(app.getLiveImage());
        holder.over_commentry.setText(app.getOver_commentry());
        holder.over_run.setText(app.getOver_run());
        holder.commentry_match.setText(app.getCommentry_match());
        holder.commentry_matchsummary.setText(app.getCommentry_matchsummary());

    }

    @Override
    public int getItemCount() {
        return best.size();
    }


}