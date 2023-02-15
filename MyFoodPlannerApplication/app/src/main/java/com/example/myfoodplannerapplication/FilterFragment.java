package com.example.myfoodplannerapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

    String filterBy, type;
    Observable<ResultModel> result;
    searchAdapter search_adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        search_adapter= new searchAdapter(new ArrayList<>(), getContext(), new FilterFragment());
        recyclerView= view.findViewById(R.id.filter_recyclerView);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(search_adapter);
        searchView= view.findViewById(R.id.search_view_filter);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

        Bundle bundle = this.getArguments();

        if(bundle != null){
            filterBy= bundle.getString("filterBy");
            type= bundle.getString("type");
        }

        Retrofit client= Api_Client.getApiClient();
        Api_Service api= client.create(Api_Service.class);

        switch (filterBy){
            case "Area":
                result = api.getByArea(type);
                break;
            case "Category":
                result = api.getByCategory(type);
                break;
            case "Ingredient":
            default:
        }


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

    private void filter(String text) {
        ArrayList<MealFullDetailes> filteredList= new ArrayList<>();
        for(MealFullDetailes meal : search_adapter.getList()){
            if(meal.getStrMeal().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(meal);
            }
        }
        if (filteredList.isEmpty()){
            Toast.makeText(getContext(), "No Result Found", Toast.LENGTH_SHORT).show();
        }else{
            searchAdapter adapter= new searchAdapter(filteredList, getContext(), new FilterFragment());
            layoutManager=new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
    }


    @Override
    public void onClick(MealFullDetailes meal) {

    }

}