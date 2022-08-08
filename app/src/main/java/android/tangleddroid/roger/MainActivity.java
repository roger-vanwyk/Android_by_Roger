package android.tangleddroid.roger;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*//Initiate boolean isAppInstalledOrNot()
        private final boolean isAppInstalledOrNot;*/
//    Initiate FABs
    FloatingActionButton fabMain, fabCall, fabEmail, fabMeet;
    //    Initiate pressedTime
    private long pressedTime;

    WebView webView;

/*//    Initiate PackageManager
    PackageManager pm;*/
/*//Initiate String
    String s;*/

/*//    Required empty constructor
    public MainActivity(boolean isAppInstalledOrNot) {
        this.isAppInstalledOrNot = isAppInstalledOrNot;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        checkSharedPreferences();
        setTabToViewpager();

        //        Connect Views to FloatingActionButtons
        fabMain = findViewById(R.id.fabMain);
        fabCall = findViewById(R.id.fabCall);
        fabEmail = findViewById(R.id.fabEmail);
        fabMeet = findViewById(R.id.fabMeet);

//        Sets onClickListener for each FAB
        fabMain.setOnClickListener(this);
        fabCall.setOnClickListener(this);
        fabEmail.setOnClickListener(this);
        fabMeet.setOnClickListener(this);
    }

    private void setTabToViewpager() {
        // Find the ViewPager that allows the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewpager);

        // Create an adapter that knows where each fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        // Set adapter onto the ViewPager
        viewPager.setAdapter(adapter);

        // Find the TabLayout that shows the category tabs
        TabLayout tabLayout = findViewById(R.id.tabs);

        // Connect the TabLayout with the ViewPager.
        // This will update the tabs and ViewPager according to each swipe.
        tabLayout.setupWithViewPager(viewPager);
    }

    private void checkSharedPreferences() {
        //        Check if app is opened for the first time
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE); //Method set private so PREFERENCE is only accessible by this app
        String FirstTime = preferences.getString("FirstTimeLaunch", "");

        if (FirstTime.equals("")) {
            //            If opened for the first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("FirstTimeLaunch", "yes");
            editor.apply();

//            This shows the introduction activity on first launch or re-installation of app
            Intent prefIntent = new Intent(MainActivity.this, IntroActivity.class);
            startActivity(prefIntent); // The intro activity can also be launch from the menu bar

            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();

        } else {
//            If app was opened before
            Toast.makeText(this, "Welcome back", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fabMain:
                if (fabCall.isShown()) {
                    fabCall.hide();
                    fabEmail.hide();
                    fabMeet.hide();
                } else {
                    fabCall.show();
                    fabEmail.show();
                    fabMeet.show();
                }
                break;
            case R.id.fabCall:
                callRogerVanWyk();
                break;
            case R.id.fabEmail:
                emailRogerVanWyk();
                break;
            case R.id.fabMeet:
                meetRogerVanWyk();
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grandResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grandResults);
        if (requestCode == 1) {
            if (grandResults[0] == PackageManager.PERMISSION_GRANTED) {
                callRogerVanWyk();
            } else {
                Toast.makeText(this, "Oh No!! Permission Denied. Try Again!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void meetRogerVanWyk() {
        Toast.makeText(this, "Meeting with Roger", Toast.LENGTH_SHORT).show();

        PackageManager pm = getPackageManager();
        boolean installed = false;

        while (!installed) {
            installed = appInstalledOrNot("com.jitsi.meeu");
            if (installed) {
                Toast.makeText(this, "App installed", Toast.LENGTH_SHORT).show();

                Log.i("RogDroidLog", "Application is already installed");

                //                This Intent launch the package if it's already installed on device
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.jitsi.meeu");
                launchIntent = new Intent(MainActivity.this, (getPackageManager().getLaunchIntentForPackage("com.jitsi.meeu")).getClass());
                startActivity(launchIntent);

                return;
            } else {
//                Download and install application
                Intent installJitsi = new Intent("android.intent.action.VIEW");
                installJitsi.setData(Uri.parse("https://drive.google.com/file/d/1J1m6IjPES8bhez9i_epojXD6PzWMSHb7/view?usp=drivesdk"));
                startActivity(installJitsi);
                Log.i("RogDroidLog", "Require JitsiMeet app to be installed");
            }
            try {

                pm.getPackageInfo("com.jitsi.meeu", PackageManager.GET_ACTIVITIES);
            } catch (PackageManager.NameNotFoundException ignored) {
            }
            startActivity(getPackageManager().getLaunchIntentForPackage("com.jitsi.meeu"));
        }
        return;
    }

    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;

        /*String html = "<!DOCTYPE html>\n" +
                "    <html>\n" +
                "      <head>\n" +
                "        <script src='https://8x8.vc/external_api.js' async></script>\n" +
                "        <style>html, body, #jaas-container { height: 100%; }</style>\n" +
                "        <script type=\"text/javascript\">\n" +
                "          window.onload = () => {\n" +
                "            const api = new JitsiMeetExternalAPI(\"8x8.vc\", {\n" +
                "              roomName: \"vpaas-magic-cookie-b5b47f64f28a44178840f264e2b05986/AndroidByRogerJitsiMeeting\",\n" +
                "              parentNode: document.querySelector('#jaas-container')\n" +
                "            });\n" +
                "          }\n" +
                "        </script>\n" +
                "      </head>\n" +
                "      <body><div id=\"jaas-container\" /></body>\n" +
                "    </html>";

        webView.loadData(html, "text/javascript", null);*/
    }

    private void emailRogerVanWyk() {
        Toast.makeText(this, "Emailing Roger", Toast.LENGTH_SHORT).show();
        Intent compileEmail = new Intent(Intent.ACTION_SEND);
        compileEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"roger.vanwyk@gmail.com"});
        compileEmail.putExtra(Intent.EXTRA_SUBJECT, "Android_By_Roger Android Portfolio");
        compileEmail.setType("message/rfc822");
        startActivity(Intent.createChooser(compileEmail, "Choose email app"));
    }

    private void callRogerVanWyk() {
        Toast.makeText(this, "Calling Roger", Toast.LENGTH_SHORT).show();

        Intent callRogerIntent = new Intent(Intent.ACTION_CALL);

        callRogerIntent.setData(Uri.parse("tel: 0789871987"));

        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
        } else {

            startActivity(callRogerIntent);
            finish();       //  Without this, call would be re-occurring...
        }

        requestPermission();

    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
    }

    //    Sets doubleBackPress to exit
    @Override
    public void onBackPressed() {

        doublePressBackToExit();
    }

    private void doublePressBackToExit() {
        //        Allows user to exit app by clicking back twice with 1000 from popup message
        if (pressedTime + 1500 > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit app", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
//Opens AboutActivity onClick menuItem
            Intent scrollingIntent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(scrollingIntent);
//                return true;
        }
        if (id == R.id.action_intro) {
//            Opens IntroActivity onClick menuItem
            Intent introIntent = new Intent(MainActivity.this, IntroActivity.class);
            startActivity(introIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}