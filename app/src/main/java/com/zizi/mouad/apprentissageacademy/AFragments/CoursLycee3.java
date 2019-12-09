package com.zizi.mouad.apprentissageacademy.AFragments;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.zizi.mouad.apprentissageacademy.ActivityPdfViewer;
import com.zizi.mouad.apprentissageacademy.Adapters.ListCoursAdapter;
import com.zizi.mouad.apprentissageacademy.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoursLycee3 extends Fragment {
    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private ListCoursAdapter listAdapter;
    private String url = "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/test%20(1).pdf?alt=media&token=fe247f34-8542-4ec4-a3a0-d05bf2d72dfe";




    public CoursLycee3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =inflater.inflate(R.layout.fragment_cours_lycee3, container, false);
        expListView = v.findViewById(R.id.exp_list_lyc3);

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

                Bundle b = new Bundle();
                b.putString("m1", url);
                Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                inte.putExtras(b);
                startActivity(inte);


                return false;
            }
        });



    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("الرياضيات");
        listDataHeader.add("الفيزياء والكيمياء ");
        listDataHeader.add("علوم الحياة والأرض");
        listDataHeader.add("اللغة العربية");
        listDataHeader.add("اللغة الفرنسية");
        listDataHeader.add("المحاسبة والرياضيات المالية");
        listDataHeader.add("الفلسفة");
        listDataHeader.add("اللغة الانجليزية");
        listDataHeader.add("التنظيم الإداري للمقاولات");


        // Adding child data
        List<String> Matier1 = new ArrayList<String>();
        Matier1.add("C1");
        Matier1.add("C2");
        Matier1.add("C3");
        Matier1.add("C4");
        Matier1.add("C5");
        Matier1.add("C6");
        Matier1.add("C7");
        Matier1.add("C8");

        List<String> Matier2 = new ArrayList<String>();
        Matier2.add("C1");
        Matier2.add("C2");
        Matier2.add("C3");
        Matier2.add("C4");
        Matier2.add("C5");
        Matier2.add("C6");
        Matier2.add("C7");
        Matier2.add("C8");


        List<String> Matier3 = new ArrayList<String>();
        Matier3.add("C1");
        Matier3.add("C2");
        Matier3.add("C3");
        Matier3.add("C4");
        Matier3.add("C5");
        Matier3.add("C6");
        Matier3.add("C7");
        Matier3.add("C8");

        List<String> Matier4 = new ArrayList<String>();
        Matier4.add("C1");
        Matier4.add("C2");
        Matier4.add("C3");
        Matier4.add("C4");
        Matier4.add("C5");
        Matier4.add("C6");
        Matier4.add("C7");
        Matier4.add("C8");


        List<String> Matier5 = new ArrayList<String>();
        Matier5.add("C1");
        Matier5.add("C2");
        Matier5.add("C3");
        Matier5.add("C4");
        Matier5.add("C5");
        Matier5.add("C6");
        Matier5.add("C7");
        Matier5.add("C8");

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
        listDataChild.put(listDataHeader.get(0), Matier1);
        listDataChild.put(listDataHeader.get(1), Matier2);
        listDataChild.put(listDataHeader.get(2), Matier3);
        listDataChild.put(listDataHeader.get(3), Matier4);
        listDataChild.put(listDataHeader.get(4), Matier5);
        listDataChild.put(listDataHeader.get(5), Matier6);
        listDataChild.put(listDataHeader.get(6), Matier7);
    }
}
