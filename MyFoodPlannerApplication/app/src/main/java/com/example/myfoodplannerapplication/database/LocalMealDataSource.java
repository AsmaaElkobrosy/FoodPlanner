package com.example.myfoodplannerapplication.database;

import android.content.Context;

import com.example.myfoodplannerapplication.MealFullDetailes;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LocalMealDataSource implements MealDataSource {
    private MealDao dao;
    private final Context context;
    private Observable<List<MealFullDetailes>> storedMeals;
    private static LocalMealDataSource localMealDataSource = null;

    public LocalMealDataSource(Context context) {
        this.context = context;
        AppDataBase db = AppDataBase.getInstance(this.context.getApplicationContext());
        dao = db.mealDao();
        storedMeals = dao.getMeals();
    }

    public static LocalMealDataSource getInstance(Context context) {
        if (localMealDataSource == null) {
            localMealDataSource = new LocalMealDataSource(context);
        }
        return localMealDataSource;
    }

    @Override
    public Observable<List<MealFullDetailes>> getMeals() {
        return dao.getMeals();
    }


    @Override
    public void insertMeal(MealFullDetailes meal) {
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
    public void deleteMeal(MealFullDetailes meal) {
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
}