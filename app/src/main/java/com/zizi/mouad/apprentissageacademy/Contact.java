package com.zizi.mouad.apprentissageacademy;


import android.os.Bundle;
import com.zizi.mouad.apprentissageacademy.MainHelpers.GMailSender;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Contact extends AppCompatActivity {
    Button btnSend;
    EditText etName, etMessage;
    private Handler msgHandler = new Handler();
    private ProgressBar bar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        etName = findViewById(R.id.nameContact);
        etMessage = findViewById(R.id.MessageContact);
        btnSend = findViewById(R.id.SendMessageContact);
        bar3 = findViewById(R.id.ctn_progress_Bar);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Contact.this, "Votre message a été envoyé, merci", Toast.LENGTH_SHORT).show();
                checkInfo();
            }
        });
    }

    private void sendMessage() {
        final String name = etName.getText().toString().trim();
        bar3.setVisibility(View.VISIBLE);
        Thread sender = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GMailSender sender = new GMailSender("apprentisage.contact@gmail.com", "App@2019");
                    sender.sendMail(name + " From apprentissage Contact",
                            etMessage.getText().toString(),
                            "apprentisage.contact@gmail.com",
                            "apprentisageacedemy@gmail.com");
                    finish();
                    bar3.setVisibility(View.INVISIBLE);
                } catch (Exception e) {
                    Log.e("mylog", "Error: " + e.getMessage());
                }
            }
        });
        sender.start();
    }

    private void checkInfo() {
        String name = etName.getText().toString().trim();
        String msg = etMessage.getText().toString().trim();
        if (name.isEmpty()) {
            etName.setError("Entrez votre nom");
            etName.requestFocus();
            return;
        }
        if (msg.isEmpty()) {
            etMessage.setError("Entrez votre message");
            etMessage.requestFocus();
            return;
        }
        sendMessage();
    }

    class counter extends Thread {
        int sec;

        counter(int seconds) {
            this.sec = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < sec; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            msgHandler.post(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }
}


