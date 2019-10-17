package com.zizi.mouad.apprentissageacademy.AFragments;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.zizi.mouad.apprentissageacademy.ActivityVideoView;
import com.zizi.mouad.apprentissageacademy.CustomDialog;
import com.zizi.mouad.apprentissageacademy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoCollege1 extends Fragment  {
    private static final String TAG = "VideoCollege1";
    TextView go;
    String[] vidUrl = {"https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Videos%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FAsphalt%208_%20Airborne%2010_09_2017%2018_02_30.mp4?alt=media&token=cecab790-9285-42eb-bc52-08ddfd217369",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Toro%203.0%20alpha%201%20was%20born%2C%20from%20scratch%20with%20love%20--%20eneim's%20blog.mp4?alt=media&token=e1664e33-54f7-4646-ba4c-b02deeab6bf3"};




    public VideoCollege1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_video_college1, container, false);
        go =v.findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(vidUrl[0]));
                intent.setDataAndType(Uri.parse(vidUrl[0]), "video/mp4");
                startActivity(intent);
            }
        });


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
