package com.zizi.mouad.apprentissageacademy.AFragments;



import android.content.Intent;
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
                startActivity(new Intent(getActivity(), ActivityVideoView.class));
            }
        });


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
