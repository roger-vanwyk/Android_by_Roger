package android.tangleddroid.roger.android_udacity.guide;

/*Created 12/2019 by rogervw*/

import android.content.Intent;
import android.os.Bundle;
import android.tangleddroid.roger.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class GuideSightsFragment extends Fragment {

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
    public static final ThreadLocal<String> KEY_DESCRIPTION = new ThreadLocal<String> ( ) {
        @Override
        protected String initialValue() {
            return "KEY_DESCRIPTION";
        }
    };
    public static final ThreadLocal<String> KEY_DRAWABLE = new ThreadLocal<String> ( ) {
        @Override
        protected String initialValue() {
            return "KEY_DRAWABLE";
        }
    };

    public GuideSightsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // Creates a list of sights
        final ArrayList<GuideInfo> guideInfo = new ArrayList<GuideInfo>();
        guideInfo.add(new GuideInfo(getContext().getString(R.string.sight_one_name),
                getContext().getString(R.string.sight_one_details),
                R.drawable.south_africa_cpt,
                getContext().getString(R.string.sight_one_description),
                getContext().getString(R.string.sight_one_location)));
        guideInfo.add(new GuideInfo(getContext().getString(R.string.sight_two_name),
                getContext().getString(R.string.sight_two_details),
                R.drawable.durban_waterfront,
                getContext().getString(R.string.sight_two_description),
                getContext().getString(R.string.sight_two_location)));
        guideInfo.add(new GuideInfo(getContext().getString(R.string.sight_three_name),
                getContext().getString(R.string.sight_three_details),
                R.drawable.drakensberg,
                getContext().getString(R.string.sight_three_description),
                getContext().getString(R.string.sight_three_location)));
        guideInfo.add(new GuideInfo(getContext().getString(R.string.sight_four_name),
                getContext().getString(R.string.sight_four_details),
                R.drawable.blyde_river_canyon,
                getContext().getString(R.string.sight_four_description),
                getContext().getString(R.string.sight_four_location)));

        // Create an {@link InfoAdapter} and populates with data sourced from {@link Info}.
        GuideInfoAdapter adapter = new GuideInfoAdapter(getActivity(), guideInfo);

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
                GuideInfo item = guideInfo.get(position);
                Intent details = new Intent(getContext(), GuideDetailsActivity.class);
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