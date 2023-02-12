package com.example.myfoodplannerapplication;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_Client {

    private static Retrofit retrofit;
    public static final String base_Url= "https://www.themealdb.com"; //"https://rb.gy"; //"https://www.themealdb.com/api/json/v1/1/";
    private static Api_Client client;

    public static Retrofit getApiClient(){
        if(retrofit == null){
            retrofit= new Retrofit.Builder()
                    .baseUrl(base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        }
        return retrofit;
    }
}
