package com.example.myfoodplannerapplication.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_Client {

    private static Retrofit retrofit;
    public static final String base_Url= "https://www.themealdb.com";

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
