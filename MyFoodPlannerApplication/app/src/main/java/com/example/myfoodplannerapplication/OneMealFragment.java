package com.example.myfoodplannerapplication;

import static com.facebook.FacebookSdk.getApplicationContext;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myfoodplannerapplication.database.LocalMealDataSource;
import com.example.myfoodplannerapplication.database.MealDataSource;
import com.example.myfoodplannerapplication.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class OneMealFragment extends Fragment {
    MealDataSource dataSource;
    ImageView mealimage;
    TextView mealName;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    TextView originCountry;
    Button playVideo;
    String email;

    ImageView starFav;
    Button calender;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;
    ActivityMainBinding binding;
    MealFullDetailes meal;
    String id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.getRoot();
        mealName = view.findViewById(R.id.txtname);
        mealimage = view.findViewById(R.id.mealimg);
        originCountry = view.findViewById(R.id.txtoriginC);
        playVideo = view.findViewById(R.id.Playbtn);
        starFav = view.findViewById(R.id.starimg);
        //addtoplan = view.findViewById(R.id.addtoplan_btn);
        calender = view.findViewById(R.id.addtoplan_btn);
        meal = new MealFullDetailes();
        dataSource = new LocalMealDataSource(getContext());

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            id = bundle.getString("mealid");
        }

        Retrofit client = Api_Client.getApiClient();
        Api_Service api = client.create(Api_Service.class);
        Observable<ResultModel> result = api.getMealDetails(id);

        result.subscribeOn(Schedulers.io())
                .map(ResultModel::getMeals)
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        item -> {
                            meal = item.get(0);

                            mealName.setText(meal.getStrMeal());
                            originCountry.setText("Country:  " + meal.getStrArea() + "\n" + "\n");
                            originCountry.append("Steps:  " + meal.getStrInstructions() + "\n" + "\n");

                            originCountry.append("ingredient:   " + meal.getStrIngredient1() + ", " + meal.getStrIngredient2() +
                                    ", " + meal.getStrIngredient3() + ", " + meal.getStrIngredient4() + ", " + meal.getStrIngredient5() + "\n" + "\n");

                            Glide.with(getContext()).load(meal.getStrMealThumb()).apply(new RequestOptions()
                                    .override(150, 150)).into(mealimage);

                        },
                        error -> Log.i("TAG", "onViewCreated: " + error.getMessage())
                );

       playVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), YouTubePlayerActivity.class);
                intent.putExtra("url", meal.getStrYoutube());
                startActivity(intent);
            }
        });
        starFav.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (user.isAnonymous()) {
                    Toast.makeText(getApplicationContext(), "Register first to show", Toast.LENGTH_SHORT).show();
                } else {
                    dataSource.insertMeal(meal);
                    Toast.makeText(getContext(), "Meal added to Favourites", Toast.LENGTH_SHORT).show();
                }
            }
        });

        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.isAnonymous()) {
                    Toast.makeText(getApplicationContext(), "Register first to show", Toast.LENGTH_SHORT).show();
                } else {
                    PopupMenu popupMenu = new PopupMenu(getContext(), calender);
                    // Inflating popup menu from popup_menu.xml file
                    popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            //Toast message on menu item clicked
                            Toast.makeText(getContext(), "Meal added To " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();

                            String day = menuItem.getTitle().toString();
                            //binding.getRoot().setValue(day);
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            if (user != null) {
                                email = user.getEmail();
                            }


                            String mealname = meal.getStrMeal();
                            String mealid = meal.getIdMeal();
                            String imgofmeal = meal.getStrMealThumb();
                            MealPlan meals = new MealPlan(mealid, mealname, imgofmeal, day, email);

                            reference = database.getReference().child(mealid + " " + day);
                            reference.setValue(meals);
                            return true;
                        }
                    });
                    // Showing the popup menu
                    popupMenu.show();
                }
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.onemealscreen, container, false);
    }

}

