package com.example.myfoodplannerapplication;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api_Service { //https://rb.gy/gsqowv
    @GET("/api/json/v1/1/search.php?s")
    Observable<ResultModel> getRandomMeals();

    @GET("/api/json/v1/1/filter.php")
    Observable<ResultModel> getByIngredients(@Query("i") String ingredient);
    @GET("/api/json/v1/1/lookup.php")
    Observable<ResultModel> getMealDetails(@Query("i") String mealId);
}
