package com.example.beastmode_register_signin.Fragment;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.beastmode_register_signin.R;

public class LocationFragment extends Fragment {

 Button btnFindGym;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnFindGym = view.findViewById(R.id.btn_find_gym);
        Uri webpage = Uri.parse("https://www.google.com/maps/search/?api=1&query=gym");
        Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);

        if(webIntent.resolveActivity(getActivity().getPackageManager()) !=null){
            startActivity(webIntent);
        } else{
            Toast.makeText(getActivity(), "Sorry, no app can handle this action", Toast.LENGTH_SHORT).show();
        }
        startLocationUpdate();

    }
    private void  ShowPExplanation(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Request Location Permission");
        builder.setMessage("This app needs location permission to get the location information");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);
            }
        });

        builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Sorry, this function can not be worked util the permission"+
                        "granted",Toast.LENGTH_SHORT).show();
                ShowPExplanation();
            }
        });
        builder.show();
    }


    private void startLocationUpdate(){
        //here, thisActivity is the current activity
        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){

            //permission is not granted
            //should we show an explaination?
            if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.ACCESS_FINE_LOCATION)){
                //show explaination to user
                //this thread waiting for user to respond
                //After the user see the explaination, try again to request the permission.
                ShowPExplanation();
                //ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);
            }else{
                //no explaination needed; request the permission
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);
                //ShowPExplanation();
                //MY_PERMISSION_REQUEST_READ_CONTACTS is an app-define int constant.
                //the callback method get the result from the request
            }

        }else{
            //permission is already been granted
            Toast.makeText(getActivity(),"Location Permission was granted",Toast.LENGTH_SHORT).show();
        }
    }
}