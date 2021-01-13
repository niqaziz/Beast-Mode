package com.example.beastmode_register_signin.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.beastmode_register_signin.R;

import pl.droidsonroids.gif.GifImageView;

public class ExerciseDetailFragment extends Fragment {

    private String name, details, workout, rep;
    private Integer gif;

    private TextView mName;
    private TextView tvDiscription;
    private TextView tvWorkout;
    private GifImageView ivGif;
    private TextView tvRep;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString("Name");
            details = getArguments().getString("Details");
            workout = getArguments().getString("Workout");
            gif = getArguments().getInt("Gif");
            rep = getArguments().getString("Rep");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mName = (TextView)view.findViewById(R.id.tv_title);
        tvDiscription = (TextView)view.findViewById(R.id.tv_discription) ;
        tvWorkout = (TextView)view.findViewById(R.id.tv_discription2) ;
        ivGif = (GifImageView) view.findViewById(R.id.gif_image);
        tvRep = (TextView) view.findViewById(R.id.tv_rep) ;

        mName.setText(name);
        tvDiscription.setText(details);
        tvWorkout.setText(workout);
        ivGif.setImageResource(gif);
        tvRep.setText(rep);

    }
}