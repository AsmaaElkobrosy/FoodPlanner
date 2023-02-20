package com.example.myfoodplannerapplication.favourites.presenter;

import android.content.Context;

import com.example.myfoodplannerapplication.MealFullDetailes;
import com.example.myfoodplannerapplication.database.LocalMealDataSource;

import java.util.List;

import io.reactivex.Observable;

public class FavPresenter implements FavPresenterInterface {
    LocalMealDataSource localMealDataSource;
    Context context;

    public FavPresenter() {
    }

    public FavPresenter(LocalMealDataSource localMealDataSource) {
        this.localMealDataSource = LocalMealDataSource.getInstance(context);
    }

    @Override
    public Observable<List<MealFullDetailes>> getFav() {
        return localMealDataSource.getMeals();
    }

    @Override
    public void removeFromFav(MealFullDetailes meal) {
        localMealDataSource.deleteMeal(meal);
    }


}
