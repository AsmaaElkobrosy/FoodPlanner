package com.example.myfoodplannerapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class FilterFragment extends Fragment implements OnMealClickListener{
    String  filterBy, type;
    Observable<ResultModel> result;
    searchAdapter search_adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_filter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        search_adapter= new searchAdapter(new ArrayList<>(), getContext(), this::onClick);
        recyclerView= view.findViewById(R.id.filter_recyclerView);


        Bundle bundle = this.getArguments();

        if(bundle != null){
            filterBy= bundle.getString("filterBy");
            type= bundle.getString("type");
        }

        Retrofit client= Api_Client.getApiClient();
        Api_Service api= client.create(Api_Service.class);

        switch (filterBy){
            case "Area":
            case "Category":
            case "Ingredient":
                result = api.getByIngredients(type);
                break;
            default:
        }


        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(search_adapter);
        result.subscribeOn(Schedulers.io())
                .map(ResultModel :: getMeals)
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        item -> {
                            for(MealFullDetailes meal : item){
                                Log.i("TAG", "Observable result" + meal.getStrMeal());
                            }
                            search_adapter.setList(item);
                            search_adapter.notifyDataSetChanged();
                        },
                        error -> Log.i("TAG", "On Observable: " + error.getMessage())
                );
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(MealFullDetailes meal) {
        Bundle bundle = new Bundle();
       // System.out.println(resultModel.getMeals().get(position));
        bundle.putString("mealid",meal.getIdMeal());
        Fragment fragment = new OneMealFragment();
        fragment.setArguments(bundle);
        replaceFragment(fragment);
    }
}