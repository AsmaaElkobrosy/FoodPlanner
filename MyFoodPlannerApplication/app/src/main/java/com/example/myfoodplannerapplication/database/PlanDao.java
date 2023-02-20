package com.example.myfoodplannerapplication.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.myfoodplannerapplication.plan.model.MealPlan;

import java.util.List;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Observable;


@Dao
public interface PlanDao {
    @Query("SELECT * From Meal_Plan")
    Observable<List<MealPlan>> getMeals();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertMeal(MealPlan meal);

    @Delete
    Completable deleteMeal(MealPlan meal);
    @Query("DELETE FROM Meal_Plan")
    Completable deleteAllPlannedMeals();
}
