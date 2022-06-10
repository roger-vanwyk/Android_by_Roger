package android.tangleddroid.roger;

/*
* This Activity will display only after initial launch, an upgrade, or when the app gets reinstalled.
*
* Users may access it again, through the app menu.
*
* Using TextSwitcher to navigate through the Help|Introduction screen.*/

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class IntroActivity extends AppCompatActivity {

    TextSwitcher textSwitcher;
    TextView textView;
    Button previousTextButton, nextTextButton, shareAppButton;

    String stringTextSwitcher[]={"Use the buttons to navigate through instructions", "Click on a project image to view its details",
            "Long click a project image to test its functionality via emulator", "Share the app with others of interest", "Call or email me directly from this app"};

    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        previousTextButton=(Button) findViewById(R.id.button_prev_text);
        nextTextButton=(Button) findViewById(R.id.button_next_text);
        shareAppButton=(Button) findViewById(R.id.button_share_app);
        textSwitcher=(TextSwitcher) findViewById(R.id.textSwitcherIntro);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
//                Creates TextView
                textView = new TextView(IntroActivity.this);
//                Sets text gravity to top-and-center_horizontal
                if (textView != null) {
                    textView.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                    textView.setTextSize(36);
//                    return textView;
                }


//        Displays message to guide user
                textSwitcher.setCurrentText("Click buttons to switch between text");

//        Sets OnClickListener for the previousTextButton
                previousTextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (currentIndex > 0)
                            currentIndex = currentIndex - 1;
                        textSwitcher.setText(stringTextSwitcher[currentIndex]); //Sets text in TextSwitcher
                    }
                });

//        Sets OnClickListener for the nextTextButton
                nextTextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (currentIndex < stringTextSwitcher.length - 1)
                            currentIndex = currentIndex + 1;
                        textSwitcher.setText(stringTextSwitcher[currentIndex]);
                    }
                });


//        Sets OnClickListener for the shareApptButton
                shareAppButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Hey, check out this app");
//                        String app_url = "";
                        String emailAddress = "roger.vanwyk@gmail.com";
                        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, emailAddress);
                        startActivity(Intent.createChooser(shareIntent, "Share via"));
                    }
                });
                return textView;
            }

//    Requests permission to send SMS
                private void requestPermission () {
                    ActivityCompat.requestPermissions(IntroActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);
                }
        });
    }
}