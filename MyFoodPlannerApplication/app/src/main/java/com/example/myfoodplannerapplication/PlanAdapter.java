package com.example.myfoodplannerapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.MyViewHolder> {
    ArrayList<MealPlan> plannedMealsList;
    Context context;    //OnMealClickListener listener;

    public PlanAdapter(ArrayList<MealPlan> _mealsArrayList, Context context) {
        this.plannedMealsList = _mealsArrayList;
        this.context = context;        //this.listener = _listener; //, OnMealClickListener _listener
    }

    public void setList(ArrayList<MealPlan> updatedMeals) {
        this.plannedMealsList = updatedMeals;
    }

    public ArrayList<MealPlan> getList() {
        return plannedMealsList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView meal_title;
        ImageView image;
        Button remove;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            meal_title = itemView.findViewById(R.id.plan_meal_title);
            image = itemView.findViewById(R.id.plan_imageView);
            remove = itemView.findViewById(R.id.remove_fromPlan_btn);
        }
    }

    @NonNull
    @Override
    public PlanAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_items, parent, false);
        PlanAdapter.MyViewHolder myViewHolder = new PlanAdapter.MyViewHolder(view);
        context = parent.getContext();
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlanAdapter.MyViewHolder holder, int position) {
        MealPlan meal = plannedMealsList.get(position);
        holder.meal_title.setText(meal.getStrMeal());
        Glide.with(context).load(meal.getStrMealThumb()).apply(new RequestOptions().override(150, 150)).into(holder.image);
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mealid = meal.getIdMeal();
                String day = meal.getDay();
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(mealid+" "+day);
                reference.removeValue();
            }
        });
    }

    @Override
    public int getItemCount() {
        return plannedMealsList.size();
    }
}