package com.zizi.mouad.apprentissageacademy.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.zizi.mouad.apprentissageacademy.AFragments.CoursLycee2;
import com.zizi.mouad.apprentissageacademy.AFragments.VideoLycee1;

public class Lycee2Page extends FragmentPagerAdapter {

    public Lycee2Page(FragmentManager fm) {
        super(fm);

    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0 : fragment = new CoursLycee2();
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
