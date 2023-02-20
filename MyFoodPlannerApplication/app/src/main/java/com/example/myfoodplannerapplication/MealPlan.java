package com.example.myfoodplannerapplication;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName= "Meal_Plan", primaryKeys = {"idMeal", "day","email"})public class MealPlan {
    @NonNull
    public String idMeal;
    @NonNull
    public String day;
    @NonNull
    public String email;
    public String strMeal;
    public String strMealThumb;




    @NonNull
    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(@NonNull String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }


public MealPlan(){}

    @NonNull
    public String getDay() {
        return day;
    }

    public void setDay(@NonNull String day) {
        this.day = day;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public MealPlan(@NonNull String idMeal, String strMeal, String strMealThumb, @NonNull String day, @NonNull String email){
        this.idMeal = idMeal;
        this.strMeal = strMeal;
        this.strMealThumb= strMealThumb;
        this.day=day;
        this.email=email;
    }
}
