package com.example.myfoodplannerapplication.home.view;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.myfoodplannerapplication.R;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionHomeFragmentToMyWeeklyPlanFragment2() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_myWeeklyPlanFragment2);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToFavouriteFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_favouriteFragment);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToSearchTypesFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_searchTypesFragment);
  }
}
