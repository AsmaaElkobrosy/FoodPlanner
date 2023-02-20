package com.example.myfoodplannerapplication.plan.presenter;

import com.example.myfoodplannerapplication.plan.model.MealPlan;

import java.util.List;

import io.reactivex.Observable;

public interface PlanPresenterInterface {
    public Observable<List<MealPlan>> getPlannedMeals();
    public void removeFromPlan(MealPlan meal);
    public void deleteAllFromPlan();
}
