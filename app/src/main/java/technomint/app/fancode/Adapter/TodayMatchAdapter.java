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

import technomint.app.fancode.Model.CricketModel;
import technomint.app.fancode.Model.TodayMatchModel;
import technomint.app.fancode.R;

public class TodayMatchAdapter extends RecyclerView.Adapter<TodayMatchAdapter.MyViewHolder> {

    private Context context;
    private List<TodayMatchModel> best;

    public TodayMatchAdapter(Context context, List<TodayMatchModel> best) {
        this.context = context;
        this.best = best;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView today_kkrimage,today_tkrimage;
        TextView match_number,match_time,today_kkr_match,today_tkr_match,today_date,today_live_match;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            today_kkrimage = itemView.findViewById(R.id.today_kkrimage);
            today_tkrimage = itemView.findViewById(R.id.today_tkrimage);
            match_number = itemView.findViewById(R.id.match_number);
            match_time = itemView.findViewById(R.id.match_time);
            today_kkr_match = itemView.findViewById(R.id.today_kkr_match);
            today_tkr_match = itemView.findViewById(R.id.today_tkr_match);
            today_date = itemView.findViewById(R.id.today_date);
            today_live_match = itemView.findViewById(R.id.today_live_match);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_upcoming,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TodayMatchModel app = best.get(position);

        holder.today_kkrimage.setImageResource(app.getToday_kkrimage());
        holder.today_tkrimage.setImageResource(app.getToday_tkrimage());
        holder.match_number.setText(app.getMatch_number());
        holder.match_time.setText(app.getMatch_time());
        holder.today_kkr_match.setText(app.getToday_kkr_match());
        holder.today_tkr_match.setText(app.getToday_tkr_match());
        holder.today_date.setText(app.getToday_date());
        holder.today_live_match.setText(app.getToday_live_match());

    }

    @Override
    public int getItemCount() {
        return best.size();
    }


}