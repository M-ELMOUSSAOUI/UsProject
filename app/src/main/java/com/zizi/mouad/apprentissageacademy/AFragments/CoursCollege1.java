package com.zizi.mouad.apprentissageacademy.AFragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ExpandableListView;

import com.zizi.mouad.apprentissageacademy.ActivityPdfViewer;
import com.zizi.mouad.apprentissageacademy.Adapters.ExpandableAdapter;
import com.zizi.mouad.apprentissageacademy.Adapters.ListCoursAdapter;
import com.zizi.mouad.apprentissageacademy.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoursCollege1 extends Fragment {
    ExpandableListView expListView;
    List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private ListCoursAdapter listAdapter;

    String[] urls = {"https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FMatier1%2F1412717010.pdf?alt=media&token=d50525eb-f32b-4b9a-926b-94288ad0ffe9",
                    "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FMatier1%2Favis_adj_adm_05052019.pdf?alt=media&token=c50a55e2-74d9-43b9-abbf-d53d62d67085",
                    "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FMatier1%2Fcalendrier%20%20contr%C3%B4le_Printemps%2018_19%20-%20rattrapage%20SMI_0.pdf?alt=media&token=e70ad4fe-7514-45aa-9dda-f7f58bcd1e26",
                    "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FMatier1%2Fcontrole_2018_2019.pdf?alt=media&token=3aaa4882-f8b0-468b-8231-5e93d8e36bbd",
                    "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FMatier1%2Favis_adj_adm_05052019.pdf?alt=media&token=c50a55e2-74d9-43b9-abbf-d53d62d67085"};

    public CoursCollege1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_cours_college1, container, false);

        expListView = v.findViewById(R.id.exp_list_col1);
        prepareListData();
        populateExpandableList();

        return v;
    }

    private void populateExpandableList() {
        listAdapter = new ListCoursAdapter(getActivity(), listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                final String selected = (String) listAdapter.getChild(i, i1);
                switch (selected)
                {
                    case "C1":
                        {
                            Bundle b=new Bundle();
                            b.putString("c1", urls[4]);
                            Intent inte=new Intent(getActivity(), ActivityPdfViewer.class);
                            inte.putExtras(b);
                            startActivity(inte);
                        }
                }


                return false;
            }
        });



    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Matier1");
        listDataHeader.add("Matier2");
        listDataHeader.add("Matier3");
        listDataHeader.add("Matier4");
        listDataHeader.add("Matier5");
        listDataHeader.add("Matier6");
        listDataHeader.add("Matier7");

        // Adding child data
        List<String> College = new ArrayList<String>();
        College.add("C1");
        College.add("C2");
        College.add("C3");
        College.add("C4");
        College.add("C5");
        College.add("C6");
        College.add("C7");
        College.add("C8");

        List<String> hight_school = new ArrayList<String>();
        hight_school.add("C1");
        hight_school.add("C2");
        hight_school.add("C3");
        hight_school.add("C4");
        hight_school.add("C5");
        hight_school.add("C6");
        hight_school.add("C7");
        hight_school.add("C8");


        List<String> unversity = new ArrayList<String>();
        unversity.add("C1");
        unversity.add("C2");
        unversity.add("C3");
        unversity.add("C4");
        unversity.add("C5");
        unversity.add("C6");
        unversity.add("C7");
        unversity.add("C8");

        List<String> Contact = new ArrayList<String>();
        Contact.add("C1");
        Contact.add("C2");
        Contact.add("C3");
        Contact.add("C4");
        Contact.add("C5");
        Contact.add("C6");
        Contact.add("C7");
        Contact.add("C8");


        List<String> Profil = new ArrayList<String>();
        Profil.add("C1");
        Profil.add("C2");
        Profil.add("C3");
        Profil.add("C4");
        Profil.add("C5");
        Profil.add("C6");
        Profil.add("C7");
        Profil.add("C8");

        List<String> Matier6 = new ArrayList<String>();
        Matier6.add("C1");
        Matier6.add("C2");
        Matier6.add("C3");
        Matier6.add("C4");
        Matier6.add("C5");
        Matier6.add("C6");
        Matier6.add("C7");
        Matier6.add("C8");

        List<String> Matier7 = new ArrayList<String>();
        Matier7.add("C1");
        Matier7.add("C2");
        Matier7.add("C3");
        Matier7.add("C4");
        Matier7.add("C5");
        Matier7.add("C6");
        Matier7.add("C7");
        Matier7.add("C8");

        // Header, Child data
        listDataChild.put(listDataHeader.get(0), College);
        listDataChild.put(listDataHeader.get(1), hight_school);
        listDataChild.put(listDataHeader.get(2), unversity);
        listDataChild.put(listDataHeader.get(3), Contact);
        listDataChild.put(listDataHeader.get(4), Profil);
        listDataChild.put(listDataHeader.get(5), Matier6);
        listDataChild.put(listDataHeader.get(6), Matier7);
    }

}
