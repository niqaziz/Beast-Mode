package com.example.beastmode_register_signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.beastmode_register_signin.GetStartedActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUserId;

    @Override
   protected void onResume() {
        super.onResume();
        mFirebaseAuth=FirebaseAuth.getInstance();
        mFirebaseUserId=mFirebaseAuth.getCurrentUser();

        if(mFirebaseUserId==null){
            //go to the login page
            Intent intent= new Intent(MainActivity.this, GetStartedActivity.class);
            //startActivity(intent);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //Intent intent =new Intent(MainActivity.this,SplashActivity.class);
        //startActivity(intent);
    }
}