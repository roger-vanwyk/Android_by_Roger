package android.tangleddroid.roger;

/*Created 12/2019 by rogervw*/

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class DetailsActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String attractionName = "";
        String attractionLocation = "";
        String attractionDetails = "";
        String attractionDescription = "";

        // Gets String extras from clicked ListView item
        Intent intent = getIntent();
        if (null != intent) {
            attractionName = intent.getStringExtra(KEY_NAME.get ( ));
            attractionLocation = intent.getStringExtra(KEY_LOCATION.get ( ));
            attractionDetails = intent.getStringExtra(KEY_DETAILS.get ( ));
            attractionDescription = intent.getStringExtra(KEY_DESCRIPTION.get ( ));
        }

        // Gets image resource ID from clicked ListView item and stores in attractionDrawable variable
        // Reference: https://stackoverflow.com/questions/1392521/how-can-i-get-image-resource-id-and-send-it-to-other-activity-in-android
        Bundle extras = Objects.requireNonNull(getIntent()).getExtras();
        int attractionDrawable = extras.getInt(KEY_DRAWABLE.get ( ));

        // Finds ImageView and sets the image resource ID to clicked ListView item object
        ImageView imageView = findViewById(R.id.attraction_drawable);
        imageView.setImageResource(attractionDrawable);

        // Finds TextView and sets text to clicked ListView item object
        TextView attractionNameText = findViewById(R.id.attraction_name);
        attractionNameText.setText(attractionName);

        // Finds TextView and sets text to clicked ListView item object
        TextView attractionLocationText = findViewById(R.id.attraction_location);
        attractionLocationText.setText(attractionLocation);
        attractionLocationText.setMovementMethod(LinkMovementMethod.getInstance());

        // Finds TextView and sets text to clicked ListView item object
        TextView attractionDetailsText = findViewById(R.id.attraction_details);
        attractionDetailsText.setText(attractionDetails);

        // Finds TextView and sets text to clicked ListView item object
        TextView attractionDescriptionText = findViewById(R.id.attraction_description);
        attractionDescriptionText.setText(attractionDescription);
    }


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
}