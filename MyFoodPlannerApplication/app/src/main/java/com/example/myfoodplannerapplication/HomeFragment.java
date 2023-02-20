package com.example.myfoodplannerapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {

    ImageView image;
    TextView mealName;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mealName= view.findViewById(R.id.mealname);
        image= view.findViewById(R.id.mealtoday);

        Retrofit client= Api_Client.getApiClient();
        Api_Service api= client.create(Api_Service.class);
        Observable<ResultModel> result = api.getRandomMeals();

        result.subscribeOn(Schedulers.io())
                .map(ResultModel :: getMeals)
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        item -> {
                            Random rand = new Random();
                            MealFullDetailes meal= item.get(rand.nextInt(item.size()));
                            Glide.with(getContext()).load(meal.getStrMealThumb()).apply(new RequestOptions()
                                    .override(150,150)).into(image);
                            mealName.setText(meal.getStrMeal());
                        },
                        error -> Log.i("TAG", "onViewCreated: " + error.getMessage())
                );

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }



}