package com.zizi.mouad.apprentissageacademy;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.zizi.mouad.apprentissageacademy.Adapters.Lycee3Page;

public class ActivityLycee3 extends AppCompatActivity {
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    TabItem tabCours,tabVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lycee3);
        //init wideget
        tabLayout = findViewById(R.id.tab_lyc_3);
        viewPager = findViewById(R.id.lycee3_vp);
        tabCours = findViewById(R.id.cours_tabl3);
        tabVideo = findViewById(R.id.video_tabl3);

        pagerAdapter = new Lycee3Page(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);



        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
