package com.example.myfoodplannerapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myfoodplannerapplication.MealFullDetailes;

@Database(entities = {MealFullDetailes.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance = null;
    public abstract MealDao mealDao();
    public static synchronized AppDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,
                    "favMVCdb") .build();
        }
        return instance;
    }
}