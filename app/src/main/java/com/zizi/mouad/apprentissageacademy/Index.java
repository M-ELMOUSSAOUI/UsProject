package com.zizi.mouad.apprentissageacademy;


import android.os.Bundle;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.zizi.mouad.apprentissageacademy.Adapters.ExpandableAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Index extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewFlipper v_fliper;
    android.widget.ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_index );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        expListView = findViewById(R.id.expandableListView);
        prepareListData();
        populateExpandableList();

        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        NavigationView navigationView = findViewById( R.id.nav_view );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener( this);
        //set Fliper
        {
        v_fliper = findViewById( R.id.ViewFliper );
        int images[] = {R.drawable.logo,R.drawable.logo,R.drawable.logo};
        //For loop to slide Image View
        for( int image: images)
        {
            FlipperImages(image);
        }
          }
    }
    public  void FlipperImages(int images){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource( images );

        v_fliper.addView( imageView );
        v_fliper.setFlipInterval( 2000 );
        v_fliper.setAutoStart( true );

        //Animation for Fliper image

        v_fliper.setInAnimation(this, android.R.anim.slide_in_left );
        v_fliper.setOutAnimation(this, android.R.anim.slide_out_right );


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected( item );
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
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
        College.add("1éme Année");

        List<String> hight_school = new ArrayList<String>();
        hight_school.add("Tron Commun");
        hight_school.add("1er Année bac");
        hight_school.add("2éme Année bac");


        List<String> unversity = new ArrayList<String>();
        unversity.add("ENSA");
        unversity.add("ENSG");
        unversity.add("ENSAS");
        unversity.add("Faculté");

        List<String> Contact = new ArrayList<String>();
        Contact.add("Contact");


        List<String> Profil = new ArrayList<String>();
        Profil.add("Déconnexion");

        listDataChild.put(listDataHeader.get(0), College); // Header, Child data
        listDataChild.put(listDataHeader.get(1), hight_school);
        listDataChild.put(listDataHeader.get(2), unversity);
        listDataChild.put(listDataHeader.get(3), Contact);
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


                        break;
                    case "Deconnexion":
                        Toast.makeText(Index.this, "you select deconnexion", Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });
    }
}
