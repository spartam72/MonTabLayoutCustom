package com.example.spart.myapplication.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.Toolbar;

import com.example.spart.myapplication.BusinessFragment;
import com.example.spart.myapplication.MostPopularFragment;
import com.example.spart.myapplication.TopStoriesFragment;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public PageAdapter(FragmentManager fm,int numOfTabs) {
        super( fm );
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new TopStoriesFragment();
            case 1:
                return new MostPopularFragment();
            case 2:
                return new BusinessFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
