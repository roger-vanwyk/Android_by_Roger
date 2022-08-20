package android.tangleddroid.roger.onboarding;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.tangleddroid.roger.R;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

/**
 * Created on 19/08/2022 by RogerVw.
 *
 * Logic for the Onboarding screen*/
public class OnboardingActivity extends AppCompatActivity {

    private ViewPager viewPager;
    OnboardingAdapter onboardingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_three);
        makeStatusbarTransparent();

        viewPager = findViewById(R.id.onboarding_three_view_pager);

        onboardingAdapter = new OnboardingAdapter(OnboardingActivity.this);
        viewPager.setAdapter(onboardingAdapter);
        viewPager.setPageTransformer(false, new OnboardingPageTransformer());


    }

    // Listener for next button press
    public void nextPage(View view) {
        if (view.getId() == R.id.button2) {
            if (viewPager.getCurrentItem() < onboardingAdapter.getCount() - 1) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            }
        }
    }

    private void makeStatusbarTransparent() {

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

   /* private void setOnboardingItem() {
        List<OnBoardingItem> onBoardingItems = new ArrayList<>();

        OnBoardingItem itemFastFood = new OnBoardingItem();
        itemFastFood.setTitle("Android Development");
        itemFastFood.setDescription("View projects, code, emulators, etc.!");
        itemFastFood.setImage(R.drawable.rvw_logo_emoji_gram_round);

        OnBoardingItem itemPayOnline = new OnBoardingItem();
        itemPayOnline.setTitle("Communicate");
        itemPayOnline.setDescription("Call,email, or virtually meet with me!");
        itemPayOnline.setImage(R.drawable.eat_together);

        OnBoardingItem itemEatTogether = new OnBoardingItem();
        itemEatTogether.setTitle("Design");
        itemEatTogether.setDescription("Following Android's Material Design guidelines!");
        itemEatTogether.setImage(R.drawable.on_the_way);

        OnBoardingItem itemDayAndNight = new OnBoardingItem();
        itemDayAndNight.setTitle("Day and Night");
        itemDayAndNight.setDescription("Try themes for both day and night!");
        itemDayAndNight.setImage(R.drawable.day_and_night);

        onBoardingItems.add(itemFastFood);
        onBoardingItems.add(itemPayOnline);
        onBoardingItems.add(itemEatTogether);
        onBoardingItems.add(itemDayAndNight);

        onboardingAdapter = new OnboardingAdapter(onBoardingItems);*/

    }
}