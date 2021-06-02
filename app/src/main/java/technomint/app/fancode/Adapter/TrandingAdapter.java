package technomint.app.fancode.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

import technomint.app.fancode.Model.TrandingModel;
import technomint.app.fancode.PlayVideos;
import technomint.app.fancode.R;

public class TrandingAdapter extends RecyclerView.Adapter<TrandingAdapter.MyViewHolder> {

    private Context context;
    private List<TrandingModel> best;

    public TrandingAdapter(Context context, List<TrandingModel> best) {
        this.context = context;
        this.best = best;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mImage;
        TextView mText,highlight,count_eye,date,time_trand;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.bestimage);
            mText = itemView.findViewById(R.id.banner_text);
            highlight = itemView.findViewById(R.id.highlight);
            count_eye = itemView.findViewById(R.id.eye_count);
            date = itemView.findViewById(R.id.date);
            time_trand = itemView.findViewById(R.id.time_trand);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.tranding_item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TrandingModel app = best.get(position);

        holder.mImage.setImageResource(app.getImage());
        holder.mText.setText(app.getName());
        holder.highlight.setText(app.getHighlight());
        holder.count_eye.setText(app.getCount_eye());
        holder.date.setText(app.getDate());
        holder.time_trand.setText(app.getTime_trand());
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Bundle b = new Bundle();
        b.putSerializable("videoData", best.get(position));
        Intent i = new Intent(context, PlayVideos.class);
        i.putExtras(b);
        v.getContext().startActivity(i);
    }
});

    }

    @Override
    public int getItemCount() {
        return best.size();
    }


}