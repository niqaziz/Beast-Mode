package com.example.beastmode_register_signin.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.beastmode_register_signin.LogIn.SignInActivity;
import com.example.beastmode_register_signin.LogIn.SplashActivity;
import com.example.beastmode_register_signin.R;
import com.example.beastmode_register_signin.ResetPassword;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {
    private FirebaseAuth mFirebaseAuth;
    private TextView mtvEmail;

    Button btnReset,btnLogout;
    TextView tvEmail;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    AlertDialog alertDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mtvEmail = view.findViewById(R.id.tv_email);
        mFirebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if(mFirebaseUser!=null) {
            //there is some user logged in
            mtvEmail.setText(mFirebaseUser.getEmail());
        }else {
            //no one logged in
            startActivity(new Intent(getActivity(),SplashActivity.class));
        }


        CheckBox checkBox;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        final SharedPreferences.Editor editor = preferences.edit();
        LinearLayout container = (LinearLayout)view.findViewById(R.id.ll_setting_checkbox);
        int count = container.getChildCount();
        for (int i=0; i<count; i++) {
            View v = container.getChildAt(i);
            if (v instanceof CheckBox) {
                CheckBox checkBox1 = (CheckBox) v;
                if (preferences.getBoolean("cbx" + checkBox1.getId(), false)) {
                    checkBox1.setChecked(true);
                } else {
                    checkBox1.setChecked(false);

                }
                checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(checkBox1.isChecked()) {
                            editor.putBoolean("cbx" + checkBox1.getId(), true);
                            editor.apply();
                        }else{
                            editor.putBoolean("cbx" + checkBox1.getId(), false);
                            editor.apply();
                        }
                    }
                });
            }
        }

        btnLogout = view.findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFirebaseAuth.signOut();
                Intent intent = (new Intent(getActivity(),SplashActivity.class));
            }
        });


        btnReset = view.findViewById(R.id.btn_reset);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ResetPassword.class);
                startActivity(intent);
            }
        });


    }



}

