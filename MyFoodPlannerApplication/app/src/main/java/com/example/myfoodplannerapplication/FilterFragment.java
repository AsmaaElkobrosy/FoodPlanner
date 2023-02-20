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
import android.widget.SearchView;
import android.widget.Toast;

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
import com.example.myfoodplannerapplication.databinding.ActivityMainBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    SearchView searchView;
    //store data

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_filter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //

        search_adapter= new searchAdapter(new ArrayList<>(), getContext(), this::onMealClick);
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
                result = api.getByIngredients(type);
                break;
            default:
        }


    /*   layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(search_adapter);*/
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

    private void filter(String text) {
        ArrayList<MealFullDetailes> filteredList = new ArrayList<>();
        for (MealFullDetailes meal : search_adapter.getList()) {
            if (meal.getStrMeal().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(meal);
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(getContext(), "No Result Found", Toast.LENGTH_SHORT).show();
        } else {
            searchAdapter adapter = new searchAdapter(filteredList, getContext(), new FilterFragment());
            layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
    }
    @Override
    public void onMealClick(MealFullDetailes meal) {
        Bundle bundle = new Bundle();
        // System.out.println(resultModel.getMeals().get(position));
        bundle.putString("mealid",meal.getIdMeal());
        Fragment fragment = new OneMealFragment();
        fragment.setArguments(bundle);
        //System.out.println(bundle);
        replaceFragment(fragment);
    }
}









