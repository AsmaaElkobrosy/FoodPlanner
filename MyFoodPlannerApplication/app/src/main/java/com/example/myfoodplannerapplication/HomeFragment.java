package com.example.myfoodplannerapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment {


   DrawerLayout drawerLayout;
   NavigationView navigationView;
   ActionBarDrawerToggle actionBar;
    MainActivity MainActivity;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        drawerLayout = view.findViewById(R.id.drawerlayout);
        navigationView = view.findViewById(R.id.nav_view);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.home_menu,menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id == R.id.nav_home){
            Toast.makeText(getActivity(),"Home",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.nav_favourites){
            Toast.makeText(getActivity(),"Favourites",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.nav_plan){
            Toast.makeText(getActivity(),"Plan",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.nav_country){
            Toast.makeText(getActivity(),"Country",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.nav_category){
            Toast.makeText(getActivity(),"Category",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.nav_ingredients){
            Toast.makeText(getActivity(),"Ingredients",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}