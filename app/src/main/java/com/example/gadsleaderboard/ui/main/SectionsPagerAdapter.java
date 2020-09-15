package com.example.gadsleaderboard.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gadsleaderboard.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;
    private  final List<Fragment> fragmentList = new ArrayList<>();

    //Avoid Hard coding try to use one Fragment and a View Model
    GADSDeveloperHoursFragment gadsDeveloperHoursFragment = GADSDeveloperHoursFragment.newInstance(1);
    GADSDeveloperIQSkillsFragment gadsDeveloperIQSkillsFragment = GADSDeveloperIQSkillsFragment.newInstance(2);

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        fragmentList.add(gadsDeveloperHoursFragment);
        fragmentList.add(gadsDeveloperIQSkillsFragment);

        return fragmentList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return TAB_TITLES.length;
    }
}