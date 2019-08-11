package com.zizi.mouad.apprentissageacademy;

import android.content.Context;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.zizi.mouad.apprentissageacademy.AFragments.VideoCollege1;
import com.zizi.mouad.apprentissageacademy.Adapters.College1Page;

import java.util.HashMap;
import java.util.List;


public class ActivityCollege1 extends AppCompatActivity {
    private TabLayout tabLayout;
    private PagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabItem tabCours, tabVideo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college1);

        //init wideget
        tabLayout = findViewById(R.id.tab_col_1);
        viewPager = findViewById(R.id.college1_vp);
        tabCours = findViewById(R.id.cours_tab);
        tabVideo = findViewById(R.id.video_tab);

        pagerAdapter = new College1Page(getSupportFragmentManager(), 2);
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                
            }

            @Override
            public void onPageSelected(int position) {
                
                if (position==1)
                {
                    FragmentManager fm = getSupportFragmentManager();
                    CustomDialog dialog = new CustomDialog(viewPager,ActivityCollege1.this);
                    dialog.setCancelable(false);
                    dialog.show(fm,"test");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
