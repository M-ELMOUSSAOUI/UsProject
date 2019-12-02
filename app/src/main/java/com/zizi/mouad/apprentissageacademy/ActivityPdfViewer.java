package com.zizi.mouad.apprentissageacademy;

import androidx.appcompat.app.AppCompatActivity;


import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ActivityPdfViewer extends AppCompatActivity {
    private PDFView pdf;
    private String url;
    private ProgressBar bar;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
        //remove Action bar
        getSupportActionBar().hide();

        Bundle b = this.getIntent().getExtras();
        url = b.getString("m1");
        pdf = findViewById(R.id.pdf_view);
        bar = findViewById(R.id.pdf_bar);
        txt = findViewById(R.id.txt2);

        new RetrievePDFStream().execute(url);

    }

    class RetrievePDFStream extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;

            try {

                URL urlx = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) urlx.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());

                }
            } catch (IOException e) {
                return null;
            }
            return inputStream;

        }

        @Override
        protected void onPostExecute(InputStream inputStream) {

            pdf.fromStream(inputStream).onLoad(new OnLoadCompleteListener() {
                @Override
                public void loadComplete(int nbPages) {
                    bar.setVisibility(View.INVISIBLE);
                    txt.setVisibility(View.INVISIBLE);
                    Toast.makeText(ActivityPdfViewer.this, nbPages + " pages", Toast.LENGTH_SHORT).show();

                }
            }).onError(new OnErrorListener() {
                @Override
                public void onError(Throwable t) {
                    txt.setText("Problem du connection réessayez plus tard");
                    txt.setTextSize(16);
                }
            }).load();
        }
    }


}
