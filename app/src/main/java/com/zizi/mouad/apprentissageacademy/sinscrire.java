package com.zizi.mouad.apprentissageacademy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sinscrire extends AppCompatActivity {

    //Declaration of variables
    private EditText Email, Password1, Password2, Phone;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private Button CreatCompte;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Context mContext;
    private ProgressBar bar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinscrire);
        mContext = sinscrire.this;

        mAuth = FirebaseAuth.getInstance();
        //Connect variables to objects
        Email = findViewById(R.id.EmailSinscrire);
        Password1 = findViewById(R.id.PasswordSinscrire1);
        Password2 = findViewById(R.id.PasswordSinscrire2);
        Phone = findViewById(R.id.TelephoneSinscrire);
        CreatCompte = findViewById(R.id.Creat);
        bar2 = findViewById(R.id.signup_progress_Bar);

        //OnClick activity
        CreatCompte.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckTest();
            }
        });
    }

    //Functions

    public void CheckTest() {

        String stringEmail = Email.getText().toString().trim();
        String stringPassword1 = Password1.getText().toString().trim();
        String stringPassword2 = Password2.getText().toString().trim();
        String stringPhone = Phone.getText().toString().trim();


        if (stringEmail.isEmpty()) {
            Email.setError("Email est requis");
            Email.requestFocus();
            return;
        }

        if (!stringEmail.matches(emailPattern)) {
            Email.setError("Email Invalid");
            Email.requestFocus();
            return;
        }

        if (stringPhone.isEmpty()) {
            Phone.setError("Telephne est requis");
            Phone.requestFocus();
            return;
        }

        if (stringPassword1.isEmpty()) {
            Password1.setError("Mot de pass est requis");
            Password1.requestFocus();
            return;
        }

        if (stringPassword1.length() < 8) {
            Password1.setError("Mot de passe doit comporter au moins 8 caractères");
            Password1.requestFocus();
            return;
        }

        if (!(stringPassword2.equals(stringPassword1))) {
            Password2.setError("Mot de passe ne correspond pas");
            Password2.requestFocus();
            return;
        }
        bar2.setVisibility(View.VISIBLE);
        //add new User
        mAuth.createUserWithEmailAndPassword(stringEmail, stringPassword1)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(mContext, "Bienvenue", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(mContext, Index.class);
                            finishAffinity();
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            bar2.setVisibility(View.INVISIBLE);
                            Toast.makeText(mContext, "Utilisateur Deja existe",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    @Override
    protected void onStop() {
        super.onStop();
        bar2.setVisibility(View.INVISIBLE);
    }
}
