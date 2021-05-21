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
import technomint.app.fancode.R;

public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.MyViewHolder> {

    private Context context;
    private List<LiveModel> best;

    public LiveAdapter(Context context, List<LiveModel> best) {
        this.context = context;
        this.best = best;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mImage;
        TextView eyelive_count,CSK;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.liveimage);
            eyelive_count = itemView.findViewById(R.id.eye_countlive);
            CSK = itemView.findViewById(R.id.cskvsmi);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.live_item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        LiveModel app = best.get(position);

        holder.mImage.setImageResource(app.getLiveImage());
        holder.eyelive_count.setText(app.getEye_countlive());
        holder.CSK.setText(app.getCskvsmi());

    }

    @Override
    public int getItemCount() {
        return best.size();
    }


}