package com.dawnsoft.dawn.nepalyoga;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dawnsoft.dawn.nepalyoga.loginfrags.SigninFragmentPagerAdapter;


public class LoginActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        ViewPager signInViewpager = (ViewPager) findViewById(R.id.signin_viewpager);
        SigninFragmentPagerAdapter signinAdapter = new SigninFragmentPagerAdapter(getSupportFragmentManager());
        signInViewpager.setAdapter(signinAdapter);
    }
}
