package com.zizi.mouad.apprentissageacademy.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.zizi.mouad.apprentissageacademy.AFragments.CoursLycee1;
import com.zizi.mouad.apprentissageacademy.AFragments.VideoLycee1;


public class Lycee1Page extends FragmentPagerAdapter {
    private int numOfTab;

    public Lycee1Page(FragmentManager fm,int numOfPage) {
        super(fm);
        this.numOfTab=numOfPage;

    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0 : fragment = new CoursLycee1();
                break;

            case 1 : fragment= new VideoLycee1();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return numOfTab;
    }
}
