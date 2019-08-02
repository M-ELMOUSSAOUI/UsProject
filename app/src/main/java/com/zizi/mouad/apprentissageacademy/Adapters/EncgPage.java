package com.zizi.mouad.apprentissageacademy.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.zizi.mouad.apprentissageacademy.AFragments.Cours_ENSA;
import com.zizi.mouad.apprentissageacademy.AFragments.Cours_Encg;
import com.zizi.mouad.apprentissageacademy.AFragments.VideoEnsa;
import com.zizi.mouad.apprentissageacademy.AFragments.Video_Encg;

public class EncgPage extends FragmentPagerAdapter {
    private int numOfTab;

    public EncgPage (FragmentManager fm, int numOfTab) {
        super(fm);
        this.numOfTab = numOfTab;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0 : fragment = new Cours_Encg();
                break;

            case 1 : fragment= new Video_Encg();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return numOfTab;
    }
}
