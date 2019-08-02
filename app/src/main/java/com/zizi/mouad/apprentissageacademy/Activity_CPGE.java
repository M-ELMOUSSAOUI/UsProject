package com.zizi.mouad.apprentissageacademy;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.zizi.mouad.apprentissageacademy.Adapters.CpgePage;
import com.zizi.mouad.apprentissageacademy.Adapters.EnsaPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

public class Activity_CPGE extends AppCompatActivity {

    private  TabLayout tabLayout;
    private PagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabItem tabCours,tabVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity__cpge );



        //init wideget
        tabLayout = findViewById(R.id.tab_cpge);
        viewPager = findViewById(R.id.cpge_vp);
        tabCours = findViewById(R.id.cours_cpge_tab);
        tabVideo = findViewById(R.id.video_cpge_tab);

        pagerAdapter = new CpgePage(getSupportFragmentManager(),2);
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

}
