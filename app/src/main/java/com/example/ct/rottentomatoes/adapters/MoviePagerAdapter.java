package com.example.ct.rottentomatoes.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ct.rottentomatoes.fragments.MyFragment;


public class MoviePagerAdapter extends FragmentStatePagerAdapter {
    public enum PAGES {
        BOX_OFFICE,
        UPCOMING,
        IN_THEATERS,
        OPENING
    }

    private static final int PAGE_COUNT = 4;
    private static final String movieTitles[] = {"Box Office", "Upcoming", "In Theaters", "Opening"};

    public MoviePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int i) {
        return MyFragment.newInstance(PAGES.values()[i]);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return movieTitles[position];
    }

}
