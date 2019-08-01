package com.zizi.mouad.apprentissageacademy.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.zizi.mouad.apprentissageacademy.AFragments.CoursLycee1;
import com.zizi.mouad.apprentissageacademy.AFragments.VideoLycee1;


public class Lycee1Page extends FragmentPagerAdapter {

    public Lycee1Page(FragmentManager fm) {
        super(fm);

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
        return 2;
    }
}
