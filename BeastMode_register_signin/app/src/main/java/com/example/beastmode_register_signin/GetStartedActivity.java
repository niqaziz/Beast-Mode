package com.example.beastmode_register_signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class GetStartedActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "GoogleActivity";
    protected EditText etEmail;
    protected EditText etPassword;
    protected Button btnlogin , btngoogle;
    protected EditText etConfirmPassword;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        etEmail = (EditText) findViewById(R.id.login_et_email);
        etPassword = (EditText) findViewById(R.id.login_et_password);
        btnlogin = (Button) findViewById(R.id.login_btn_login);
        etConfirmPassword = (EditText) findViewById(R.id.login_et_confirmpassword);
        btngoogle=(Button) findViewById(R.id.btn_google);
        //get instance:
        mFirebaseAuth = FirebaseAuth.getInstance();
// Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient= GoogleSignIn.getClient(this,gso);

        btngoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signIn();
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = etPassword.getText().toString();
                String email = etEmail.getText().toString();
                String confirmpassword = etConfirmPassword.getText().toString();

                password.trim();
                email.trim();
                confirmpassword.trim();


                if (email.isEmpty() || password.isEmpty()) {


                    AlertDialog.Builder builder = new AlertDialog.Builder(GetStartedActivity.this);
                    builder.setMessage("Please enter the Email and Password").setTitle("Warning").setPositiveButton("OK", null);

                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
                else if  (!confirmpassword.equals(password)) {
                    Toast.makeText(GetStartedActivity.this, "Your Password does not Match, Please try again", Toast.LENGTH_SHORT).show();
                    etConfirmPassword.setError("Dumbass your password does not match");}

                else {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(GetStartedActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Intent intent = new Intent(GetStartedActivity.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            } else {
                                Toast.makeText(GetStartedActivity.this, task.getException().getMessage() + "", Toast.LENGTH_SHORT).show();                            }

                        }

                    });
                }
            }
        });
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Toast.makeText(LoginActivity.this, "masukkk in" ,Toast.LENGTH_LONG).show();
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                // Toast.makeText(LoginActivity.this, "masuk in" ,Toast.LENGTH_LONG).show();
                firebaseAuthWithGoogle(account.getIdToken());
                //FirebaseUser us = mAuth.getCurrentUser();
                //user.getEmail();

                // DatabaseReference myRef = database.getReference("Users/"+user.getUid());

                //DatabaseReference use = myRef.child(currentFirebaseUser.getUid());

                //  myRef.child("Email").setValue(account.getEmail());
                //  myRef.child("Username").setValue(account.getDisplayName());
                //  myRef.child("Phone").setValue("");

                Intent intent = new Intent(GetStartedActivity.this, MainActivity.class);
                intent.putExtra("enable", account.getEmail());
                intent.putExtra("name", account.getDisplayName());
                startActivity(intent);



            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                //Toast.makeText(LoginActivity.this, task.getException().getMessage() ,Toast.LENGTH_LONG).show();
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }
    private void firebaseAuthWithGoogle(String idToken) {
        // [START_EXCLUDE silent]
        // [END_EXCLUDE]
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mFirebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mFirebaseAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                        }
                    }
                });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth= FirebaseAuth.getInstance();
        mFirebaseUser=mFirebaseAuth.getCurrentUser();
        if (mFirebaseUser!= null) {
            Intent intent = new Intent(GetStartedActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}