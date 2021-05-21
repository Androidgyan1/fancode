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
import technomint.app.fancode.Model.ScoreModel;
import technomint.app.fancode.R;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.MyViewHolder> {

    private Context context;
    private List<ScoreModel> best;

    public ScoreAdapter(Context context, List<ScoreModel> best) {
        this.context = context;
        this.best = best;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView batsmen,r,b,s4,s6,sr;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            batsmen = itemView.findViewById(R.id.batsmen);
            r = itemView.findViewById(R.id.r);
            b = itemView.findViewById(R.id.b);
            s4 = itemView.findViewById(R.id.s4);
            s6 = itemView.findViewById(R.id.s6);
            sr = itemView.findViewById(R.id.sr);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.score_item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ScoreModel app = best.get(position);

        holder.batsmen.setText(app.getBatsmen());
        holder.r.setText(app.getR());
        holder.b.setText(app.getB());
        holder.s4.setText(app.getS4());
        holder.s6.setText(app.getS6());
        holder.sr.setText(app.getSr());

    }

    @Override
    public int getItemCount() {
        return best.size();
    }


}