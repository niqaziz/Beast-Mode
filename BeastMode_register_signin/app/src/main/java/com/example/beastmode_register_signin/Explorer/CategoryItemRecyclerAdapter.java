package com.example.beastmode_register_signin.Explorer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beastmode_register_signin.R;

import java.util.List;

public class CategoryItemRecyclerAdapter extends RecyclerView.Adapter<CategoryItemRecyclerAdapter.CategoryItemViewHolder> {
    private Context context;
    private List<CategoryItem> categoryItemList;

    public CategoryItemRecyclerAdapter(Context context, List<CategoryItem> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryItemViewHolder(LayoutInflater.from(context).inflate(R.layout.category_row_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemViewHolder holder, int position) {
        holder.tvExerciseName.setText(categoryItemList.get(position).getName());
        holder.itemImage.setImageResource(categoryItemList.get(position).getImageUrl());
        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("Name", categoryItemList.get(position).getName());
                bundle.putString("Details", categoryItemList.get(position).getDetails());
                bundle.putString("Workout", categoryItemList.get(position).getWorkout());
                bundle.putInt("Gif", categoryItemList.get(position).getGif());
                bundle.putString("Rep", categoryItemList.get(position).getRep());

                // Tukar Fragment
                // NavHostFragment.findNavController(- Nama File Fragment.this -).navigate(R.id.-id fragment-);
                Navigation.findNavController(v).navigate(R.id.nav_exercise_detail, bundle);
            }
        });

    }


    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static final class CategoryItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvExerciseName;
        ImageView itemImage;
        CardView cardView;

        public CategoryItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            tvExerciseName = itemView.findViewById(R.id.tv_exercise_name);
            cardView = (CardView)itemView.findViewById(R.id.card_view);

        }


    }
}
