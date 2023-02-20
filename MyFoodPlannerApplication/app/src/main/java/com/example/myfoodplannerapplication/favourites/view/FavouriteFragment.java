package com.example.myfoodplannerapplication.favourites.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myfoodplannerapplication.MealFullDetailes;
import com.example.myfoodplannerapplication.R;
import com.example.myfoodplannerapplication.database.LocalMealDataSource;
import com.example.myfoodplannerapplication.favourites.presenter.FavPresenter;
import com.example.myfoodplannerapplication.favourites.presenter.FavPresenterInterface;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class FavouriteFragment extends Fragment implements OnRemoveFavClickListener {

    FavPresenterInterface presenter;
    Observable<List<MealFullDetailes>> storedMeals;
    FavAdapter adapter;
    RecyclerView favRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<MealFullDetailes> meals= new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter= new FavPresenter(LocalMealDataSource.getInstance(getContext()));

        adapter= new FavAdapter(getContext(), new ArrayList<>(), this::onClickRemoveFavourite);
        favRecyclerView= view.findViewById(R.id.fav_recyclerView);
        layoutManager=new LinearLayoutManager(getContext());
        favRecyclerView.setLayoutManager(layoutManager);
        favRecyclerView.setAdapter(adapter);

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

        storedMeals= presenter.getFav();
        storedMeals.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item-> {
                    for(MealFullDetailes meal : item){
                        if(meal.getEmail().equals(user.getEmail())){
                            meals.add(meal);
                        }
                    }
                    adapter.setList(meals);
                    //adapter.setList((ArrayList<MealFullDetailes>) item);
                    adapter.notifyDataSetChanged();
                }, error-> System.out.println(error.getMessage()));
    }

    @Override
    public void onClickRemoveFavourite(MealFullDetailes meal) {
        presenter.removeFromFav(meal);
        Toast.makeText(getContext(),"Meal Removed From Favourites", Toast.LENGTH_SHORT).show();
    }
}