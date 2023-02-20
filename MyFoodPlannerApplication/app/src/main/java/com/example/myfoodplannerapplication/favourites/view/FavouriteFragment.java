package com.example.myfoodplannerapplication.favourites.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.myfoodplannerapplication.MealFullDetailes;
import com.example.myfoodplannerapplication.R;
import com.example.myfoodplannerapplication.database.LocalMealDataSource;
import com.example.myfoodplannerapplication.databinding.ActivityMainBinding;
import com.example.myfoodplannerapplication.favourites.presenter.FavPresenter;
import com.example.myfoodplannerapplication.favourites.presenter.FavPresenterInterface;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    String fromFragment;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        presenter = new FavPresenter(LocalMealDataSource.getInstance(getContext()));
        adapter = new FavAdapter(getContext(), new ArrayList<>(), this::onClickRemoveFavourite);
        favRecyclerView = view.findViewById(R.id.fav_recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        favRecyclerView.setLayoutManager(layoutManager);
        favRecyclerView.setAdapter(adapter);
        storedMeals = presenter.getFav();
        storedMeals.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> {
                    //System.out.println("Henaaaa" + item.get(0).getStrMeal());
                    adapter.setList((ArrayList<MealFullDetailes>) item);
                    adapter.notifyDataSetChanged();
                }, error -> System.out.println(error.getMessage()));

       /*   Bundle bundle = this.getArguments();
        if(bundle != null){
            fromFragment= bundle.getString("Fragment");
            System.out.println(fromFragment);

            //addbtn.setVisibility(View.VISIBLE);
        }
      if (fromFragment.equals("AddToPlan")){
           // addbtn.setVisibility(View.VISIBLE);
            System.out.println("TRUEEEEE");
        }*/


/*
        //storing in firebase
        ActivityResultLauncher<Intent> activityResultLauncher= registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                         if(result.getResultCode() == Activity.RESULT_OK){
                             Intent data = result.getData();
                         }
                    }
                }
        );*/

    }

    @Override
    public void onClickRemoveFavourite(MealFullDetailes meal) {
        presenter.removeFromFav(meal);
        Toast.makeText(getContext(),"Meal removed to Favourites", Toast.LENGTH_SHORT).show();
    }
}