package com.zizi.mouad.apprentissageacademy.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.zizi.mouad.apprentissageacademy.AFragments.CoursCollege2;
import com.zizi.mouad.apprentissageacademy.AFragments.VideoCollege2;

public class College2Page extends FragmentPagerAdapter {



    public College2Page(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0 : fragment = new CoursCollege2();
                break;

            case 1 : fragment= new VideoCollege2();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
