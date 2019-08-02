package com.zizi.mouad.apprentissageacademy;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.zizi.mouad.apprentissageacademy.Adapters.College1Page;
import com.zizi.mouad.apprentissageacademy.Adapters.EnsaPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

public class Activity_ENSA extends AppCompatActivity {

    TabLayout tabLayout;
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    TabItem tabCours,tabVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity__ens );

        //init wideget
        tabLayout = findViewById(R.id.tab_ensa);
        viewPager = findViewById(R.id.Ensa_vp);
        tabCours = findViewById(R.id.cours_tab);
        tabVideo = findViewById(R.id.video_tab);

        pagerAdapter = new EnsaPage(getSupportFragmentManager(),2);
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

}
