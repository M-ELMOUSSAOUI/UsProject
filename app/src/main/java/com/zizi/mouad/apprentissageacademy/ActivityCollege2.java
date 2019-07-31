package com.zizi.mouad.apprentissageacademy;

import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.journaldev.navigationviewexpandablelistview.Adapters.College2Page;

public class ActivityCollege2 extends AppCompatActivity {
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    TabItem tabCours,tabVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college2);
        //init wideget
        tabLayout = findViewById(R.id.tab_col_2);
        viewPager = findViewById(R.id.college2_vp);
        tabCours = findViewById(R.id.cours_tab2);
        tabVideo = findViewById(R.id.video_tab2);

        pagerAdapter = new College2Page(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);



        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
