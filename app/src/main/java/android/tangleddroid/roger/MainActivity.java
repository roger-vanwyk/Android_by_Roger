package android.tangleddroid.roger;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

//    Initiate pressedTime
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //        Check if app is opened for the first time
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE); //Method set private so PREFERENCE is only accessible by this app
        String FirstTime = preferences.getString("FirstTimeLaunch", "");

        if (FirstTime.equals("yes")) {
//            If app was opened before
            Toast.makeText(this, "Welcome back", Toast.LENGTH_SHORT).show();

        } else {
//            If opened for the first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("FirstTimeLaunch", "yes");
            editor.apply();

//            This shows the introduction activity on first launch or re-installation of app
            Intent prefIntent = new Intent(MainActivity.this, IntroActivity.class);
            startActivity(prefIntent); // The intro activity can also be launch from the menu bar

            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
        }

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

//    Sets doubleBackPress to exit
    @Override
    public void onBackPressed() {

//        Allows user to exit app by clicking back twice with 1500 from popup message
        if (pressedTime + 1500 > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit app", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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