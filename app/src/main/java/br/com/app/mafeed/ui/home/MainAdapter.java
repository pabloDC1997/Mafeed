package br.com.app.mafeed.ui.home;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.app.mafeed.R;
import br.com.app.mafeed.business.model.RSSObject;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private List<RSSObject> rssList;
    private Context context;
    private AdapterCallback callback;

    public MainAdapter(List<RSSObject> rss, Context context, AdapterCallback callback){
        this.rssList = rss;
        this.context = context;
        this.callback = callback;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new MyViewHolder(LayoutInflater.from( parent.getContext()).inflate(R.layout.item_home, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        RSSObject rss = rssList.get(i);
        String title = rss.getChannel().getTitle() != null ? rss.getChannel().getTitle() : context.getString(R.string.default_feed_title);
        String description = rss.getChannel().getDescription() != null ? rss.getChannel().getDescription() : context.getString(R.string.default_feed_description);
        String urlImage = rss.getChannel().getImage().getUrl();

        holder.feddTitle.setText(title);
        holder.feedDescription.setText(description);

        if (urlImage != null) {
            Picasso.get().load(urlImage).into(holder.feedImage);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.feedImage.setImageDrawable(context.getDrawable(R.drawable.g1teste));//TODO - use default image
            } else {
                holder.feedImage.setImageDrawable(context.getResources().getDrawable(R.drawable.g1teste));
            }
        }
        holder.progressBarImage.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return rssList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.feed_title) TextView feddTitle;
        @BindView(R.id.feed_description) TextView feedDescription;
        @BindView(R.id.feed_image) ImageView feedImage;
        @BindView(R.id.feed_progress_image) ProgressBar progressBarImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.feed_item)
        public void onClickFeedItem(){
            callback.onFeedClicked(getAdapterPosition(), rssList.get(getAdapterPosition()));
        }
    }

    public interface AdapterCallback {
        public void onFeedClicked(int position, RSSObject rss);
    }
}
