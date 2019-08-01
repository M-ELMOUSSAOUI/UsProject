package com.zizi.mouad.apprentissageacademy;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.zizi.mouad.apprentissageacademy.Adapters.Lycee2Page;

public class ActivityLycee2 extends AppCompatActivity {
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    TabItem tabCours,tabVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lycee2);
        //init wideget
        tabLayout = findViewById(R.id.tab_lyc_2);
        viewPager = findViewById(R.id.lycee2_vp);
        tabCours = findViewById(R.id.cours_tabl2);
        tabVideo = findViewById(R.id.video_tabl2);

        pagerAdapter = new Lycee2Page(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);



        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
