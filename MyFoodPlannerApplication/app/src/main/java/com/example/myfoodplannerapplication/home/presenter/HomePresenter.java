package com.example.myfoodplannerapplication.home.presenter;

import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myfoodplannerapplication.MealFullDetailes;
import com.example.myfoodplannerapplication.ResultModel;
import com.example.myfoodplannerapplication.home.view.HomeView;
import com.example.myfoodplannerapplication.network.Api_Client;
import com.example.myfoodplannerapplication.network.Api_Service;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class HomePresenter implements HomePresenterInterface{
    HomeView homeView;

    public HomePresenter(HomeView view) {
        homeView= view;
    }

    @Override
    public void getRandomMeal() {
        Retrofit client= Api_Client.getApiClient();
        Api_Service api= client.create(Api_Service.class);
        Observable<ResultModel> result = api.getRandomMeals();

        result.subscribeOn(Schedulers.io())
                .map(ResultModel:: getMeals)
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        item -> {
                            Random rand = new Random();
                            MealFullDetailes meal= item.get(rand.nextInt(item.size()));
                            Log.i("TAG", "Observable in HomePresenter fragment: " + meal.getStrMeal());
                            homeView.showRandomMeal(meal);
                        },
                        error -> Log.i("TAG", "onViewCreated: " + error.getMessage())
                );
    }

    public void setView(HomeView view) {
        this.homeView = view;
    }
}
