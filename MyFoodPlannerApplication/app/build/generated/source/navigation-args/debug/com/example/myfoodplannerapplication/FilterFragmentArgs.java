package com.example.myfoodplannerapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class FilterFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private FilterFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private FilterFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static FilterFragmentArgs fromBundle(@NonNull Bundle bundle) {
    FilterFragmentArgs __result = new FilterFragmentArgs();
    bundle.setClassLoader(FilterFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("filterByArgument")) {
      String filterByArgument;
      filterByArgument = bundle.getString("filterByArgument");
      if (filterByArgument == null) {
        throw new IllegalArgumentException("Argument \"filterByArgument\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("filterByArgument", filterByArgument);
    } else {
      throw new IllegalArgumentException("Required argument \"filterByArgument\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static FilterFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    FilterFragmentArgs __result = new FilterFragmentArgs();
    if (savedStateHandle.contains("filterByArgument")) {
      String filterByArgument;
      filterByArgument = savedStateHandle.get("filterByArgument");
      if (filterByArgument == null) {
        throw new IllegalArgumentException("Argument \"filterByArgument\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("filterByArgument", filterByArgument);
    } else {
      throw new IllegalArgumentException("Required argument \"filterByArgument\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getFilterByArgument() {
    return (String) arguments.get("filterByArgument");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("filterByArgument")) {
      String filterByArgument = (String) arguments.get("filterByArgument");
      __result.putString("filterByArgument", filterByArgument);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("filterByArgument")) {
      String filterByArgument = (String) arguments.get("filterByArgument");
      __result.set("filterByArgument", filterByArgument);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    FilterFragmentArgs that = (FilterFragmentArgs) object;
    if (arguments.containsKey("filterByArgument") != that.arguments.containsKey("filterByArgument")) {
      return false;
    }
    if (getFilterByArgument() != null ? !getFilterByArgument().equals(that.getFilterByArgument()) : that.getFilterByArgument() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getFilterByArgument() != null ? getFilterByArgument().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "FilterFragmentArgs{"
        + "filterByArgument=" + getFilterByArgument()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull FilterFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String filterByArgument) {
      if (filterByArgument == null) {
        throw new IllegalArgumentException("Argument \"filterByArgument\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("filterByArgument", filterByArgument);
    }

    @NonNull
    public FilterFragmentArgs build() {
      FilterFragmentArgs result = new FilterFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setFilterByArgument(@NonNull String filterByArgument) {
      if (filterByArgument == null) {
        throw new IllegalArgumentException("Argument \"filterByArgument\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("filterByArgument", filterByArgument);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getFilterByArgument() {
      return (String) arguments.get("filterByArgument");
    }
  }
}
