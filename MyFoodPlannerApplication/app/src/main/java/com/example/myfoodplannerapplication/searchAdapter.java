package com.example.myfoodplannerapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.MyViewHolder> {

    ArrayList<MealFullDetailes> mealsArrayList;
    Context context;
    OnMealClickListener listener;


    public searchAdapter() {
    }

    public searchAdapter(ArrayList<MealFullDetailes> _mealsArrayList, Context context, OnMealClickListener _listener) {
        this.mealsArrayList = _mealsArrayList;
        this.context = context;
        this.listener = _listener;
    }
    public void setList(ArrayList<MealFullDetailes> updatedMeals){this.mealsArrayList=updatedMeals;}

    public ArrayList<MealFullDetailes> getList() {
        return mealsArrayList;
    }

    public void setFilteredList(ArrayList<MealFullDetailes> filteredMeals){this.mealsArrayList= filteredMeals;}

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView meal_title;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            meal_title = itemView.findViewById(R.id.meal_title);
            image = itemView.findViewById(R.id.imageView);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seached_items, parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        context = parent.getContext();
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.i("TAG", "onBindViewHolder: ");
        MealFullDetailes meal = mealsArrayList.get(position);
        holder.meal_title.setText(meal.getStrMeal());
        Glide.with(context).load(meal.getStrMealThumb()).apply(new RequestOptions()
                .override(150,150)).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mealsArrayList.size();
    }
}