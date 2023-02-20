package com.example.myfoodplannerapplication.favourites.presenter;

import com.example.myfoodplannerapplication.MealFullDetailes;

import java.util.List;

import io.reactivex.Observable;

public interface FavPresenterInterface {
    public Observable<List<MealFullDetailes>> getFav();

    public void removeFromFav(MealFullDetailes meal);
}