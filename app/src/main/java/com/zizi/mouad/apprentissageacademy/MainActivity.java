package com.zizi.mouad.apprentissageacademy;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    // Declaration of Variables
    private Button register, SignIn;
    private LoginButton fblogin;
    private EditText Email, Password;
    private TextView PrivacyPolicy;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressBar bar1;
    private CallbackManager mCallbackManager;


    // Main function
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //firebase
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser != null) {
                    Intent intent = new Intent(MainActivity.this, Index.class);
                    finishAffinity();
                    startActivity(intent);
                }
            }
        };

        //Instance Objects
        mCallbackManager = CallbackManager.Factory.create();
        register = findViewById(R.id.Sinscrire);
        SignIn = findViewById(R.id.SeConnect);
        Email = findViewById(R.id.EmailSeConnect);
        Password = findViewById(R.id.PasswordSeconnect);
        PrivacyPolicy = findViewById(R.id.privacyPolicy01);
        bar1 = findViewById(R.id.login_progress_Bar);
        fblogin = findViewById(R.id.fbbtn);

        // Fonction On Click

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, sinscrire.class));
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                UserLogIn();
            }
        });

        PrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PrivacyPolicy.class));
            }
        });

        fblogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TO DO WITH FB LOG IN METHOD
                Toast.makeText(MainActivity.this, "Sa sera Disponible prochaine fois  ", Toast.LENGTH_LONG).show();

            }
        });

    }

    // Error Messages

    public void UserLogIn() {

        String stringEmail = Email.getText().toString().trim();
        String stringPassword = Password.getText().toString().trim();

        if (stringEmail.isEmpty()) {
            Email.setError("Entrez votre email");
            Email.requestFocus();
            return;
        }
        if (stringPassword.isEmpty()) {
            Password.setError("Entrez votre mot de pass");
            Password.requestFocus();
            return;
        }

        if (!stringEmail.matches(emailPattern)) {
            Email.setError("Email Invalid");
            Email.requestFocus();
            return;
        }

        if (stringPassword.length() < 8) {
            Password.setError("Mot de passe doit comporter au moins 8 caractères");
            Password.requestFocus();
            return;
        }
        bar1.setVisibility(View.VISIBLE);
        //Sign in the user
        mAuth.signInWithEmailAndPassword(stringEmail, stringPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent i = new Intent(MainActivity.this,Index.class);
                            finishAffinity();
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            bar1.setVisibility(View.GONE);
                            Toast.makeText(MainActivity.this, "Email ou mot de pass incorrect",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    private void handleFacebookAccessToken(AccessToken token) {

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Not yet "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                String e = authResult.getUser().getDisplayName();
                Toast.makeText(MainActivity.this, "Bienvenue " + e, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Index.class);
                finishAffinity();
                startActivity(intent);

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth.addAuthStateListener(mAuthListener);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result back to the Facebook SDK
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) mAuth.removeAuthStateListener(mAuthListener);
        bar1.setVisibility(View.GONE);
    }


}






