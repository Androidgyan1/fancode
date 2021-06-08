package technomint.app.fancode.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import technomint.app.fancode.Config.Config;
import technomint.app.fancode.Model.CricketModel;
import technomint.app.fancode.R;

public class CricketAdapter extends RecyclerView.Adapter<CricketAdapter.MyViewHolder> {

    private Context context;
    private List<CricketModel> best;

    public CricketAdapter(Context context, List<CricketModel> best) {
        this.context = context;
        this.best = best;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView team1image,team2image,share;
        TextView title,matchdata,teamtitle1,teamtitle2,championship,timekkr;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            team1image = itemView.findViewById(R.id.kkrimage);
            team2image = itemView.findViewById(R.id.trinbagoimage);
            title = itemView.findViewById(R.id.pakistanleague);
            matchdata = itemView.findViewById(R.id.date);
            teamtitle1 = itemView.findViewById(R.id.kkrtext);
            teamtitle2 = itemView.findViewById(R.id.trinbagotext);
            championship = itemView.findViewById(R.id.vs);
            share = itemView.findViewById(R.id.share);
            //timekkr = itemView.findViewById(R.id.timekkr);


        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_featured_match,parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(v) ;
        viewHolder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CricketModel app = best.get(position);

        //holder.kkrimage.setImageResource(app.getKkrimage());
       // holder.trinbagoimage.setImageResource(app.getTrinbagoimage());
        holder.title.setText(app.getTitle());
        holder.matchdata.setText(app.getMatchdata());
        holder.teamtitle1.setText(app.getTeamtitle1());
        holder.teamtitle2.setText(app.getTeamtitle2());
        holder.championship.setText(app.getChampionship());
        //holder.timekkr.setText(app.getTimekkr());

        //Glide.with(context).load(Config.matchesImaage  + best.get(position).getTeam1image()).into(holder.team1image);
       // Glide.with(context).load(Config.matchesImaage  + best.get(position).getTeam2image()).into(holder.team2image);

    }

    @Override
    public int getItemCount() {
        return best.size();
    }








}