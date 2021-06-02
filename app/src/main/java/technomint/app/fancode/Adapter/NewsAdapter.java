package technomint.app.fancode.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import technomint.app.fancode.Config.Config;
import technomint.app.fancode.Model.NewsModel;
import technomint.app.fancode.News_detail;
import technomint.app.fancode.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private Context context;
    private List<NewsModel> best;

    public NewsAdapter(Context context, List<NewsModel> best) {
        this.context = context;
        this.best = best;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mImage;
        TextView new_title,new_desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.newsimage);
            new_title = itemView.findViewById(R.id.new_title);
            new_desc = itemView.findViewById(R.id.new_desc);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(v) ;

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, News_detail.class);

                i.putExtra("id",best.get(viewHolder.getAdapterPosition()).getId());
                i.putExtra("title",best.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("description",best.get(viewHolder.getAdapterPosition()).getDescription());

                context.startActivity(i);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NewsModel app = best.get(position);

        holder.mImage.setImageResource(app.getImg());
        holder.new_title.setText(app.getTitle());
        holder.new_desc.setText(app.getDescription());

        //Glide.with(context).load(Config.NewsImaage  + best.get(position).getImg()).into(holder.mImage);

    }

    @Override
    public int getItemCount() {
        return best.size();
    }


}