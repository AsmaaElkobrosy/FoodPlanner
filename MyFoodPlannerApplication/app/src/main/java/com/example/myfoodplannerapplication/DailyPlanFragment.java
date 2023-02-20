package com.example.myfoodplannerapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myfoodplannerapplication.favourites.view.FavAdapter;
import com.example.myfoodplannerapplication.favourites.view.FavouriteFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class DailyPlanFragment extends Fragment {
    TextView dayofweek;
    PlanAdapter adapter;
    RecyclerView planRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;
    ValueEventListener eventListener;
    ArrayList<MealPlan> dataList;
    ArrayList<MealPlan> finalData;
    String dayname;

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
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            dayname = bundle.getString("day");
        }
        dayofweek.setText(dayname);

        planRecyclerView = view.findViewById(R.id.recycledays);
        adapter = new PlanAdapter(new ArrayList<>(), getContext());
        layoutManager = new LinearLayoutManager(getContext());
        planRecyclerView.setLayoutManager(layoutManager);
        planRecyclerView.setAdapter(adapter);
        dataList = new ArrayList<>();
        finalData = new ArrayList<>();
        reference = database.getReference();
        eventListener = reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for (DataSnapshot shot : snapshot.getChildren()) {
                    MealPlan meal = shot.getValue(MealPlan.class);
                    dataList.add(meal);
                }
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                for (MealPlan meall : dataList) {
                    if (meall.getDay().equals(dayname) && meall.getEmail().equals(user.getEmail())) {
                        finalData.add(meall);
                    }
                }
                adapter.setList(finalData);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
}