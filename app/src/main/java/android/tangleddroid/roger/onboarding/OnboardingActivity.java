package android.tangleddroid.roger.onboarding;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.tangleddroid.roger.MainActivity;
import android.tangleddroid.roger.R;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 19/08/2022 by RogerVw.
 *
 * Logic for the Onboarding screen*/
public class OnboardingActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private OnboardingAdapter onboardingAdapter;
    private MaterialButton buttonOnboardingAction;
    private LinearLayout layoutOnboardingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_design_one);

        layoutOnboardingIndicator = findViewById(R.id.layoutOnboardingIndicators);
        buttonOnboardingAction = findViewById(R.id.buttonOnBoardingAction);

        setOnboardingItem();

        ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);

        setOnboadingIndicator();
        setCurrentOnboardingIndicators(0);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicators(position);
            }
        });

        buttonOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onboardingViewPager.getCurrentItem() + 1 < onboardingAdapter.getItemCount()) {
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });
    }

    private void setOnboadingIndicator() {
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(), R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicator.addView(indicators[i]);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setCurrentOnboardingIndicators(int index) {
        int childCount = layoutOnboardingIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutOnboardingIndicator.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_inactive));
            }
        }
        if (index == onboardingAdapter.getItemCount() - 1){
            buttonOnboardingAction.setText("Start");
        }else {
            buttonOnboardingAction.setText("Next");
        }
    }

    private void setOnboardingItem() {
        List<OnBoardingItem> onBoardingItems = new ArrayList<>();

        OnBoardingItem itemFastFood = new OnBoardingItem();
        itemFastFood.setTitle("Projects");
        itemFastFood.setDescription("View projects written in Java &amp/; Kotlin.");
        itemFastFood.setImage(R.drawable.rvw_logo_emoji_gram_round);

        OnBoardingItem itemPayOnline = new OnBoardingItem();
        itemPayOnline.setTitle("Emulator");
        itemPayOnline.setDescription("Run and test projects without installation");
        itemPayOnline.setImage(R.drawable.onboarding_activity_ic_image_2);

        OnBoardingItem itemEatTogether = new OnBoardingItem();
        itemEatTogether.setTitle("Communicate");
        itemEatTogether.setDescription("Call, e-mail, or let's meet virtually!");
        itemEatTogether.setImage(R.drawable.onboarding_activity_ic_image_1);

        onBoardingItems.add(itemFastFood);
        onBoardingItems.add(itemPayOnline);
        onBoardingItems.add(itemEatTogether);

        onboardingAdapter = new OnboardingAdapter(onBoardingItems);
    }
}