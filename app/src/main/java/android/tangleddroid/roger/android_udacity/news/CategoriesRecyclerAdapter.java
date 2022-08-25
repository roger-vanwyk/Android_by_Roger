package android.tangleddroid.roger.android_udacity.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.tangleddroid.roger.R;

import java.util.ArrayList;

public class CategoriesRecyclerAdapter extends RecyclerView.Adapter<CategoriesRecyclerAdapter.ViewHolder> {
//    Variables for array list and context
    private final ArrayList<CategoriesModal> categoriesModalArrayList;
    private final Context context;

    public CategoriesRecyclerAdapter(ArrayList<CategoriesModal> categoriesModalArrayList, Context context) {
        this.categoriesModalArrayList = categoriesModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Passes layout file for displaying the card item
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.categories_recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Sets data to the views
        CategoriesModal modal = categoriesModalArrayList.get(position);
        holder.categoryTextView.setText(modal.getNewsCategory());
        NewsRecyclerAdapter adapter = new NewsRecyclerAdapter((modal.getNewsModalArrayList()), context);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.newsRecycler.setLayoutManager(linearLayoutManager);
        holder.newsRecycler.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return categoriesModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView newsRecycler;
        private final TextView categoryTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTextView = itemView.findViewById(R.id.categoryTextView);
            newsRecycler = itemView.findViewById(R.id.newsRecycler);
        }
    }
}
