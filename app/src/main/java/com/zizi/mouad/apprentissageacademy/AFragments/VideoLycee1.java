package com.zizi.mouad.apprentissageacademy.AFragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.zizi.mouad.apprentissageacademy.Adapters.ListCoursAdapter;
import com.zizi.mouad.apprentissageacademy.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoLycee1 extends Fragment {

    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private ListCoursAdapter listAdapter;
    private String vidUrl = "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/animation%20final.mp4%20-%20Google%20Drive.mp4?alt=media&token=9a19bac3-ee56-464a-9daa-5174623ceb77";


    public VideoLycee1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_video_lycee1, container, false);
        expListView = v.findViewById(R.id.exp_list_lycv1);
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
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(vidUrl));
                intent.setDataAndType(Uri.parse(vidUrl), "video/*");
                startActivity(intent);
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
        listDataHeader.add("علوم المهندس");


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



        // Header, Child data
        listDataChild.put(listDataHeader.get(0), Matier1);
        listDataChild.put(listDataHeader.get(1), Matier2);
        listDataChild.put(listDataHeader.get(2), Matier3);
        listDataChild.put(listDataHeader.get(3), Matier4);

    }
}
