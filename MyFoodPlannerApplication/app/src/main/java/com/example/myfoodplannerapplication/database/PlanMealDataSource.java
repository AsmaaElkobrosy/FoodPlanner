package com.example.myfoodplannerapplication.database;

import android.content.Context;

import com.example.myfoodplannerapplication.plan.model.MealPlan;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PlanMealDataSource implements PlanDataSource {
    private PlanDao dao;
    private final Context context;
    private Observable<List<MealPlan>> storedMeals;
    private static PlanMealDataSource planMealDataSource = null;

    public PlanMealDataSource(Context context) {
        this.context = context;
        AppDataBase db = AppDataBase.getInstance(this.context.getApplicationContext());
        dao = db.planDao();
        storedMeals = dao.getMeals();
    }

    public static PlanMealDataSource getInstance(Context context) {
        if (planMealDataSource == null) {
            planMealDataSource = new PlanMealDataSource(context);
        }
        return planMealDataSource;
    }

    @Override
    public Observable<List<MealPlan>> getMeals() {

        return dao.getMeals();
    }

    @Override
    public void insertMeal(MealPlan meal) {
        dao.insertMeal(meal).subscribeOn(Schedulers.computation()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable e) {
            }
        });
    }

    @Override
    public void deleteMeal(MealPlan meal) {
        dao.deleteMeal(meal).subscribeOn(Schedulers.computation()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable e) {
            }
        });
    }

    @Override
    public void deleteAllPlannedMeals() {
        dao.deleteAllPlannedMeals().subscribeOn(Schedulers.computation()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable e) {
            }
        });
    }

}
