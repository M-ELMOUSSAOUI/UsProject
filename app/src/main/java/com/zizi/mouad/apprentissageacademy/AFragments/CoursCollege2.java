package com.zizi.mouad.apprentissageacademy.AFragments;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.zizi.mouad.apprentissageacademy.ActivityPdfViewer;
import com.zizi.mouad.apprentissageacademy.Adapters.ListCoursAdapter;
import com.zizi.mouad.apprentissageacademy.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoursCollege2 extends Fragment {
    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private ListCoursAdapter listAdapter;
    private String Url ="https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F2.pdf?alt=media&token=de802e46-f506-4f7f-881a-2025ece15ab4";

    public CoursCollege2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_cours_college2, container, false);
        expListView = v.findViewById(R.id.exp_list_col2);
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
                final int GrpSelect = i;
                switch (GrpSelect) {
                    case 0: {

                        Bundle b = new Bundle();
                        b.putString("m1", Url);
                        Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                        inte.putExtras(b);
                        startActivity(inte);
                        break;

                    }

                    case 1: {

                        Bundle b = new Bundle();
                        b.putString("m1", Url);
                        Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                        inte.putExtras(b);
                        startActivity(inte);
                        break;

                    }

                    case 2: {

                        Bundle b = new Bundle();
                        b.putString("m1", Url);
                        Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                        inte.putExtras(b);
                        startActivity(inte);
                        break;

                    }

                    case 3: {

                        Bundle b = new Bundle();
                        b.putString("m1", Url);
                        Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                        inte.putExtras(b);
                        startActivity(inte);
                        break;

                    }

                    case 4: {

                        Bundle b = new Bundle();
                        b.putString("m1",Url);
                        Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                        inte.putExtras(b);
                        startActivity(inte);
                        break;

                    }

                    case 5: {

                        Bundle b = new Bundle();
                        b.putString("m1", Url);
                        Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                        inte.putExtras(b);
                        startActivity(inte);
                        break;

                    }
                    case 6: {

                        Bundle b = new Bundle();
                        b.putString("m1", Url);
                        Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                        inte.putExtras(b);
                        startActivity(inte);

                    }
                    break;


                    case 7: {

                        Bundle b = new Bundle();
                        b.putString("m1", Url);
                        Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                        inte.putExtras(b);
                        startActivity(inte);
                        break;

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
