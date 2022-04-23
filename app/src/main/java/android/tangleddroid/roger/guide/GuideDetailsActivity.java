package android.tangleddroid.roger.guide;

/*Created 12/2019 by rogervw*/

import android.content.Intent;
import android.os.Bundle;
import android.tangleddroid.roger.R;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class GuideDetailsActivity extends AppCompatActivity {

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
        Bundle extras = getIntent().getExtras();
        int attractionDrawable = extras.getInt(KEY_DRAWABLE.get ( ));

        // Finds ImageView and sets the image resource ID to clicked ListView item object
        ImageView imageView = (ImageView) findViewById(R.id.attraction_drawable);
        imageView.setImageResource(attractionDrawable);

        // Finds TextView and sets text to clicked ListView item object
        TextView attractionNameText = (TextView) findViewById(R.id.attraction_name);
        attractionNameText.setText(attractionName);

        // Finds TextView and sets text to clicked ListView item object
        TextView attractionLocationText = (TextView) findViewById(R.id.attraction_location);
        attractionLocationText.setText(attractionLocation);
        attractionLocationText.setMovementMethod(LinkMovementMethod.getInstance());

        // Finds TextView and sets text to clicked ListView item object
        TextView attractionDetailsText = (TextView) findViewById(R.id.attraction_details);
        attractionDetailsText.setText(attractionDetails);

        // Finds TextView and sets text to clicked ListView item object
        TextView attractionDescriptionText = (TextView) findViewById(R.id.attraction_description);
        attractionDescriptionText.setText(attractionDescription);
    }
}