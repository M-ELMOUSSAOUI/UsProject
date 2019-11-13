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
    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private ListCoursAdapter listAdapter;

    private String[] pdfurls = {"https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FMatier1%2F1412717010.pdf?alt=media&token=d50525eb-f32b-4b9a-926b-94288ad0ffe9",
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
                            b.putString("c1", pdfurls[4]);
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
        listDataHeader.add("الرياضيات");//mat1
        listDataHeader.add("التربية الاسلامية");//mat2
        listDataHeader.add("الجغرافيا");//mat3
        listDataHeader.add("التربية على المواطنة");//mat4
        listDataHeader.add("التاريخ");//mat5
        listDataHeader.add("اللغة العربية");//mat6
        listDataHeader.add("علوم الحياة والأرض");//mat7
        listDataHeader.add("الفيزياء والكيمياء ");//mat8

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

        List<String> Matier7;
        {
            Matier7 = new ArrayList<String>();
            Matier7.add("ستكشاف وسط طبيعي");
            Matier7.add("التغذية");
            Matier7.add("ملاحظة وسط طبيعي");
            Matier7.add("دراسة واستكشاف وسط طبيعي");
            Matier7.add("التنفس في أوساط مختلفة");
            Matier7.add("التحضير للخرجة الجيولوجية، انجازها واستثمارها");
            Matier7.add("الاستحاثة والمستحاثات الأهمية الجيولوجية للمستحاثات");
            Matier7.add("العلاقات الغذائية في وسط طبيعي");
            Matier7.add("تصنيف الكائنات الحية والتوازنات الطبيعية");
            Matier7.add("مراحل تشكل الصخور الرسوبية");
            Matier7.add("التغذية عند النباتات");
            Matier7.add("التغذية والأنظمة الغذائية");
            Matier7.add(" التحضير للخرجة الجيولوجية – الظواهر الجيولوجية الخارجية");
            Matier7.add("مراحل تشكل الصخور الصهارية – الظواهر الجيولوجية الخارجية");
            Matier7.add("التغذية عند الإنسان والحيوانات");
            Matier7.add("لتغذية عند النباتات – العلاقة بين الكائنات الحية وتفاعلها مع الوسط");
            Matier7.add("لتنفس في أوساط متنوعة : العلاقة بين الكائنات الحية وتفاعلها مع الوسط");
            Matier7.add("لحاجيات الغذائية للنباتات الخضراء");
            Matier7.add("العلاقات بين الكائنات الحية وتفاعلها مع الوسط");
            Matier7.add("لوسط الطبيعي : العلاقة بين الكائنات الحية وتفاعلها مع الوسط");
        }

        List<String> Matier8 = new ArrayList<String>();
        {
        Matier8.add("الأجسام الصلبة والسوائل والغازات");
        Matier8.add("التيار الكهربائي المستمر ");
        Matier8.add("الجسم الخالص ومميزاته");
        Matier8.add("الحجم والكتلة");
        Matier8.add("الحرارة والتحولات الفيزيائية للمادة");
        Matier8.add("الخلائط ");
        Matier8.add("الدارة الكهربائية البسيطة ");
        Matier8.add("الذوبان في الماء");
        Matier8.add("الكتلة الحجمية وتغيرات الحالة الفيزيائية للمادة");
        Matier8.add("C2");
        Matier8.add("C3");
        Matier8.add("C4");
        Matier8.add("C5");
        Matier8.add("C6");
        Matier8.add("C7");
        Matier8.add("C8");
        Matier8.add("C1");
        Matier8.add("C2");
        Matier8.add("C3");
        Matier8.add("C4");
        Matier8.add("C5");
        Matier8.add("C6");
        Matier8.add("C7");
        Matier8.add("C8");
        Matier8.add("C1");
        Matier8.add("C2");
        Matier8.add("C3");
        Matier8.add("C4");
        Matier8.add("C5");
        Matier8.add("C6");
        Matier8.add("C7");
        Matier8.add("C8");
        }

        // Header, Child data
        listDataChild.put(listDataHeader.get(0), Matier1);
        listDataChild.put(listDataHeader.get(1), Matier2);
        listDataChild.put(listDataHeader.get(2), Matier3);
        listDataChild.put(listDataHeader.get(3), Matier4);
        listDataChild.put(listDataHeader.get(4), Matier5);
        listDataChild.put(listDataHeader.get(5), Matier6);
        listDataChild.put(listDataHeader.get(6), Matier7);
        listDataChild.put(listDataHeader.get(7), Matier8);
    }

}
