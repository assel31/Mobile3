package com.qazaq.android.mobile3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

public class OnboardingActivity extends AppCompatActivity {

    public static final String COMPLETED_ONBOARDING_PREF_NAME = "not_first_usage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_onboarding);

        PaperOnboardingPage scr1 = new PaperOnboardingPage("Новый формат",
                "Будь одним из первых изучивщим казахский язык на латинице",
                Color.parseColor("#9B90BC"), R.drawable.meeting, R.drawable.onboarding_pager_circle_icon);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Большой набор текстов",
                "Мы предоставим различные тексты для практики",
                Color.parseColor("#65B0B4"), R.drawable.books, R.drawable.onboarding_pager_circle_icon);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Тренировки",
                "Тренируйся и научись читать без проблем на латинице!",
                Color.parseColor("#678FB4"), R.drawable.degree, R.drawable.onboarding_pager_circle_icon);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);

        PaperOnboardingFragment onBoardingFragment = PaperOnboardingFragment.newInstance(elements);

        onBoardingFragment.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                SharedPreferences.Editor sharedPreferencesEditor =
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
                sharedPreferencesEditor.putBoolean(
                        COMPLETED_ONBOARDING_PREF_NAME, true);
                sharedPreferencesEditor.apply();
                finish();
            }
        });

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.onboarding_container, onBoardingFragment);
        fragmentTransaction.commit();
    }
}
