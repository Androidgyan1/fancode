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
import technomint.app.fancode.R;

public class CricketAdapter extends RecyclerView.Adapter<CricketAdapter.MyViewHolder> {

    private Context context;
    private List<CricketModel> best;

    public CricketAdapter(Context context, List<CricketModel> best) {
        this.context = context;
        this.best = best;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView kkrimage,trinbagoimage;
        TextView Pakistan_Super_League_T20,KKR_vs_TKR,KKR,TKR,date,timekkr;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            kkrimage = itemView.findViewById(R.id.kkrimage);
            trinbagoimage = itemView.findViewById(R.id.trinbagoimage);
            Pakistan_Super_League_T20 = itemView.findViewById(R.id.pakistanleague);
            KKR_vs_TKR = itemView.findViewById(R.id.vs);
            KKR = itemView.findViewById(R.id.kkrtext);
            TKR = itemView.findViewById(R.id.trinbagotext);
            date = itemView.findViewById(R.id.date);
            timekkr = itemView.findViewById(R.id.timekkr);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_featured_match,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CricketModel app = best.get(position);

        holder.kkrimage.setImageResource(app.getKkrimage());
        holder.trinbagoimage.setImageResource(app.getTrinbagoimage());
        holder.Pakistan_Super_League_T20.setText(app.getPakistan_Super_League_T20());
        holder.KKR_vs_TKR.setText(app.getKKR_vs_TKR());
        holder.KKR.setText(app.getKKR());
        holder.TKR.setText(app.getTKR());
        holder.date.setText(app.getDate());
        holder.timekkr.setText(app.getTimekkr());

    }

    @Override
    public int getItemCount() {
        return best.size();
    }


}