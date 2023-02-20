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

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.MyViewHolder> {

    ArrayList<MealFullDetailes> mealsArrayList;
    Context context;
    OnMealClickListener listener;

    public searchAdapter(ArrayList<MealFullDetailes> _mealsArrayList, Context context, OnMealClickListener _listener) {
        this.mealsArrayList = _mealsArrayList;
        this.context = context;
        this.listener = _listener;
    }

    public void setList(ArrayList<MealFullDetailes> updatedMeals) {
        this.mealsArrayList = updatedMeals;
    }

    public ArrayList<MealFullDetailes> getList() {
        return mealsArrayList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView meal_title;
        TextView main_title;
        ImageView imagerow;

        public MyViewHolder(@NonNull View itemView, OnMealClickListener listener) {
            super(itemView);
            meal_title = itemView.findViewById(R.id.meal_title);
            imagerow = itemView.findViewById(R.id.imagerowmeal);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seached_items, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view, listener);
        context = parent.getContext();
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.i("TAG", "onBindViewHolder: ");
        MealFullDetailes meal = mealsArrayList.get(position);
        holder.meal_title.setText(meal.getStrMeal());
        Glide.with(context).load(meal.getStrMealThumb()).apply(new RequestOptions()
                .override(150, 150)).into(holder.imagerow);

        holder.imagerow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            listener.onMealClick(meal);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mealsArrayList.size();
    }
}

