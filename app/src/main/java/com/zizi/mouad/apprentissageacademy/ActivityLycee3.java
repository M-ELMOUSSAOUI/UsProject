package com.zizi.mouad.apprentissageacademy;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
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
        ActionBar bar = getSupportActionBar();
        bar.setTitle("3éme année Lycée");
        //init wideget
        tabLayout = findViewById(R.id.tab_lyc_3);
        viewPager = findViewById(R.id.lycee3_vp);
        tabCours = findViewById(R.id.cours_tabl3);
        tabVideo = findViewById(R.id.video_tabl3);

        pagerAdapter = new Lycee3Page(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);



        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position==1)
                {
                    FragmentManager fm = getSupportFragmentManager();
                    CustomDialog dialog = new CustomDialog(viewPager,ActivityLycee3.this);
                    dialog.setCancelable(false);
                    dialog.show(fm,"test");
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
