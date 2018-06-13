package com.dawnsoft.dawn.nepalyoga.loginfrags;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by dawn on 3/22/2018.
 */

public class SigninFragmentPagerAdapter extends FragmentPagerAdapter{

    public SigninFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0){
            return new SignInFragment();
        }else {
            return new SignUpFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
