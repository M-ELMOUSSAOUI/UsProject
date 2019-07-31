package com.zizi.mouad.apprentissageacademy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class sinscrire extends AppCompatActivity {

    //Declaration of variables
    private EditText Email, Password1, Password2, Phone;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private Button CreatCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sinscrire );

        //Connect variables to objects
        Email = findViewById( R.id.EmailSinscrire);
        Password1 = findViewById( R.id.PasswordSinscrire1);
        Password2 = findViewById( R.id.PasswordSinscrire2);
        Phone  = findViewById( R.id.TelephoneSinscrire);
        CreatCompte  = findViewById( R.id.Creat);

        //OnClick activity
        CreatCompte.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                CheckTest();
            }
        } );
    }

    //Functions



    public void CheckTest(){

        String stringEmail = Email.getText().toString().trim();
        String stringPassword1 = Password1.getText().toString().trim();
        String stringPassword2 = Password2.getText().toString().trim();
        String stringPhone = Phone.getText().toString().trim();


        if (stringEmail.isEmpty()) {
            Email.setError( "Email est requis" );
            Email.requestFocus();
            return;
        }

        if (!stringEmail.matches(emailPattern)) {
            Email.setError( "Email Invalid" );
            Email.requestFocus();
            return;
        }

        if (stringPhone.isEmpty()) {
            Phone.setError( "Telephne est requis" );
            Phone.requestFocus();
            return;
        }

        if (stringPassword1.isEmpty()) {
            Password1.setError( "Mot de pass est requis" );
            Password1.requestFocus();
            return;
        }

        if (stringPassword1.length()<8) {
            Password1.setError( "Mot de passe doit comporter au moins 8 caractères" );
            Password1.requestFocus();
            return;
        }

        if (!(stringPassword2.equals( stringPassword1))) {
            Password2.setError( "Mot de passe ne correspond pas" );
            Password2.requestFocus();
            return;
        }
}

}
