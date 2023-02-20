package com.example.myfoodplannerapplication.network;

import com.example.myfoodplannerapplication.ResultModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api_Service {
    @GET("/api/json/v1/1/search.php?s")
    Observable<ResultModel> getRandomMeals();

    @GET("/api/json/v1/1/filter.php")
    Observable<ResultModel> getByArea(@Query("a") String area);

    @GET("/api/json/v1/1/filter.php")
    Observable<ResultModel> getByCategory(@Query("c") String category);

    @GET("/api/json/v1/1/filter.php")
    Observable<ResultModel> getByIngredients (@Query("i") String ingredient);
    @GET("/api/json/v1/1/lookup.php")
    Observable<ResultModel> getMealDetails(@Query("i") String id);
}
