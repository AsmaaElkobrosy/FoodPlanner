package com.example.myfoodplannerapplication.database;

import com.example.myfoodplannerapplication.MealFullDetailes;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public interface MealDataSource {
    public Observable<List<MealFullDetailes>> getMeals();
    public void insertMeal(MealFullDetailes meal);
    public void deleteMeal(MealFullDetailes meal);
}
