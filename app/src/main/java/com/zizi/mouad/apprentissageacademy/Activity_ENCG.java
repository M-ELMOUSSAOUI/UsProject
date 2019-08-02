package com.zizi.mouad.apprentissageacademy;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.zizi.mouad.apprentissageacademy.Adapters.EncgPage;
import com.zizi.mouad.apprentissageacademy.Adapters.EnsaPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

public class Activity_ENCG extends AppCompatActivity {

    TabLayout tabLayout;
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    TabItem tabCours,tabVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity__encg );

//init wideget
        tabLayout = findViewById(R.id.tab_encg);
        viewPager = findViewById(R.id.encg_vp);
        tabCours = findViewById(R.id.coursencg_tab);
        tabVideo = findViewById(R.id.videoencg_tab);

        pagerAdapter = new EncgPage(getSupportFragmentManager(),2);
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
    }

