package com.example.beastmode_register_signin.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.beastmode_register_signin.R;

public class AboutUsFragment extends Fragment implements View.OnClickListener{

    ImageButton imgBtnCall,imgBtnWeb,imgBtnEmail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imgBtnCall = view.findViewById(R.id.img_btn_call_act);
        imgBtnWeb = view.findViewById(R.id.img_btn_email_act);
        imgBtnEmail =  view.findViewById(R.id.img_btn_web_act);

        Intent intent = getActivity().getIntent();

        imgBtnCall.setOnClickListener(this);
        imgBtnWeb.setOnClickListener(this);
        imgBtnEmail.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.img_btn_call_act:
                Intent callIntent = new Intent (Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel: 010-5096857"));

                if(callIntent.resolveActivity(getActivity().getPackageManager())!=null) {

                    startActivity(callIntent);
                } else {
                    Toast.makeText(getActivity(),"Sorry, no app can handle this action and data",Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.img_btn_web_act:
                Uri webpage = Uri.parse("http://www.beastmode.com");
                Intent webIntent = new Intent (Intent.ACTION_VIEW,webpage);//implicit
                if(webIntent.resolveActivity(getActivity().getPackageManager())!=null) {
                    startActivity(webIntent);
                } else {
                    Toast.makeText(getActivity(), "Sorry, no app can handle this action and data", Toast.LENGTH_SHORT).show();//short time display messagez
                }

                break;

            case R.id.img_btn_email_act:
                Intent emailIntent = new Intent (Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your problem from BeastModeApp");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message: Information about problem.");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"beastmodeapp@company.com"});
                if(emailIntent.resolveActivity(getActivity().getPackageManager())!=null) {
                    startActivity(emailIntent);
                } else {
                    Toast.makeText(getActivity(), "Sorry, no app can handle this action and data", Toast.LENGTH_SHORT).show();
                }

                break;


        }

    }}