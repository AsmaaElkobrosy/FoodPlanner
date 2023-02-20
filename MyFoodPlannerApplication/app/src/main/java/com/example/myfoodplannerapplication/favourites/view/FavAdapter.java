package com.example.myfoodplannerapplication.favourites.view;

import android.content.Context;
import android.os.Bundle;
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
import com.example.myfoodplannerapplication.MealFullDetailes;
import com.example.myfoodplannerapplication.R;

import java.util.ArrayList;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.MyViewHolder> {
    Context context;
    ArrayList<MealFullDetailes> mealsList;
    private OnRemoveFavClickListener listner;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        Button remove;
        Button addbtn;
        public RecyclerView recyclerView;
        public View layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;
            addbtn = itemView.findViewById(R.id.addtoplan_btn);
            recyclerView = itemView.findViewById(R.id.fav_recyclerView);
            name = itemView.findViewById(R.id.fav_title_tv);
            image = itemView.findViewById(R.id.favourite_imageView);
            remove = itemView.findViewById(R.id.remove_btn);
        }
        public void setButtonVisibility(String bundle){}
    }

    public FavAdapter(Context context, ArrayList<MealFullDetailes> mealsList, OnRemoveFavClickListener clickListner) {
        this.context = context;
        this.mealsList = mealsList;
        this.listner = clickListner;
    }

    public FavAdapter(ArrayList<MealFullDetailes> mealsList, OnRemoveFavClickListener _onClickObj) {
        this.mealsList = mealsList;
        listner = _onClickObj;
    }

    public void setList(ArrayList<MealFullDetailes> mealsList) {
        this.mealsList = mealsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_item, null);
        FavAdapter.MyViewHolder myViewHolder = new FavAdapter.MyViewHolder(view);
        context = parent.getContext();


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        MealFullDetailes meal = mealsList.get(position);
        holder.name.setText(meal.getStrMeal());
        Glide.with(context).load(meal.getStrMealThumb()).apply(new RequestOptions()
                .override(150, 150)).into(holder.image);

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onClickRemoveFavourite(meal);
            }
        });
/*        holder.addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onClickRemoveFavourite(meal);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mealsList.size();
    }
}