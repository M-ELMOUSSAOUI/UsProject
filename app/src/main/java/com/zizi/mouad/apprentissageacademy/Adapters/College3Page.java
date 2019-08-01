package com.zizi.mouad.apprentissageacademy.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.zizi.mouad.apprentissageacademy.AFragments.CoursCollege3;
import com.zizi.mouad.apprentissageacademy.AFragments.VideoCollege3;

public class College3Page extends FragmentPagerAdapter {

    public College3Page(FragmentManager fm) {
        super(fm);

    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0 : fragment = new CoursCollege3();
                break;

            case 1 : fragment= new VideoCollege3();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
