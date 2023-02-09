package com.example.myfoodplannerapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.MyViewHolder> {

    //List<Meals> productsArrayList;
    Context context;
    //onClickSearch onClickObj;

   /* public searchAdapter(List<Meals> productsArrayList, Context context, onClickSearch onClickObj) {
        this.productsArrayList = productsArrayList;
        this.context = context;
        this.onClickObj = onClickObj;
    }*/

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView meal_title;
        TextView main_title;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seached_items, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        context = parent.getContext();
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
