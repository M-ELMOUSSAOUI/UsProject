package com.zizi.mouad.apprentissageacademy;

import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.zizi.mouad.apprentissageacademy.Adapters.College3Page;

public class ActivityCollege3 extends AppCompatActivity {
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    TabItem tabCours,tabVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college3);

        //init wideget
        tabLayout = findViewById(R.id.tab_col_3);
        viewPager = findViewById(R.id.college3_vp);
        tabCours = findViewById(R.id.cours_tab3);
        tabVideo = findViewById(R.id.video_tab3);

        pagerAdapter = new College3Page(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);



        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
