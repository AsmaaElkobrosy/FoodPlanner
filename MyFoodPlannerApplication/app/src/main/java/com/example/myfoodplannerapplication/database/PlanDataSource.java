package com.example.myfoodplannerapplication.database;

import com.example.myfoodplannerapplication.plan.model.MealPlan;

import java.util.List;

import io.reactivex.Observable;

public interface PlanDataSource {
    public Observable<List<MealPlan>> getMeals();

    public void insertMeal(MealPlan meal);

    public void deleteMeal(MealPlan meal);

    public void deleteAllPlannedMeals();
}
