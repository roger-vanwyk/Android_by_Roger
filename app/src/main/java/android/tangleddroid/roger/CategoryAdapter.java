package android.tangleddroid.roger;

/*Created 12/2019 by rogervw*/

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;

@SuppressWarnings("ALL")
public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    /**
     * Create a {@link CategoryAdapter} object.
     *  @param context
     * @param fm stands for the fragment manager that keeps the state in the adapter when being swiped.
     */
    public CategoryAdapter(MainActivity context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Returns the {@link Fragment} that is displayed for the given position.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new JavaFragment();
//            Temporarily decreasing number of category tabs display
        /*} else if (position == 1) {
            return new AttractionsFragment();
        } else if (position == 2) {
            return new FoodFragment();
        } else if (position == 3) {
            return new AccommodationFragment();*/
        } else {
            return new DrawingsFragment();
        }
    }

    /**
     * Return the total number of fragment pages.
     */
    @Override
    public int getCount() {
        return 2;
    }  // Original number = 5

    /**
     * Provides the titles in the {@link TabLayout} for each fragment.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Android Java";
        /*} else if (position == 1) {
            return "Kotlin";
        } else if (position == 2) {
            return "Other";
        } else if (position == 3) {
            return "Certifications";*/
        } else {
            return "Drawings";
        }
    }
}