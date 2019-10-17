package com.zizi.mouad.apprentissageacademy;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.ActionBar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import com.zizi.mouad.apprentissageacademy.Adapters.Lycee1Page;

public class ActivityLycee1 extends AppCompatActivity {
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    TabItem tabCours,tabVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lycee1);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("1er année Lycée");
        tabLayout = findViewById(R.id.tab_lyc_1);
        viewPager = findViewById(R.id.lycee1_vp);
        tabCours = findViewById(R.id.cours_tabl1);
        tabVideo = findViewById(R.id.video_tabl1);

        pagerAdapter = new Lycee1Page(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);



        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
