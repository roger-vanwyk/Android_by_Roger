package android.tangleddroid.roger;

/*
* This Activity will display only after initial launch, an upgrade, or when the app gets reinstalled.
*
* Users may access it again, through the app menu.
*
* Using TextSwitcher to navigate through the Help|Introduction screen.*/

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

    //    Initiates Views
    TextSwitcher textSwitcherIntro;
    TextView textView;
    Button previousTextButton, nextTextButton, shareAppButton;

    String[] stringTextSwitcher = {"Use the buttons to navigate through instructions", "Click on a project image to view its details",
            "Long click a project image to test its functionality via emulator", "Share the app with others of interest", "Call or email me directly from this app"};

    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        previousTextButton = findViewById(R.id.button_prev_text);
        nextTextButton = findViewById(R.id.button_next_text);
        shareAppButton = findViewById(R.id.button_share_app);
        textSwitcherIntro = findViewById(R.id.textSwitcherIntro);
        textSwitcherIntro.setFactory(() -> {
//                Creates TextView
            textView = new TextView(IntroActivity.this);
//                Sets text gravity to top-and-center_horizontal
            textView.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            textView.setTextSize(36);
            return textView;


//        Displays message to guide user
        });
    }
}

/*//    Requests permission to send SMS
                private void requestPermission () {
                    ActivityCompat.requestPermissions(IntroActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);
                }*/