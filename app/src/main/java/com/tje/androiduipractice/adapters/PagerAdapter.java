package com.tje.androiduipractice.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tje.androiduipractice.fragments.FragmentOne;
import com.tje.androiduipractice.fragments.FragmentThree;
import com.tje.androiduipractice.fragments.FragmentTwo;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumberOfTabs;

    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        mNumberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fr = null;

        if (position == 0) {
            FragmentOne frag1 = new FragmentOne();
            fr = frag1;
        }
        else if (position == 1) {
            FragmentTwo frag2 = new FragmentTwo();
            fr = frag2;
        }
        else if (position == 2) {
            FragmentThree frag3 = new FragmentThree();
            fr = frag3;
        }

        return fr;
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }
}
