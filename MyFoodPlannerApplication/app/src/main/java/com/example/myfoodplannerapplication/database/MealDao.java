package com.example.myfoodplannerapplication.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.myfoodplannerapplication.MealFullDetailes;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myfoodplannerapplication.MealFullDetailes;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface MealDao {
    @Query("SELECT * From Meals")
    Observable<List<MealFullDetailes>> getMeals();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertMeal (MealFullDetailes meal);
    @Delete
    Completable deleteMeal (MealFullDetailes meal);

}
