package com.example.myfoodplannerapplication;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class FilterFragmentDirections {
  private FilterFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionFilterFragmentToOneMealFragment() {
    return new ActionOnlyNavDirections(R.id.action_filterFragment_to_oneMealFragment);
  }
}
