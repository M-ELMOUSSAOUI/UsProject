package com.zizi.mouad.apprentissageacademy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;;

public class MainActivity extends AppCompatActivity {

    // Declaration of Variables

    private Button register, SignIn;
    private EditText Email, Password;
    private TextView PrivacyPolicy;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    // Main function
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //Instance Objects
        register = findViewById( R.id.Sinscrire );
        SignIn = findViewById( R.id.SeConnect );
        Email = findViewById( R.id.EmailSeConnect );
        Password = findViewById( R.id.PasswordSeconnect );
        PrivacyPolicy = findViewById( R.id.privacyPolicy01 );

        // Fonction On Click

        register.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this, sinscrire.class ) );
            }
        } );

        SignIn.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                UserLogIn();
            }
        } );

        PrivacyPolicy.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this, PrivacyPolicy.class ) );
            }
        } );

    }
        // Error Messages

            public void UserLogIn(){

            String stringEmail = Email.getText().toString().trim();
            String stringPassword = Password.getText().toString().trim();

            if (stringEmail.isEmpty()) {
                Email.setError( "Entrez votre email" );
                Email.requestFocus();
                return;
            }
            if (stringPassword.isEmpty()) {
                Password.setError( "Entrez votre mot de pass" );
                Password.requestFocus();
                return;
            }

            if (!stringEmail.matches(emailPattern)) {
                Email.setError( "Email Invalid" );
                Email.requestFocus();
                return;
            }

            if (stringPassword.length()<8) {
                Password.setError( "Mot de passe doit comporter au moins 8 caractères" );
                Password.requestFocus();
                return;
            }
                startActivity( new Intent( MainActivity.this, Index.class ) );


            }

    }


