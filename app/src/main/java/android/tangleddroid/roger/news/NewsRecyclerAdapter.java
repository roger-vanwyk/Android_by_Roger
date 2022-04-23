package android.tangleddroid.roger.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.tangleddroid.roger.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {

//    Variables for array list and its context
    private ArrayList<NewsModal> newsModalArrayList;
    private Context context;

//    Creates a constructor
    public NewsRecyclerAdapter(ArrayList<NewsModal> newsModalArrayList, Context context) {
        this.newsModalArrayList = newsModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Passes layout file for displaying the card item
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.news_recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Sets data to UI components
        NewsModal modal = newsModalArrayList.get(position);
        holder.newsDescriptionTextView.setText(modal.getNewsDescription());
        holder.newsTitleTextView.setText(modal.getNewsTitle());
        Picasso.get().load(modal.getNewsImage()).into(holder.newsImageView);

    }

    @Override
    public int getItemCount() {
//        Returns the size of an array list
        return newsModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//        Creates variables for the text views
        private TextView newsTitleTextView, newsDescriptionTextView;
        private ImageView newsImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            Initialize the views
            newsImageView = itemView.findViewById(R.id.newsImageView);
            newsTitleTextView = itemView.findViewById(R.id.newsTitleTextView);
            newsDescriptionTextView = itemView.findViewById(R.id.newsDescriptionTextView);
        }
    }
}
