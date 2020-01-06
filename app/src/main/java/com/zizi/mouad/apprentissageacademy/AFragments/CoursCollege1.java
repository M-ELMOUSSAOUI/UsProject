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
    private String url = "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/test%20(1).pdf?alt=media&token=a0260da2-02b0-40d9-96a1-2769a6a45599";




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

        listDataHeader.add("الرياضيات");//mat1
        listDataHeader.add("الفيزياء والكيمياء ");//mat2
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
