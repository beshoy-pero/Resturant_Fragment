package com.beshoykamal.resturantfragment.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.beshoykamal.resturantfragment.FirestFragment;
import com.beshoykamal.resturantfragment.R;
import com.beshoykamal.resturantfragment.SecondFragment;
import com.beshoykamal.resturantfragment.ThirdFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0)
            return new FirestFragment();
        else if (position==1)
            return new SecondFragment();
        else
            return new ThirdFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0)
            return "New";
        else if (position==1)
            return "Offer";
        else
            return "Win";

    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}