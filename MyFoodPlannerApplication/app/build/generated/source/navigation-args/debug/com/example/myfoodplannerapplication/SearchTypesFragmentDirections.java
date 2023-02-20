package com.example.myfoodplannerapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SearchTypesFragmentDirections {
  private SearchTypesFragmentDirections() {
  }

  @NonNull
  public static ActionSearchTypesFragmentToFilterFragment actionSearchTypesFragmentToFilterFragment(
      @NonNull String filterByArgument) {
    return new ActionSearchTypesFragmentToFilterFragment(filterByArgument);
  }

  public static class ActionSearchTypesFragmentToFilterFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionSearchTypesFragmentToFilterFragment(@NonNull String filterByArgument) {
      if (filterByArgument == null) {
        throw new IllegalArgumentException("Argument \"filterByArgument\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("filterByArgument", filterByArgument);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionSearchTypesFragmentToFilterFragment setFilterByArgument(
        @NonNull String filterByArgument) {
      if (filterByArgument == null) {
        throw new IllegalArgumentException("Argument \"filterByArgument\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("filterByArgument", filterByArgument);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("filterByArgument")) {
        String filterByArgument = (String) arguments.get("filterByArgument");
        __result.putString("filterByArgument", filterByArgument);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_searchTypesFragment_to_filterFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getFilterByArgument() {
      return (String) arguments.get("filterByArgument");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionSearchTypesFragmentToFilterFragment that = (ActionSearchTypesFragmentToFilterFragment) object;
      if (arguments.containsKey("filterByArgument") != that.arguments.containsKey("filterByArgument")) {
        return false;
      }
      if (getFilterByArgument() != null ? !getFilterByArgument().equals(that.getFilterByArgument()) : that.getFilterByArgument() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getFilterByArgument() != null ? getFilterByArgument().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionSearchTypesFragmentToFilterFragment(actionId=" + getActionId() + "){"
          + "filterByArgument=" + getFilterByArgument()
          + "}";
    }
  }
}
