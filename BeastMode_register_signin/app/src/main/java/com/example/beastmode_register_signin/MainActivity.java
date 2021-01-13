package com.example.beastmode_register_signin;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.beastmode_register_signin.LogIn.GetStartedActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_explorer, R.id.navigation_profile, R.id.navigation_location, R.id.navigation_contactus)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
}