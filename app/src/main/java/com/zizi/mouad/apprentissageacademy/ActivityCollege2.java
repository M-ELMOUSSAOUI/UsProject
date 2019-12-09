package com.zizi.mouad.apprentissageacademy;

import android.os.Bundle;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.zizi.mouad.apprentissageacademy.Adapters.College2Page;


public class ActivityCollege2 extends AppCompatActivity {
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    TabItem tabCours,tabVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college2);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("2éme année collége");
        //init wideget
        tabLayout = findViewById(R.id.tab_col_2);
        viewPager = findViewById(R.id.college2_vp);
        tabCours = findViewById(R.id.cours_tab2);
        tabVideo = findViewById(R.id.video_tab2);

        pagerAdapter = new College2Page(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);



        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position==1)
                {
                    FragmentManager fm = getSupportFragmentManager();
                    CustomDialog dialog = new CustomDialog(viewPager,ActivityCollege2.this);
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
