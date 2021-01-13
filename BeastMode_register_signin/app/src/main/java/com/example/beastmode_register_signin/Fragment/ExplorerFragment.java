package com.example.beastmode_register_signin.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beastmode_register_signin.Explorer.AllCategory;
import com.example.beastmode_register_signin.Explorer.CategoryItem;
import com.example.beastmode_register_signin.Explorer.MainRecyclerAdapter;
import com.example.beastmode_register_signin.R;

import java.util.ArrayList;
import java.util.List;

public class ExplorerFragment extends Fragment {

    RecyclerView mainCategoryRecycler;
    MainRecyclerAdapter mainRecyclerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explorer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainCategoryRecycler = view.findViewById(R.id.main_recycler_view);
        LoadData();
    }

    private void setMainCategoryRecycler(List<AllCategory> allCategoryList){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mainCategoryRecycler.setLayoutManager(linearLayoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter( getContext(), allCategoryList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);
    }

    private void LoadData() {
        //category Full Body
        List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(1, R.drawable.jumpingjackp, "Jumping Jacks","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Start with your feet together and your arms by your sides, then jump up with your feet apart and your hands overhead. \n Return to the start position then do the next rep", R.drawable.jumpingjacks, "00:20"));
        categoryItemList.add(new CategoryItem(1, R.drawable.pushupp, "Push-Ups","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Lay prone on the ground with arms supporting your body. \n Keep your body straight while raising and lowering your body with your arms.", R.drawable.pushup, "x15"));
        categoryItemList.add(new CategoryItem(1, R.drawable.inclinepushupp, "Incline Push-Ups","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Start in regular push-up position but with your hands elevated on a chair or bench. \n Then push your body up down using your arm strength. Remember to keep your body straight.", R.drawable.inclinepushup, "x16"));
        categoryItemList.add(new CategoryItem(1, R.drawable.widepushupp, "Wide Arm Push-Ups","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Then push your body up down using your arm strength. Remember to keep your body straight.", R.drawable.widepushups, "x10"));
        categoryItemList.add(new CategoryItem(1, R.drawable.cobraposep, "Cobra Stretch","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Lie down on your stomach and bend your elbows with your hands beneath your shoulders. \n Then push your chest up off the ground as far as possible. Hold this position for seconds.", R.drawable.cobrapose, "0:20"));
        categoryItemList.add(new CategoryItem(1, R.drawable.kneepusupsp, "Knee Push-Ups","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Start in the regular push-up position, then let your knees touch the floor and raise your feet up off the floor. \n Next push your body up and down.", R.drawable.kneepusups, "x15"));

        //category Lower
        List<CategoryItem> categoryItemList2 = new ArrayList<>();
        categoryItemList2.add(new CategoryItem(1, R.drawable.squatsp, "Squats","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Stand with your feet shoulder width apart and your arms stretched forward, then lower your body until your thighs are parallel with the floor. \n Your knees should be extended in the same direction as your toes. Return to the start position and do the next rep.", R.drawable.squats, "x15"));
        categoryItemList2.add(new CategoryItem(1, R.drawable.backwardlungep, "Backward Lunge","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Stand with your feet shoulder width apart and your hands on your hips. \n Step a big step backward wit your right leg and lower your body until your left thigh is parallel to the floor. Return and repeat with other side.", R.drawable.backwardlunge, "x15"));
        categoryItemList2.add(new CategoryItem(1, R.drawable.donkeykicksp, "Donkey kicks","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Start on all fours with your knees under your butt and your hands under your shoulders. \n Then lift your left leg and squeeze your butt as much as you can. Repeat for the right leg", R.drawable.donkeykicks, "x13"));
        categoryItemList2.add(new CategoryItem(1, R.drawable.sidelyinglegp, "Side-Lying Leg","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Lie down on your side with your head rested on your left arm. Lift your upper leg up and return to the start position \n Make sure your right leg goes straight up and down during the exercise.",R.drawable.sidelyingleg, "x15"));
        categoryItemList2.add(new CategoryItem(1, R.drawable.quadstretchp, "Quad Stretch","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Stand still. Bend your right leg and grasp your ankle or toes to bring your right calf close to your right thigh. \n Hold this position. Repeat for the left leg", R.drawable.quadstretch, "0:40"));
        categoryItemList2.add(new CategoryItem(1, R.drawable.kneepusupsp, "Knees to Chest","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Lie on the floor with your legs extended. Lift your left knee up and grab it with both hands.Pull your left knee towards your chest as much as you can while keeping your right leg straight on the ground. \n Hold this position for a few seconds and repeat for the right leg", R.drawable.kneeschest, "00:30"));

        //category Upper
        List<CategoryItem> categoryItemList3 = new ArrayList<>();
        categoryItemList3.add(new CategoryItem(1, R.drawable.tricepsbackp, "Triceps Kickbacks","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Lean forward, bend your knees and your elbows. Extend your arms behind you and squeeze your triceps. Please make your arms parallel to the ground when extending them. \n Go back to the start position, and repeat this exercise", R.drawable.tricepskickbacks, "0:20"));
        categoryItemList3.add(new CategoryItem(1, R.drawable.punchesp,"Punches","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Stand with one of your legs forward and your knees bent slightly. Bend your elbows and  clench your fists in front of your face \n Extend one arm forward with the palm facing the floor. Take the arm back and repeat with the other arm.", R.drawable.punches , "0:30"));
        categoryItemList3.add(new CategoryItem(1, R.drawable.jumpingjackp, "Jumping Jacks","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Start with your feet together and your arms by your sides, then jump up with your feet apart and your hands overhead. \n Return to the start position then do the next rep", R.drawable.jumpingjacks, "00:20"));
        categoryItemList3.add(new CategoryItem(1, R.drawable.punchesp, "Diamond Push-Ups","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Start in the push-up position. Make a diamond shape with your forefingers and thumbs together under your chest. \n Then push your body up and down. Remember to keep your body straight.", R.drawable.diamondpushups, "x15"));
        categoryItemList3.add(new CategoryItem(1, R.drawable.plankp, "Plank","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Lie on the floor with your toes and forearms on the ground. Keep your body straight and hold this position for few seconds. \n This exercise strengthens the abdomen, back and shoulders", R.drawable.plank, "0:20"));
        categoryItemList3.add(new CategoryItem(1, R.drawable.armscissorsp, "Arm Scissors","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Stand upright with your feet shoulder width apart. Stretch your arms in front of you at shoulder height with one arm overlap the other in the shape of 'X', and then spread then apart. \n Switch arms, and repeat the exercise. ", R.drawable.armscissors, "0:30"));

        //category Abs
        List<CategoryItem> categoryItemList4 = new ArrayList<>();
        categoryItemList4.add(new CategoryItem(1, R.drawable.mountainclimbersp, "Mountain Climber","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Start in the push-ups position. Bend your right knee towards your chest and keep your left leg straight, then quickly switch from one leg to the other. \n This exrcise strengthnes multiple muscle groups.", R.drawable.mountainclimbers, "x15"));
        categoryItemList4.add(new CategoryItem(1, R.drawable.plankp, "Plank","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Lie on the floor with your toes and forearms on the ground. Keep your body straight and hold this position for few seconds. \n This exercise strengthens the abdomen, back and shoulders", R.drawable.plank, "0:20"));
        categoryItemList4.add(new CategoryItem(1, R.drawable.legraisesp, "Leg Raises","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Lie down on your back, and put your hands beneath your hips for support. Then lift your legs up until they form a right angle with the floor. \n Slowly brings your legs back down and repeat the exercise.", R.drawable.legraises, "x20"));
        categoryItemList4.add(new CategoryItem(1, R.drawable.heeltouchp, "Heel Raises","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Lie on the ground with your legs bent and your arms by your sides. \n Slightly lift your upper body off the floor and make your hands alternately reach your heels.", R.drawable.heeltouch, "x20"));
        categoryItemList4.add(new CategoryItem(1, R.drawable.rusiantwistp, "Russian Twist","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Sit on the floor with your knees bent, feet lifted a little bit and back tilted backwards. \n Then hold your hamds together and twist from side to side.", R.drawable.rusiantwist, "x30"));
        categoryItemList4.add(new CategoryItem(1, R.drawable.cobraposep, "Cobra Stretch","A signature BeastMode workout. It's you against the clock. Aim to complete this workout as fast as possible while maintaining proper technique. The time it takes you to complete this workout can be an indication of your fitness progress.","Lie down on your stomach and bend your elbows with your hands beneath your shoulders. \n Then push your chest up off the ground as far as possible. Hold this position for few seconds", R.drawable.cobrapose, "0:30"));


        List<AllCategory> allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory("Full Body", categoryItemList));
        allCategoryList.add(new AllCategory("Lower", categoryItemList2));
        allCategoryList.add(new AllCategory("Upper", categoryItemList3));
        allCategoryList.add(new AllCategory("Beginner", categoryItemList4));
        setMainCategoryRecycler(allCategoryList);
    }
}