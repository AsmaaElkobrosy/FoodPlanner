package com.example.myfoodplannerapplication.plan.presenter;

import android.content.Context;

import com.example.myfoodplannerapplication.database.LocalMealDataSource;
import com.example.myfoodplannerapplication.database.PlanMealDataSource;
import com.example.myfoodplannerapplication.plan.model.MealPlan;

import java.util.List;

import io.reactivex.Observable;

public class PlanPresenter implements PlanPresenterInterface{

    PlanMealDataSource planMealDataSource;
    Context context;

    public PlanPresenter(Context context) {
        this.planMealDataSource = PlanMealDataSource.getInstance(context);
    }

    @Override
    public Observable<List<MealPlan>> getPlannedMeals() {
        return planMealDataSource.getMeals();
    }

    @Override
    public void removeFromPlan(MealPlan meal) {
        planMealDataSource.deleteMeal(meal);
    }

    @Override
    public void deleteAllFromPlan() {
        planMealDataSource.deleteAllPlannedMeals();
    }
}
