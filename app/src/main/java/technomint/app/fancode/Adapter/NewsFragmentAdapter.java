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
import technomint.app.fancode.Model.NewsFragmentModel;
import technomint.app.fancode.R;

public class NewsFragmentAdapter extends RecyclerView.Adapter<NewsFragmentAdapter.MyViewHolder> {

    private Context context;
    private List<NewsFragmentModel> best;

    public NewsFragmentAdapter(Context context, List<NewsFragmentModel> best) {
        this.context = context;
        this.best = best;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView news_image;
        TextView news_title,title_min,descripation_news;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            news_image = itemView.findViewById(R.id.news_image);
            news_title = itemView.findViewById(R.id.news_title);
            title_min = itemView.findViewById(R.id.title_min);
            descripation_news = itemView.findViewById(R.id.descripation_news);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.newsfragmentfootball_item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NewsFragmentModel app = best.get(position);

        holder.news_image.setImageResource(app.getNews_image());
        holder.news_title.setText(app.getNews_title());
        holder.title_min.setText(app.getTitle_min());
        holder.descripation_news.setText(app.getDescripation_news());

    }

    @Override
    public int getItemCount() {
        return best.size();
    }


}