package com.zizi.mouad.apprentissageacademy;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.google.firebase.auth.FirebaseAuth;
import com.zizi.mouad.apprentissageacademy.Adapters.ExpandableAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Index extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    private ViewFlipper v_fliper;
    android.widget.ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    LinearLayout ll;

    //Firebase Variables
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = Index.this;
        //Animation header
        navigationView = findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        ll = header.findViewById(R.id.ll1);
        AnimationDrawable animationDrawable = (AnimationDrawable) ll.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
        //Instance Firebase
        mAuth = FirebaseAuth.getInstance();

        expListView = findViewById(R.id.expandableListView);
        prepareListData();
        populateExpandableList();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        // set Fliper
        {
            v_fliper = findViewById(R.id.ViewFliper);
            int[] images = {R.drawable.slide_1, R.drawable.slide_2, R.drawable.slide_3};
            //For loop to slide Image View
            for (int image : images) {
                FlipperImages(image);
            }
        }
    }

    public void FlipperImages(int images) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        v_fliper.addView(imageView);
        v_fliper.setFlipInterval(2000);
        v_fliper.setAutoStart(true);


        //Animation for Fliper image

        v_fliper.setInAnimation(this, android.R.anim.slide_in_left);
        v_fliper.setOutAnimation(this, android.R.anim.slide_out_right);


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Collége");
        listDataHeader.add("Lycée");
        listDataHeader.add("Supérieur");
        listDataHeader.add("Contact");
        listDataHeader.add("Profil");

        // Adding child data
        List<String> College = new ArrayList<String>();
        College.add("1er Année");
        College.add("2éme Année");
        College.add("3éme Année");

        List<String> hight_school = new ArrayList<String>();
        hight_school.add("Tron Commun");
        hight_school.add("1er Année bac");
        hight_school.add("2éme Année bac");


        List<String> unversity = new ArrayList<String>();
        unversity.add("ENSA");
        unversity.add("ENCG");
        unversity.add("CPGE");

        /*List<String> Contact = new ArrayList<String>();
        Contact.add("Contact");*/


        List<String> Profil = new ArrayList<String>();
        Profil.add("Déconnexion");

        // Header, Child data
        listDataChild.put(listDataHeader.get(0), College);
        listDataChild.put(listDataHeader.get(1), hight_school);
        listDataChild.put(listDataHeader.get(2), unversity);
        //listDataChild.put(listDataHeader.get(3), Contact);
        listDataChild.put(listDataHeader.get(4), Profil);
    }

    private void populateExpandableList() {

        listAdapter = new ExpandableAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);


        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                final String selected = (String) listAdapter.getChild(groupPosition, childPosition);

                switch (selected) {
                    case "1er Année":
                        Intent inte = new Intent(Index.this, ActivityCollege1.class);
                        startActivity(inte);
                        break;
                    case "2éme Année":
                        Intent inte2 = new Intent(Index.this, ActivityCollege2.class);
                        startActivity(inte2);
                        break;
                    case "3éme Année":
                        Intent inte3 = new Intent(Index.this, ActivityCollege3.class);
                        startActivity(inte3);
                        break;
                    case "Tron Commun":
                        Intent inte4 = new Intent(Index.this, ActivityLycee1.class);
                        startActivity(inte4);
                        break;
                    case "1er Année bac":
                        Intent inte5 = new Intent(Index.this, ActivityLycee2.class);
                        startActivity(inte5);
                        break;
                    case "2éme Année bac":
                        Intent inte6 = new Intent(Index.this, ActivityLycee3.class);
                        startActivity(inte6);
                        break;

                    case "ENSA":
                        Intent inte8 = new Intent(Index.this, Activity_ENSA.class);
                        startActivity(inte8);
                        break;

                    case "ENCG":
                        Intent inte9 = new Intent(Index.this, Activity_ENCG.class);
                        startActivity(inte9);
                        break;

                    case "CPGE":
                        Intent inte10 = new Intent(Index.this, Activity_CPGE.class);
                        startActivity(inte10);
                        break;

                    case "Déconnexion" :
                        mAuth.signOut();
                        Intent inte11 = new Intent(mContext,MainActivity.class);
                        finishAffinity();
                        startActivity(inte11);
                }
                return false;
            }
        });

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                final String selc = listAdapter.getGroup(i).toString();
                if (selc.equals("Contact" ))
                {
                    Intent inte12 = new Intent(Index.this, Contact.class);
                    startActivity(inte12);
                }

                return false;
            }
        });
    }
}
