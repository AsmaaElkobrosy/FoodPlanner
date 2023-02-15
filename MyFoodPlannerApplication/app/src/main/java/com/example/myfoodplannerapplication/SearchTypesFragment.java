package com.example.myfoodplannerapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;


public class SearchTypesFragment extends Fragment {

    ImageButton chicken,meat,salmon,cheese,Egg,orange,
            milk,flour,lemon,rice,sparograss,onion,
            garlic,eggplant,oat,chilies,cucumber,
            avocado;

    RadioButton ingredientRB, category, area;
    RadioGroup radioGroup;
    ArrayList <ImageButton> ingredients = new ArrayList<>();
    ArrayList <ImageButton> categories = new ArrayList<>();
    ArrayList <ImageButton> areas = new ArrayList<>();



    public SearchTypesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_types, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioGroup= view.findViewById(R.id.radioGroup);
        ingredientRB= view.findViewById(R.id.ingredient_checkBox);
        category= view.findViewById(R.id.category_checkBox);
        area= view.findViewById(R.id.area_checkBox);



        chicken = view.findViewById(R.id.chickenBtn);
        ingredients.add(chicken);
        meat = view.findViewById(R.id.meatBtn);
        ingredients.add(meat);
        oat = view.findViewById(R.id.oatBtn);
        ingredients.add(oat);
        onion = view.findViewById(R.id.onionBtn);
        ingredients.add(onion);
        sparograss = view.findViewById(R.id.sparograssBtn);
        ingredients.add(sparograss);
        cheese = view.findViewById(R.id.cheeseBtn);
        ingredients.add(cheese);
        salmon = view.findViewById(R.id.salmonBtn);
        ingredients.add(salmon);
        chilies = view.findViewById(R.id.chiliesBtn);
        ingredients.add(chilies);
        cucumber = view.findViewById(R.id.cucumberBtn);
        ingredients.add(cucumber);
        Egg = view.findViewById(R.id.eggBtn);
        ingredients.add(Egg);
        orange = view.findViewById(R.id.orangeBtn);
        ingredients.add(orange);
        rice = view.findViewById(R.id.riceBtn);
        ingredients.add(rice);
        lemon = view.findViewById(R.id.lemonBtn);
        ingredients.add(lemon);
        flour = view.findViewById(R.id.flourBtn);
        ingredients.add(flour);
        eggplant = view.findViewById(R.id.eggplantBtn);
        ingredients.add(eggplant);
        milk = view.findViewById(R.id.milkBtn);
        ingredients.add(milk);
        garlic = view.findViewById(R.id.garlicBtn);
        ingredients.add(garlic);
        avocado = view.findViewById(R.id.avocadobtn);
        ingredients.add(avocado);
/*     String filterBy = ((RadioButton) view.findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }
});*/
        ingredientRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(ImageButton b : areas){
                    b.setVisibility(View.INVISIBLE);
                }
                for(ImageButton cat : categories){
                    cat.setVisibility(View.INVISIBLE);
                }
                for (ImageButton b: ingredients) {
                    b.setVisibility(View.VISIBLE);
                }
            }
        });
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(ImageButton cat : categories){
                    cat.setVisibility(View.INVISIBLE);
                }
                for(ImageButton ing : ingredients){
                    ing.setVisibility(View.INVISIBLE);
                }
                for(ImageButton b : areas){
                    b.setVisibility(View.VISIBLE);
                }
            }
        });
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(ImageButton ing : ingredients){
                    ing.setVisibility(View.INVISIBLE);
                }
                for(ImageButton b : areas){
                    b.setVisibility(View.INVISIBLE);
                }
                for(ImageButton b : categories){
                    b.setVisibility(View.VISIBLE);
                }
            }
        });
        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",chicken.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",meat.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        salmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",salmon.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        Egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",Egg.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        garlic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",garlic.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        cheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",cheese.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",orange.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        eggplant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",eggplant.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        sparograss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",sparograss.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });

        chilies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",chilies.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",rice.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });

        onion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",onion.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });


        lemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",lemon.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });

        avocado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",avocado.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        cucumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Ingredient");
                bundle.putString("type",cucumber.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });



    }
}