package android.tangleddroid.roger;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridInfoAdapter extends ArrayAdapter<Info> {

    public GridInfoAdapter(Activity context, ArrayList<Info> info) {
        super(context, 0, info);
    }

    // Class to hold ArrayList Views.
    // Reference: https://dzone.com/articles/optimizing-your-listview
    static class ViewHolder {
        private TextView nameTextView;
        private TextView detailsTextView;
        private ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Info currentInfo = getItem(position);

        ViewHolder holder;

        // Checks if the view is being reused, otherwise inflate
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            holder = new GridInfoAdapter.ViewHolder();
            // Finds Name and Details TextViews,
            // as well as ImageView
            holder.nameTextView = (TextView) convertView.findViewById(R.id.name_text_view);
            holder.detailsTextView = (TextView) convertView.findViewById(R.id.details_text_view);
            holder.imageView = (ImageView) convertView.findViewById(R.id.image_view);
            convertView.setTag(holder);
        } else {
            holder = (GridInfoAdapter.ViewHolder) convertView.getTag();
        }

        // Sets the text to current Info object
        holder.nameTextView.setText(currentInfo.getName());

        // Sets the text to current Info object
        holder.detailsTextView.setText(currentInfo.getDetails());

        // Sets the image to current Info object
        holder.imageView.setImageResource(currentInfo.getImageResourceId());

        return convertView;
    }
}