package com.example.myfoodplannerapplication.home.view;

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
import com.example.myfoodplannerapplication.MealFullDetailes;
import com.example.myfoodplannerapplication.OneMealFragment;
import com.example.myfoodplannerapplication.R;
import com.example.myfoodplannerapplication.ResultModel;
import com.example.myfoodplannerapplication.home.presenter.HomePresenter;
import com.example.myfoodplannerapplication.home.presenter.HomePresenterInterface;
import com.example.myfoodplannerapplication.network.Api_Client;
import com.example.myfoodplannerapplication.network.Api_Service;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment implements HomeView{

    ImageView image;
    TextView mealName;
    HomePresenterInterface presenter;
    View view;
    MealFullDetailes meal;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mealName= view.findViewById(R.id.mealName);
        image= view.findViewById(R.id.homeMeal_ImgView);

        /*presenter= new HomePresenter(new HomeFragment());
        presenter.getRandomMeal();*/

        Retrofit client= Api_Client.getApiClient();
        Api_Service api= client.create(Api_Service.class);
        Observable<ResultModel> result = api.getRandomMeals();

        result.subscribeOn(Schedulers.io())
                .map(ResultModel :: getMeals)
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        item -> {
                            Random rand = new Random();
                            meal= item.get(rand.nextInt(item.size()));
                            Glide.with(getContext()).load(meal.getStrMealThumb()).apply(new RequestOptions()
                                    .override(150,150)).into(image);
                            mealName.setText(meal.getStrMeal());
                        },
                        error -> Log.i("TAG", "onViewCreated: " + error.getMessage())
                );
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("mealid",meal.getIdMeal());
                OneMealFragment fragment = new OneMealFragment();
                fragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment)
                        .commit();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void showRandomMeal(MealFullDetailes meal) {
        Log.i("TAG", "ShowRandomMeal in home fragment: " + meal.getStrMeal() + meal.getStrMealThumb());
        mealName.setText(meal.getStrMeal());
        Glide.with(getContext()).load(meal.getStrMealThumb()).apply(new RequestOptions()
                .override(150,150)).into(image);
    }

}