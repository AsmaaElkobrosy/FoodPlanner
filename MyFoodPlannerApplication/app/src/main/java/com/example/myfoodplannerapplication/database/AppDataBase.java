package com.example.myfoodplannerapplication.database;

import android.content.Context;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myfoodplannerapplication.MealFullDetailes;
import com.example.myfoodplannerapplication.plan.model.MealPlan;

@Database(entities = {MealFullDetailes.class, MealPlan.class}, version = 2 /*autoMigrations = {
        @AutoMigration(from = 1, to = 2)}*/)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance = null;
    public abstract MealDao mealDao();
    public abstract PlanDao planDao();
    /*static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE `Meal_Plan` (`idMeal` TEXT, "+" `day` TEXT, "
                    + "`email` TEXT," + " `strMeal`TEXT, " + " `strMealThumb` TEXT,  PRIMARY KEY(`idMeal`, `day`))");
            database.execSQL("ALTER TABLE Meals " + " ADD COLUMN `email` TEXT");
        }
    };*/
    public static synchronized AppDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,
                    "favMVCdb").fallbackToDestructiveMigration().build();
            //.addMigrations(MIGRATION_1_2)
        }
        return instance;
    }
}
