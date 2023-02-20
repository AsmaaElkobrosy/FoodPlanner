package com.example.myfoodplannerapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MyWeeklyPlanFragment extends Fragment {

TextView sunday,monday,tuesday,wednesday,thrusday,friday,saturday;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_weekly_plan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sunday = view.findViewById(R.id.sunbtn);
        monday = view.findViewById(R.id.monbtn);
        tuesday = view.findViewById(R.id.tuesbtn);
        wednesday = view.findViewById(R.id.wedbtn);
        thrusday = view.findViewById(R.id.thrusbtn);
        friday = view.findViewById(R.id.fribtn);
        saturday = view.findViewById(R.id.satbtn);

        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("day",sunday.getContentDescription().toString());
                DailyPlanFragment dailyPlanFragment = new DailyPlanFragment();
                dailyPlanFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment,dailyPlanFragment)
                        .commit();
            }
        });
        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("day",monday.getContentDescription().toString());
                DailyPlanFragment dailyPlanFragment = new DailyPlanFragment();
                dailyPlanFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment,dailyPlanFragment)
                        .commit();
            }
        });

        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("day",tuesday.getContentDescription().toString());
                DailyPlanFragment dailyPlanFragment = new DailyPlanFragment();
                dailyPlanFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment,dailyPlanFragment)
                        .commit();
            }
        });
        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("day",wednesday.getContentDescription().toString());
                DailyPlanFragment dailyPlanFragment = new DailyPlanFragment();
                dailyPlanFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment,dailyPlanFragment)
                        .commit();
            }
        });
        thrusday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("day",thrusday.getContentDescription().toString());
                DailyPlanFragment dailyPlanFragment = new DailyPlanFragment();
                dailyPlanFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment,dailyPlanFragment)
                        .commit();
            }
        });
        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("day",friday.getContentDescription().toString());
                DailyPlanFragment dailyPlanFragment = new DailyPlanFragment();
                dailyPlanFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment,dailyPlanFragment)
                        .commit();
            }
        });
        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("day",saturday.getContentDescription().toString());
                DailyPlanFragment dailyPlanFragment = new DailyPlanFragment();
                dailyPlanFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment,dailyPlanFragment)
                        .commit();
            }
        });
    }
}