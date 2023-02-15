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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchTypesFragment extends Fragment {

    ArrayList<ImageButton> areas= new ArrayList<>();
    ArrayList<ImageButton> categories= new ArrayList<>();
    ArrayList<ImageButton> ingredients= new ArrayList<>();
    ImageButton egypt, america, british, dutch, french, greek, india, italia, irish, turkey, tunsia, japan, mexico, morocco, polish,
            russian, spain, vietnam;
    ImageButton breakfast, chicken, dessert, goat, lamb, meat, pasta, seafood, side, starter, vegan, vegiterian;
    RadioGroup radioGroup;
    RadioButton area;
    RadioButton category;
    RadioButton ingredientRB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_types, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ingredientRB= view.findViewById(R.id.ingredient_checkBox);
        area= view.findViewById(R.id.area_checkBox);
        category= view.findViewById(R.id.category_checkBox);

        egypt= view.findViewById(R.id.egyptBtn); america= view.findViewById(R.id.americaBtn);
        british= view.findViewById(R.id.britishBtn); dutch= view.findViewById(R.id.dutchBtn);
        french= view.findViewById(R.id.frenchBtn); greek= view.findViewById(R.id.greekBtn);
        india= view.findViewById(R.id.indianBtn); italia= view.findViewById(R.id.italiaBtn);
        irish= view.findViewById(R.id.irish); turkey= view.findViewById(R.id.turkeyBtn);
        tunsia= view.findViewById(R.id.tunsiaBtn); japan= view.findViewById(R.id.japanBtn);
        mexico= view.findViewById(R.id.mexicoBtn); morocco= view.findViewById(R.id.moroccoBtn);
        russian= view.findViewById(R.id.russianBtn); spain= view.findViewById(R.id.spainBtn);
        vietnam= view.findViewById(R.id.vietnamBtn); polish= view.findViewById(R.id.polishBtn);
        areas.add(egypt); areas.add(america); areas.add(british); areas.add(dutch); areas.add(french);
        areas.add(greek); areas.add(india); areas.add(italia); areas.add(irish); areas.add(turkey);
        areas.add(tunsia); areas.add(japan); areas.add(mexico); areas.add(morocco); areas.add(russian);
        areas.add(spain); areas.add(vietnam); areas.add(polish);

        breakfast= view.findViewById(R.id.breakfastBtn); chicken= view.findViewById(R.id.chickenBtn);
        dessert= view.findViewById(R.id.dessertBtn); goat= view.findViewById(R.id.goatBtn);
        lamb= view.findViewById(R.id.lambBtn); meat= view.findViewById(R.id.meatBtn);
        pasta= view.findViewById(R.id.pastaBtn); seafood= view.findViewById(R.id.seafoodBtn);
        side= view.findViewById(R.id.sideBtn); starter= view.findViewById(R.id.starterBtn);
        vegan= view.findViewById(R.id.veganBtn); vegiterian= view.findViewById(R.id.vegiterianBtn);
        categories.add(breakfast); categories.add(chicken); categories.add(dessert);
        categories.add(goat); categories.add(lamb); categories.add(meat);
        categories.add(pasta); categories.add(seafood); categories.add(side);
        categories.add(starter); categories.add(vegan); categories.add(vegiterian);

        //RadioGroup radioGroup= (RadioGroup) view.findViewById(R.id.radioGroup);
        //String filterBy = ((RadioButton) view.findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();

        ingredientRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (ImageButton b: ingredients) {
                    b.setVisibility(View.VISIBLE);
                }
                for(ImageButton b : areas){
                    b.setVisibility(View.INVISIBLE);
                }
                for(ImageButton b : categories){
                    b.setVisibility(View.INVISIBLE);
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


        egypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",egypt.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        america.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",america.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        british.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",british.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        dutch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",dutch.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",french.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        greek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",greek.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",india.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        irish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",irish.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        italia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",italia.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        japan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",japan.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        mexico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",mexico.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        morocco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",morocco.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        polish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",polish.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        russian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",russian.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        spain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",spain.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        tunsia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",tunsia.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        turkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",turkey.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        vietnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Area");
                bundle.putString("type",vietnam.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });

        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Category");
                bundle.putString("type",breakfast.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        side.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Category");
                bundle.putString("type",side.getContentDescription().toString());

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
                bundle.putString("filterBy","Category");
                bundle.putString("type",meat.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Category");
                bundle.putString("type",starter.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Category");
                bundle.putString("type",chicken.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        lamb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Category");
                bundle.putString("type",lamb.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        goat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Category");
                bundle.putString("type",goat.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        seafood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Category");
                bundle.putString("type",seafood.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Category");
                bundle.putString("type",dessert.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        vegan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Category");
                bundle.putString("type",vegan.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        vegiterian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Category");
                bundle.putString("type",vegiterian.getContentDescription().toString());

                FilterFragment filterFragment = new FilterFragment();
                filterFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, filterFragment)
                        .commit();
            }
        });
        pasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("filterBy","Category");
                bundle.putString("type",pasta.getContentDescription().toString());

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