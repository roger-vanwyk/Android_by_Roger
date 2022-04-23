package android.tangleddroid.roger.musical;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.tangleddroid.roger.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;


@SuppressWarnings("deprecation")
public class MusicActivity extends AppCompatActivity {
    ViewPager Tab;
    MusicTabPagerAdapter TabAdapter;
    ActionBar actionBar;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        TabAdapter = new MusicTabPagerAdapter(getSupportFragmentManager());

        Tab = findViewById(R.id.pager);
        Tab.addOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        actionBar = getSupportActionBar();
                        actionBar.setSelectedNavigationItem(position);
                    }
                });
        Tab.setAdapter(TabAdapter);

        actionBar = getSupportActionBar();
        //Enable Tabs on Action Bar
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {

            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                Tab.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        //Add New Tab
        actionBar.addTab(actionBar.newTab().setText(getString(R.string.tab_playlist)).setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText(getString(R.string.tab_artist)).setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText(getString(R.string.tab_album)).setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText(getString(R.string.tab_song)).setTabListener(tabListener));

    }
}