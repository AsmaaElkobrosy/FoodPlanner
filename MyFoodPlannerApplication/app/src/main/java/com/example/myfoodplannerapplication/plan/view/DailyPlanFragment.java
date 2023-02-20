package com.example.myfoodplannerapplication.plan.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfoodplannerapplication.MealFullDetailes;
import com.example.myfoodplannerapplication.R;
import com.example.myfoodplannerapplication.database.LocalMealDataSource;
import com.example.myfoodplannerapplication.database.PlanDataSource;
import com.example.myfoodplannerapplication.database.PlanMealDataSource;
import com.example.myfoodplannerapplication.favourites.presenter.FavPresenter;
import com.example.myfoodplannerapplication.plan.model.MealPlan;
import com.example.myfoodplannerapplication.plan.presenter.PlanPresenter;
import com.example.myfoodplannerapplication.plan.presenter.PlanPresenterInterface;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class DailyPlanFragment extends Fragment implements OnRemoveFromPlanClickListener{

    TextView dayofweek;
    PlanAdapter adapter;
    RecyclerView planRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference reference;
    ValueEventListener eventListener;
    ArrayList<MealPlan> dataList;
    ArrayList<MealPlan> finalData;
    String dayname;
    PlanPresenterInterface planPresenter;
    PlanDataSource planDataSource;
    Observable<List<MealPlan>> storedPlanned;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.daily_plan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dayofweek = view.findViewById(R.id.dayOfWeekTV);

        planPresenter= new PlanPresenter(getContext());
        planDataSource= new PlanMealDataSource(getContext());

        Bundle bundle = this.getArguments();
        if(bundle != null){
            dayname= bundle.getString("day");
        }
        dayofweek.setText(dayname);

        planRecyclerView= view.findViewById(R.id.recycledays);

        adapter= new PlanAdapter(new ArrayList<>(),getContext(), this :: onClickRemovePlan);
        layoutManager=new LinearLayoutManager(getContext());
        planRecyclerView.setLayoutManager(layoutManager);
        planRecyclerView.setAdapter(adapter);

        dataList= new ArrayList<>();
        finalData= new ArrayList<>();

        reference= database.getReference();
        eventListener= reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //planPresenter.deleteAllFromPlan();
                dataList.clear();
                for (DataSnapshot shot : snapshot.getChildren()){
                    MealPlan meal= shot.getValue(MealPlan.class);
                    dataList.add(meal);
                }

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                for(MealPlan meall : dataList){
                    if(meall.getDay().equals(dayname) && meall.getEmail().equals(user.getEmail())){
                        finalData.add(meall);
                    }
                }
                /*adapter.setList(finalData);
                adapter.notifyDataSetChanged();*/

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        storedPlanned= planPresenter.getPlannedMeals();
        storedPlanned.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item-> {
                    adapter.setList((ArrayList<MealPlan>) item);
                    adapter.notifyDataSetChanged();
                }, error-> System.out.println(error.getMessage()));

    }


    @Override
    public void onClickRemovePlan(MealPlan meal) {
        //Room
        planPresenter.removeFromPlan(meal);
        Toast.makeText(getContext(),"Meal Removed From Plan", Toast.LENGTH_SHORT).show();
        //FireBase
        String mealid = meal.getIdMeal();
        String day = meal.getDay();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(mealid+" "+day);
        reference.removeValue();
    }
}