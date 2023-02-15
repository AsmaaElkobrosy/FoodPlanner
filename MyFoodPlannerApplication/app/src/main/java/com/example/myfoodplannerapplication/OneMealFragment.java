package com.example.myfoodplannerapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class OneMealFragment extends Fragment {
    ImageView mealimage;
    TextView mealName;
    TextView originCountry;
    TextView ingredients;
    TextView steps;
    Button playvideo;
    String id;
    searchAdapter search_adapter;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mealName= view.findViewById(R.id.txtname);
        mealimage= view.findViewById(R.id.mealimg);
        originCountry= view.findViewById(R.id.txtoriginC);
        /*ingredients= view.findViewById(R.id.txtingredients);
        steps= view.findViewById(R.id.txtsteps);*/
        playvideo= view.findViewById(R.id.Playbtn);

        Bundle bundle = this.getArguments();
        if(bundle != null){
            id= bundle.getString("mealid");
        }
        Retrofit client= Api_Client.getApiClient();
        Api_Service api= client.create(Api_Service.class);
        Observable<ResultModel> result = api.getMealDetails(id);

        result.subscribeOn(Schedulers.io())
                .map(ResultModel :: getMeals)
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        item -> { MealFullDetailes meal=item.get(0);

                            mealName.setText(meal.getStrMeal());
                            originCountry.setText("Country:  "+meal.getStrArea()+ "\n"+"\n");
                            originCountry.append("Steps:  " +meal.getStrInstructions()+"\n");
                            originCountry.append("ingredient:   "+meal.getStrIngredient1());
                            /*for (String str:meal.setIngredients()) {
                                System.out.println(str);
                            }*/
                            Glide.with(getContext()).load(meal.getStrMealThumb()).apply(new RequestOptions()
                                    .override(150,150)).into(mealimage);

                        },
                        error -> Log.i("TAG", "onViewCreated: " + error.getMessage())
                );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.onemealscreen, container, false);
    }
}
