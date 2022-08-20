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
        viewPager.setPageTransformer(false, (ViewPager.PageTransformer) new OnboardingPageTransformer());


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
    }
}