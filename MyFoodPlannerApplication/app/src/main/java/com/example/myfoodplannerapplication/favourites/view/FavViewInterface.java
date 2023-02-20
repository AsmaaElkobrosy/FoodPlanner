package com.example.myfoodplannerapplication.favourites.view;

import androidx.lifecycle.LiveData;

import com.example.myfoodplannerapplication.MealFullDetailes;

import java.util.ArrayList;
import java.util.List;

public interface FavViewInterface {

    void setOnMeals(ArrayList<MealFullDetailes> meals);

}
