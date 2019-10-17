package com.zizi.mouad.apprentissageacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ActivityVideoView extends AppCompatActivity {
    VideoView vid;
    String[] vidUrl = {"https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Videos%2FColl%C3%A9ge%2F1er%20Ann%C3%A9e%2FAsphalt%208_%20Airborne%2010_09_2017%2018_02_30.mp4?alt=media&token=cecab790-9285-42eb-bc52-08ddfd217369",
            "https://firebasestorage.googleapis.com/v0/b/apprenstisageaccademy.appspot.com/o/Toro%203.0%20alpha%201%20was%20born%2C%20from%20scratch%20with%20love%20--%20eneim's%20blog.mp4?alt=media&token=e1664e33-54f7-4646-ba4c-b02deeab6bf3"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        //remove Action bar
        getSupportActionBar().hide();

        vid = findViewById(R.id.post_image);


        StorageReference storageRef =
                FirebaseStorage.getInstance().getReference();




        Uri vidUri = Uri.parse(vidUrl[1]);

        vid.setVideoURI(vidUri);
        vid.requestFocus();
        MediaController medC = new MediaController(this);
        vid.setMediaController(medC);
        medC.setAnchorView(vid);
        vid.start();


    }

    private void playVideo(String vidUrl) {
        Uri vidUri = Uri.parse(vidUrl);

        vid.setVideoURI(vidUri);
        MediaController medC = new MediaController(this);
        vid.setMediaController(medC);
        medC.setAnchorView(vid);
    }
}
