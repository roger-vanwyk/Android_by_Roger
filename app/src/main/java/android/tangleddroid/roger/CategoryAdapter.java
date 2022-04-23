package android.tangleddroid.roger;

/*Created 12/2019 by rogervw*/

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

@SuppressWarnings("ALL")
public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    /**
     * Create a {@link CategoryAdapter} object.
     *
     * @param fm stands for the fragment manager that keeps the state in the adapter when being swiped.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
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
        } else if (position == 1) {
            return new AttractionsFragment();
        } else if (position == 2) {
            return new FoodFragment();
        } else if (position == 3) {
            return new AccommodationFragment();
        } else {
            return new EventsFragment();
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
            return "ABND";
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