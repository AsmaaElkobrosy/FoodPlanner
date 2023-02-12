package com.example.myfoodplannerapplication;

import java.util.ArrayList;

public class ResultModel {

    ArrayList<MealFullDetailes> meals;

    public ResultModel(ArrayList<MealFullDetailes> meals) {
        this.meals = meals;
    }

    public ArrayList<MealFullDetailes> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<MealFullDetailes> meals) {
        this.meals = meals;
    }
}
