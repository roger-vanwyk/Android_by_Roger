package android.tangleddroid.roger.guide;

/*Created 12/2019 by rogervw*/

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;

@SuppressWarnings("ALL")
public class GuideCategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    /**
     * Create a {@link GuideCategoryAdapter} object.
     *
     * @param fm stands for the fragment manager that keeps the state in the adapter when being swiped.
     */
    public GuideCategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Returns the {@link Fragment} that is displayed for the given position.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new GuideSightsFragment();
        } else if (position == 1) {
            return new GuideAttractionsFragment();
        } else if (position == 2) {
            return new GuideFoodFragment();
        } else if (position == 3) {
            return new GuideAccommodationFragment();
        } else {
            return new GuideEventsFragment();
        }
    }

    /**
     * Return the total number of fragment pages.
     */
    @Override
    public int getCount() {
        return 5;
    }

    /**
     * Provides the titles in the {@link TabLayout} for each fragment.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Sights";
        } else if (position == 1) {
            return "Activities";
        } else if (position == 2) {
            return "Food";
        } else if (position == 3) {
            return "Accommodation";
        } else {
            return "Events";
        }
    }
}