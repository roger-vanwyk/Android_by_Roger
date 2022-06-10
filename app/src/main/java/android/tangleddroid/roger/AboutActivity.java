package android.tangleddroid.roger;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

//    Initiate call button
    Button callButton;

    /*//    Use the FloatingActionButton to call and email contact
    FloatingActionButton mPhoneContact, mMailContact;


    //    Use ExtendedFloatingActionButton to handle the parent FAB
    ExtendedFloatingActionButton mAddFab;

    //    TextViews to be made visible and invisible
    TextView phoneContactText, mailContactText;

    //    Check if Fabs are visible or not
    Boolean isAllFabsVisible;*/

//    private ActivityScrollingBinding binding;

    private int telNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        /*binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());*/

        /*Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());*/

        /*FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        /*mAddFab = findViewById(R.id.fab);

        mPhoneContact = findViewById(R.id.phone_contact_fab);
        mMailContact = findViewById(R.id.email_contact_fab);

        phoneContactText = findViewById(R.id.phone_contact_text);
        mailContactText = findViewById(R.id.mail_contact_text);

        mPhoneContact.setVisibility(View.GONE);
        mMailContact.setVisibility(View.GONE);
        phoneContactText.setVisibility(View.GONE);
        mailContactText.setVisibility(View.GONE);

        isAllFabsVisible = false;

        mAddFab.shrink();

        mAddFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isAllFabsVisible){
                            mPhoneContact.show();
                            mMailContact.show();
                            phoneContactText.setVisibility(View.VISIBLE);
                            mailContactText.setVisibility(View.VISIBLE);

                            mAddFab.extend();

                            isAllFabsVisible = true;
                        } else {
                            mPhoneContact.hide();
                            mMailContact.hide();
                            phoneContactText.setVisibility(View.GONE);
                            mailContactText.setVisibility(View.GONE);

                            mAddFab.shrink();

                            isAllFabsVisible = false;
                        }
                    }
                }
        );

        mPhoneContact.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ScrollingActivity.this, "Phone Contact", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        mMailContact.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ScrollingActivity.this, "Email Contact", Toast.LENGTH_SHORT).show();
                    }
                }
        );*/

        Button callButton =(Button) findViewById(R.id.callButton);
        callButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        makeCall();
                        dailNumber();
                    }

                    private void dailNumber() {
                        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                        dialIntent.setData(Uri.parse("tel:"+"+"+telNum));  //  Replace with your own number
                        startActivity(dialIntent);
                    }

                    private void makeCall() {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:"+"+"+telNum));  //  Replace with your own number
                        startActivity(callIntent);
                    }
                }
        );
    }
}