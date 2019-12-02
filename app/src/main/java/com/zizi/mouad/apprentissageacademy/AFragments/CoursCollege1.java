package com.zizi.mouad.apprentissageacademy.AFragments;


import android.content.Intent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.ExpandableListView;
import android.widget.Toast;


import com.google.firebase.storage.StorageReference;
import com.zizi.mouad.apprentissageacademy.ActivityPdfViewer;

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

    private String[] Mat1urls = {"https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FMatier1%2F%D9%86%D8%B8%D8%A7%D9%85-%D8%A7%D9%84%D8%A3%D8%B3%D8%B1%D8%A9-%D9%81%D9%8A-%D8%A7%D9%84%D8%A5%D8%B3%D9%84%D8%A7%D9%85.docx?alt=media&token=73742d63-2a27-4c1d-a0eb-d6af5768101c"};
    private String[] Mat2urls = {"https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FMatier1%2Favis_adj_adm_05052019.pdf?alt=media&token=c50a55e2-74d9-43b9-abbf-d53d62d67085"};
    private String[] Mat3urls = {};
    private String[] Mat4urls = {};
    private String[] Mat5urls = {};
    private String[] Mat6urls = {};
    private String[] Mat7urls = {"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    private String[] Mat8urls = {"https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F1.pdf?alt=media&token=7f60d158-c439-4d45-8430-0d1cc5eb1b5a",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F2.pdf?alt=media&token=de802e46-f506-4f7f-881a-2025ece15ab4",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F3.pdf?alt=media&token=c12961ae-eec5-41b3-a1c3-9a4e14ab8d22",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F4.pdf?alt=media&token=53cceac4-ff07-40e0-8f51-eda2db630926",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F5.pdf?alt=media&token=fa25ef1d-286c-4f89-8e65-58e252872074",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F6.pdf?alt=media&token=275160e0-7a45-4537-9ea2-b28e08068219",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F7.pdf?alt=media&token=43108dad-1c11-48b9-bf84-cc210d290998",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F8.pdf?alt=media&token=699c5639-e5f4-42e3-a9e5-d154dfe1261c",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F9.pdf?alt=media&token=8bb61922-5fdb-461d-a555-1d6fc900eb34",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F10.pdf?alt=media&token=0e10c649-b7db-459e-b39d-50dc6995cdfa",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F11.pdf?alt=media&token=8cce1b65-4450-4699-889e-77d4624165c5",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F12.pdf?alt=media&token=fae7b7a0-7994-4801-89e9-e182f3f7cb0a",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F13.pdf?alt=media&token=e118f7c9-0342-412c-a0c0-324e0f32c6b0",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F14.pdf?alt=media&token=35a81978-5142-4292-9471-72548a215e71",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F15.pdf?alt=media&token=1bfefe75-cd07-4163-bffb-768f55371e9b",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F16.pdf?alt=media&token=879aa40b-b735-4c98-8cf6-3adf00f9fe4d",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F17.pdf?alt=media&token=a1a6185e-291b-497f-af05-22a494839a51",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F18.pdf?alt=media&token=16778921-9a54-49e4-b833-3a83b6d8eedd",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F19.pdf?alt=media&token=093703fc-5989-462f-8874-128b243dde10",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F20.pdf?alt=media&token=4e45dda7-dd0a-4ef4-859c-b967949a53d3\n",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F21.pdf?alt=media&token=cf647207-56bf-41da-8752-7b87ec74d628\n",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F22.pdf?alt=media&token=413cd0a2-98aa-4ddf-8c18-3493581b4055\n",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Cours%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FPhysc%2F23.pdf?alt=media&token=746a134d-fe12-43ac-98c2-4b86c340484e",
            };


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
                final int Grpselected = i;

                switch (Grpselected) {
                    case 0: {

                        Bundle b = new Bundle();
                        b.putString("m1", Mat1urls[i1]);
                        Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                        inte.putExtras(b);
                        startActivity(inte);
                        break;

                    }

                    case 1: {

                        Bundle b = new Bundle();
                        b.putString("m1", Mat2urls[i1]);
                        Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                        inte.putExtras(b);
                        startActivity(inte);
                        break;

                    }

                    case 2: {

                        Bundle b = new Bundle();
                        b.putString("m1", Mat3urls[i1]);
                        Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                        inte.putExtras(b);
                        startActivity(inte);
                        break;

                    }

                    case 3: {

                        Bundle b = new Bundle();
                        b.putString("m1", Mat4urls[i1]);
                        Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                        inte.putExtras(b);
                        startActivity(inte);
                        break;

                    }

                    case 4: {

                        Bundle b = new Bundle();
                        b.putString("m1", Mat5urls[i1]);
                        Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                        inte.putExtras(b);
                        startActivity(inte);
                        break;

                    }

                    case 5: {

                        Bundle b = new Bundle();
                        b.putString("m1", Mat6urls[i1]);
                        Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                        inte.putExtras(b);
                        startActivity(inte);
                        break;

                    }
                    case 6: {
                        if(Mat7urls.length!=0)
                        {
                            if (!Mat7urls[i1].isEmpty())
                            {
                                Bundle b = new Bundle();
                                b.putString("m1", Mat7urls[i1]);
                                Intent inte = new Intent(getActivity(), ActivityPdfViewer.class);
                                inte.putExtras(b);
                                startActivity(inte);
                            }
                            else Toast.makeText(getContext(), "Le course n'exsit pas maintenant", Toast.LENGTH_LONG).show();
                        }
                        break;

                    }
                    case 7: {

                        Bundle b = new Bundle();
                        b.putString("m1", Mat8urls[i1]);
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
        {
            Matier1.add("العمليات على الأعداد الصحيحة و الأعداد العشرية");
            Matier1.add("المستقيم و أجــزاؤه\t");
            Matier1.add("الكتابات الكسرية  +  مقارنة الأعداد الكسرية\t");
            Matier1.add("العمليات على الأعداد الكسرية\t");
            Matier1.add("المتفاوتة المثلثية  +  واســط قطعة\t");
            Matier1.add("تقديم  و  مقارنة الأعداد العشرية النسبية\t");
            Matier1.add("مجموع قياسات زوايا مثلث  +  مثلثات خــاصة\t");
            Matier1.add("جمع  و  طرح الأعداد العشرية النسبية\t");
            Matier1.add("ضرب  و  قسمة الأعداد العشرية النسبية\t");
            Matier1.add("المنصفات  و  الارتفاعات في مثلث\t");
            Matier1.add("الـقــــوى");
            Matier1.add("التماثل المركــزي\t");
            Matier1.add("النشــر  و  التعميــل\t");
            Matier1.add("متــوازي الأضــلاع\t");
            Matier1.add("المـعــادلات و المســائل\t");
            Matier1.add("الرباعيــات الخــاصة\t");
            Matier1.add("الزوايا المكونة من متوازيين و قــاطع\t");
            Matier1.add("الـتـنــــاسبيــة");
            Matier1.add("المستقيــم المــدرج  +  المعلــم في المستــوى\t");
            Matier1.add("الـــــدائــرة");
            Matier1.add("الموشــور القــائم  و  الأسطــوانة القــائمة\t");
            Matier1.add(" المحيـطــات  و  المســاحات  و  الحجــوم\t");
            Matier1.add("الإحصــــاء");
        }


        List<String> Matier2 = new ArrayList<String>();
        {

            Matier2.add("نظام الأسرة في الإسلام\t");
            Matier2.add("البر بالوالدين\t");
            Matier2.add("أثر الفضائل في المجتمع  الصدق الأمانة الحياء\t");
            Matier2.add("أثر الرذائل في المجتمع  الكذب، الغيبة، النميمة\t");
            Matier2.add("محاربة الإسلام للمفاسد الاقتصادية الغش\t");
            Matier2.add("محاربة الإسلام للمفاسد الاقتصادية – الرشوة\t");
            Matier2.add("المال في الإسلام\t");
            Matier2.add("العفة والقناعة في تحصيل المال\t");
            Matier2.add("فوائده و فضله\t");
            Matier2.add("عناية الاسلام بالبيئة\t");
            Matier2.add("إماطة الأذى عن الطريق صدقة\t");
            Matier2.add("الرفق بالحيوان\t");
            Matier2.add("محمد رسول الله المثل الأعلى\t");
            Matier2.add("صفات المؤمن الذاتية\t");
            Matier2.add("الطهارة أساس العبادة الوضوء، الغسل، التيمم\t");
            Matier2.add("الصلاة و أحكامها الفرائض، السنن، المبطلات\t");
            Matier2.add("الإيمان و أثره في حياة الإنسان\t");
            Matier2.add("الأنبياء و الرسل و رسالتهم\t");
            Matier2.add("أثر الصلاة في تهذيب السلوك\t");
            Matier2.add("العبادة في الإسلام : تعريفها، أنواعها، الغاية منها\t");
            Matier2.add("رعاية الحقوق في الاسلام\t");
            Matier2.add("حق النفس\t");
            Matier2.add("حق المسلم على المسلم\t");
            Matier2.add("حق الله على عباده\t");
            Matier2.add("نظافة البدن\t");
            Matier2.add("الحث على التداوي\t");
            Matier2.add("الإسلام والصحة\t");
            Matier2.add("آداب الطعام والشراب\t");
            Matier2.add("محاربة الجهل و الأمية\t");
            Matier2.add("دعوة الإسلام إلى العلم\t");
            Matier2.add("التعريف بالقرآن الكريم\t");
            Matier2.add("التعريف بالسنة المطهرة\t");
            Matier2.add("عناية الاسلام بجمال السلوك\t");
            Matier2.add("عناية الاسلام بجمال البدن\t");
            Matier2.add("عناية الاسلام بالزينة\t");
            Matier2.add("التربية الجمالية في الاسلام\t");
        }

        List<String> Matier3 = new ArrayList<String>();
        {
            Matier3.add("الأرض شكلها، تمثيلها");
            Matier3.add("الأرض في الكون");
            Matier3.add("الأرض كوكب في تحول مستمر");
            Matier3.add("التدرب على تمثيل البنية السكانية والكثافة السكانية");
            Matier3.add("التدرب على رسم الإحداثيات الجغرافية وتحديد الموقع");
            Matier3.add("الغلاف الجوي");
            Matier3.add("اليابس والمائي");
            Matier3.add("أنشطة السكان التجارة والخدمات");
            Matier3.add("أنشطة السكان الصناعة");
            Matier3.add("أنشطة السكان الفلاحة");
            Matier3.add("دينامية السكان وتوزيعهم");
            Matier3.add("الاستخدام السلمي للبحر");
            Matier3.add("ملف ـ الخصائص الطبيعية والبشرية لمحيط المتعلم وكيفية استغلالها");
            Matier3.add("شرح مصطلحات مادة الجغرافيا");
            Matier3.add("منهجية كتابة مقالة في موضوع ضمن وحدة الاجتماعيات");
        }

        List<String> Matier4 = new ArrayList<String>();
        {
            Matier4.add("التسامح");
            Matier4.add("التضامن");
            Matier4.add("الحرية");
            Matier4.add("الديمقراطية");
            Matier4.add("السلم");
            Matier4.add("العدل");
            Matier4.add(" القاعدة القانونية");
            Matier4.add("الكرامة");
            Matier4.add("المساواة");
            Matier4.add("زيارة مؤسسة مهتمة بحقوق الإنسان");
        }


        List<String> Matier5 = new ArrayList<String>();
        {
            Matier5.add("الحروب الصليبية المواجهة واحتكاك الحضارات\t");
            Matier5.add("الحضارة الإغريقية\t");
            Matier5.add("الخلافة الإسلامية الكبرى الأمويون-العباسيون\t");
            Matier5.add("الخلفاء الراشدون\t");
            Matier5.add("الديانات في الحضارات القديمة بين التعدد والتوحيد\t");
            Matier5.add("المغرب القديم الفينيقيون والقرطاجيون\t");
            Matier5.add("المغرب القديم الممالك الأمازيغية ومقاومة الرومان\t");
            Matier5.add("النظام الفيودالي في أوربا في العصر الوسيط\t");
            Matier5.add("حضارة بلاد الرافدين\t");
            Matier5.add("حضارة مصر القديمة\t");
            Matier5.add("نشأة الدولة الإسلامية\t");
            Matier5.add("الحضارة الإسلامية الإنتاج الفكري\t");
            Matier5.add("منهجية كتابة مقالة في موضوع ضمن وحدة الاجتماعيات");
        }


        List<String> Matier6 = new ArrayList<String>();
        {
            Matier6.add("C1");
            Matier6.add("C2");
            Matier6.add("C3");
            Matier6.add("C4");
            Matier6.add("C5");
            Matier6.add("C6");
            Matier6.add("C7");
            Matier6.add("C8");
        }

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
            Matier8.add("الكهرباء من حولنا");
            Matier8.add("الماء ");
            Matier8.add("المقاومة الكهربائية ");
            Matier8.add("الموصلات والعوازل ");
            Matier8.add("الوقاية من أخطاء التيار الكهربائي");
            Matier8.add("أنواع التراكيب ");
            Matier8.add("تغيرات الحالة الفيزيائية للمادة ");
            Matier8.add("فصل مكونات خليط ");
            Matier8.add("قانون اضافية التوترات");
            Matier8.add("قانون العقد");
            Matier8.add("قياس الضغط والضغط الجوي ");
            Matier8.add("قياس حجم السوائل والأجسام الصلبة");
            Matier8.add("قياس كتلة السوائل والأجسام الصلبة ");
            Matier8.add("معالجة المياه");
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
