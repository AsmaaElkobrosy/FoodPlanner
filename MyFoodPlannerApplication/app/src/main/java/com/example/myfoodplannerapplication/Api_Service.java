package com.example.myfoodplannerapplication;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api_Service { //https://rb.gy/gsqowv
    @GET("/api/json/v1/1/search.php?s")
    Observable<ResultModel> getRandomMeals();
}
