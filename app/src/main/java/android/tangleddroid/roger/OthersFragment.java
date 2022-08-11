package android.tangleddroid.roger;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/*Created 12/2019 by rogervw*/

@SuppressWarnings("ALL")
public class OthersFragment extends Fragment {

    // Creates keys for ListView item data
    public static final ThreadLocal<String> KEY_NAME = new ThreadLocal<String> ( ) {
        @Override
        protected String initialValue() {
            return "KEY_NAME";
        }
    };
    public static final ThreadLocal<String> KEY_LOCATION = new ThreadLocal<String> ( ) {
        @Override
        protected String initialValue() {
            return "KEY_LOCATION";
        }
    };
    public static final ThreadLocal<String> KEY_DETAILS = new ThreadLocal<String> ( ) {
        @Override
        protected String initialValue() {
            return "KEY_DETAILS";
        }
    };
    public static final ThreadLocal<String> KEY_DRAWABLE = new ThreadLocal<String> ( ) {
        @Override
        protected String initialValue() {
            return "KEY_DRAWABLE";
        }
    };
    public static final ThreadLocal<String> KEY_DESCRIPTION = new ThreadLocal<String> ( ) {
        @Override
        protected String initialValue() {
            return "KEY_DESCRIPTION";
        }
    };

    public OthersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // Creates a list of restaurants
        final ArrayList<Info> info = new ArrayList<Info>();
        info.add(new Info(getContext().getString(R.string.food_one_name),
                getContext().getString(R.string.food_one_details),
                R.drawable.biltong,      //TODO: ADD CORRECT IMAGES
                getContext().getString(R.string.food_one_description),
                getContext().getString(R.string.food_one_location)));
        info.add(new Info(getContext().getString(R.string.food_two_name),
                getContext().getString(R.string.food_two_details),
                R.drawable.bokkoms,      //TODO: ADD CORRECT IMAGES
                getContext().getString(R.string.food_two_description),
                getContext().getString(R.string.food_two_location)));
        info.add(new Info(getContext().getString(R.string.food_three_name),
                getContext().getString(R.string.food_three_details),
                R.drawable.braai,      //TODO: ADD CORRECT IMAGES
                getContext().getString(R.string.food_three_description),
                getContext().getString(R.string.food_three_location)));
        info.add(new Info(getContext().getString(R.string.food_four_name),
                getContext().getString(R.string.food_four_details),
                R.drawable.koeksisters,      //TODO: ADD CORRECT IMAGES
                getContext().getString(R.string.food_four_description),
                getContext().getString(R.string.food_four_location)));

        // Create an {@link InfoAdapter} and populates with data sourced from {@link Info}.
        ListInfoAdapter adapter = new ListInfoAdapter(getActivity(), info);

        // Finds the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There is a view ID called list in the list_view.xml file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Sets the {@link ListView} to use the {@link InfoAdapter} to display list items for each {@link Info} object.
        listView.setAdapter(adapter);

        // Sets an onItemClickListener(), gets the position of clicked item, and calls an explicit intent.
        // Extras sent to the {@link DetailsActivity} include all {@link Info} object data, except for distance.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Info item = info.get(position);
                Intent details = new Intent(getContext(), DetailsActivity.class);
                details.putExtra(KEY_NAME.get ( ), item.getName());
                details.putExtra(KEY_LOCATION.get ( ), item.getLocation());
                details.putExtra(KEY_DETAILS.get ( ), item.getDetails());
                details.putExtra(KEY_DESCRIPTION.get ( ), item.getDescription());
                details.putExtra(KEY_DRAWABLE.get ( ), item.getImageResourceId());
                startActivity(details);
            }
        });

        return rootView;
    }
}