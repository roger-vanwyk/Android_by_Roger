package android.tangleddroid.roger;

/*Created 12/2019 by rogervw*/

import android.content.Intent;
import android.os.Bundle;
import android.tangleddroid.roger.card.CardActivity;
import android.tangleddroid.roger.guide.GuideActivity;
import android.tangleddroid.roger.musical.MusicActivity;
import android.tangleddroid.roger.news.NewsActivity;
import android.tangleddroid.roger.quiz.QuizActivity;
import android.tangleddroid.roger.scorekeeper.ScorekeeperActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class JavaFragment extends Fragment {

    private ImageView proj1Img, proj2Img, proj3Img, proj4Img, proj5Img, proj6Img;

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

    public JavaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // Creates a list of sights
        final ArrayList<Info> info = new ArrayList<Info>();
        info.add(new Info(getContext().getString(R.string.java_one_name),
                getContext().getString(R.string.java_one_details),
//                R.drawable.south_africa_cpt,
                R.drawable.proj1,
                getContext().getString(R.string.sight_one_description),
                getContext().getString(R.string.java_one_location)));
        info.add(new Info(getContext().getString(R.string.java_two_name),
                getContext().getString(R.string.java_two_details),
//                R.drawable.durban_waterfront,
                R.drawable.proj2,
                getContext().getString(R.string.java_two_description),
                getContext().getString(R.string.java_two_location)));
        info.add(new Info(getContext().getString(R.string.java_three_name),
                getContext().getString(R.string.java_three_details),
//                R.drawable.drakensberg,
                R.drawable.proj3,
                getContext().getString(R.string.java_three_description),
                getContext().getString(R.string.java_three_location)));
        info.add(new Info(getContext().getString(R.string.java_four_name),
                getContext().getString(R.string.java_four_details),
//                R.drawable.blyde_river_canyon,
                R.drawable.proj4,
                getContext().getString(R.string.java_four_description),
                getContext().getString(R.string.java_four_location)));
        info.add(new Info(getContext().getString(R.string.java_five_name),
                getContext().getString(R.string.java_five_details),
//                R.drawable.blyde_river_canyon,
                R.drawable.proj5,
                getContext().getString(R.string.java_five_description),
                getContext().getString(R.string.java_five_location)));
        info.add(new Info(getContext().getString(R.string.java_six_name),
                getContext().getString(R.string.java_six_details),
//                R.drawable.blyde_river_canyon,
                R.drawable.proj6,
                getContext().getString(R.string.java_six_description),
                getContext().getString(R.string.java_six_location)));

        // Create an {@link InfoAdapter} and populates with data sourced from {@link Info}.
        InfoAdapter adapter = new InfoAdapter(getActivity(), info);

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
                details.putExtra(KEY_NAME.get(), item.getName());
                details.putExtra(KEY_LOCATION.get(), item.getLocation());
                details.putExtra(KEY_DETAILS.get(), item.getDetails());
                details.putExtra(KEY_DESCRIPTION.get(), item.getDescription());
                details.putExtra(KEY_DRAWABLE.get(), item.getImageResourceId());
                startActivity(details);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {

                // String value =(String)lv.getItemAtPosition(position);

                if (position == 0) {
                    Intent intent = new Intent(getContext(), CardActivity.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(getContext(), ScorekeeperActivity.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(getContext(), QuizActivity.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(getContext(), MusicActivity.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(getContext(), GuideActivity.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(getContext(), NewsActivity.class);
                    startActivity(intent);

                }

                return true;
            }

            ;

        /*//        Project 1
        ImageView proj1Img = (ImageView) getActivity().findViewById(R.drawable.proj1);
        proj1Img.setOnClickListener(v -> {
            //            OnClickListener for ImageButton opens CardActivity onClick
            Intent project1Intent = new Intent(getView().getContext(), CardActivity.class);
            startActivity(project1Intent);

            Toast.makeText(getApplicationContext(), "Card", Toast.LENGTH_SHORT).show();
        });

//        Project 2
        ImageView proj2Img = (ImageView) getActivity().findViewById(R.drawable.proj2);
        proj2Img.setOnClickListener(v -> {
            //            OnClickListener for ImageButton opens CardActivity onClick
            Intent project2Intent = new Intent(getView().getContext(), ScorekeeperActivity.class);
            startActivity(project2Intent);

            Toast.makeText(getApplicationContext(), "Scorekeeper", Toast.LENGTH_SHORT).show();
        });

//        Project 3
        ImageView proj3Img = (ImageView) getActivity().findViewById(R.drawable.proj3);
        proj3Img.setOnClickListener(v -> {
            //            OnClickListener for ImageButton opens QuizActivity onClick
            Intent project3Intent = new Intent(getView().getContext(), QuizActivity.class);
            startActivity(project3Intent);

            Toast.makeText(getApplicationContext(), "Quiz", Toast.LENGTH_SHORT).show();
        });

//        Project 4
        ImageView proj4Img = (ImageView) getActivity().findViewById(R.drawable.proj4);
        proj4Img.setOnClickListener(v -> {
            //            OnClickListener for ImageButton opens MusicActivity onClick
            Intent project4Intent = new Intent(getView().getContext(), MusicActivity.class);
            startActivity(project4Intent);

            Toast.makeText(getApplicationContext(), "Music", Toast.LENGTH_SHORT).show();
        });

//        Project 5
        ImageView proj5Img = (ImageView) getActivity().findViewById(R.drawable.proj5);
        proj5Img.setOnClickListener(v -> {
            //            OnClickListener for ImageButton opens GuideActivity onClick
            Intent project5Intent = new Intent(getView().getContext(), GuideActivity.class);
            startActivity(project5Intent);

            Toast.makeText(getApplicationContext(), "Guide", Toast.LENGTH_SHORT).show();
        });

//        Project 6
        ImageView proj6Img = (ImageView) getActivity().findViewById(R.drawable.proj6);
        proj6Img.setOnClickListener(v -> {
            //            OnClickListener for ImageButton opens NewsActivity onClick
            Intent project6Intent = new Intent(getView().getContext(), NewsActivity.class);
            startActivity(project6Intent);

            Toast.makeText(getApplicationContext(), "News", Toast.LENGTH_SHORT).show();
        });*/

        });
    return rootView;
    }
}