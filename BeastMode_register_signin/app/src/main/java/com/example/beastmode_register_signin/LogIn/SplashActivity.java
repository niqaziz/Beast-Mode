package com.example.beastmode_register_signin.LogIn;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.beastmode_register_signin.ExplorerMainActivity;
import com.example.beastmode_register_signin.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    private VideoView videoview;
    MediaPlayer mMediaPlayer;
    int mCurrentVideoPosition;
    Button btnlogin,btnsignup;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        btnlogin=(Button) findViewById(R.id.splash_btn_signin);
        btnsignup=(Button) findViewById(R.id.splash_btn_signup);
        videoview = (VideoView) findViewById(R.id.splash_videoview);
        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (mFirebaseUser!= null){
            Log.d("kwek","kwekkkkkk");
          Intent intent= new Intent(SplashActivity.this, ExplorerMainActivity.class);
            startActivity(intent);
        }
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, SignInActivity.class));

            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, GetStartedActivity.class));
            }
        });

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.workout);

        videoview.setVideoURI(uri);
        videoview.start();

        videoview.setOnPreparedListener((mediaPlayer) -> {
            mMediaPlayer = mediaPlayer;
            mMediaPlayer.setLooping(true);

            if (mCurrentVideoPosition != 0) {
                mMediaPlayer.seekTo(mCurrentVideoPosition);
                mMediaPlayer.start();
            }

        });

    }
    @Override
    protected void onPause() {
        super.onPause();
        if(mMediaPlayer!=null){
            mCurrentVideoPosition=mMediaPlayer.getCurrentPosition();
            videoview.pause();}
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoview.start();

       //mFirebaseAuth= FirebaseAuth.getInstance();
        //mFirebaseUser=mFirebaseAuth.getCurrentUser();
        //if (mFirebaseUser!= null){
          //  Intent intent= new Intent(SplashActivity.this, MainActivity.class);
           // startActivity(intent);
        //}
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       //mMediaPlayer.release();
        mMediaPlayer=null;
    }
}
