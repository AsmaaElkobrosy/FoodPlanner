package com.example.myfoodplannerapplication;

import java.util.ArrayList;

public class MealFullDetailes {

    ArrayList<String> ingredients= new ArrayList<>();
    String idMeal;
    String strMeal;
    String strCategory;
    String strArea;
    String strInstructions;
    String strMealThumb;
    String strYoutube;
    String strIngredient1;
    String strIngredient2;
    String strIngredient3;
    String strIngredient4;



    String strIngredient5;
    String strIngredient6;
    String strIngredient7;
    String strIngredient8;

    public String getStrIngredient1() {
        return strIngredient1;
    }
    public String getStrIngredient2() {
        return strIngredient2;
    }

    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public void setStrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public void setStrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }

    public String getStrIngredient6() {
        return strIngredient6;
    }

    public void setStrIngredient6(String strIngredient6) {
        this.strIngredient6 = strIngredient6;
    }

    public String getStrIngredient7() {
        return strIngredient7;
    }

    public void setStrIngredient7(String strIngredient7) {
        this.strIngredient7 = strIngredient7;
    }

    public String getStrIngredient8() {
        return strIngredient8;
    }

    public void setStrIngredient8(String strIngredient8) {
        this.strIngredient8 = strIngredient8;
    }

    public String getStrIngredient9() {
        return strIngredient9;
    }

    public void setStrIngredient9(String strIngredient9) {
        this.strIngredient9 = strIngredient9;
    }

    public String getStrIngredient10() {
        return strIngredient10;
    }

    public void setStrIngredient10(String strIngredient10) {
        this.strIngredient10 = strIngredient10;
    }

    public String getStrIngredient11() {
        return strIngredient11;
    }

    public void setStrIngredient11(String strIngredient11) {
        this.strIngredient11 = strIngredient11;
    }

    public String getStrIngredient12() {
        return strIngredient12;
    }
    public String getStrIngredient13() {
        return strIngredient13;
    }

    public void setStrIngredient12(String strIngredient12) {
        this.strIngredient12 = strIngredient12;
    }
    public void setStrIngredient13(String strIngredient13) {
        this.strIngredient13 = strIngredient13;
    }
    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    String strIngredient9;
    String strIngredient10;
    String strIngredient11;
    String strIngredient12;
    String strIngredient13;
    String strMeasure1;
    String strMeasure2;
    String strMeasure3;
    String strMeasure4;
    String strMeasure5;
    String strMeasure6;
    String strMeasure7;
    String strMeasure8;
    String strMeasure9;
    String strMeasure10;
    String strMeasure11;
    String strMeasure12;
    String strMeasure13;
    ArrayList<String> measures= new ArrayList<>();

    public MealFullDetailes(String idMeal, String strMeal, String strCategory, String strArea, String strInstructions, String strMealThumb, String strYoutube) {
        this.idMeal = idMeal;
        this.strMeal = strMeal;
        this.strCategory = strCategory;
        this.strArea = strArea;
        this.strInstructions = strInstructions;
        this.strMealThumb = strMealThumb;
        this.strYoutube = strYoutube;
    }

    public ArrayList<String> getIngredients(){
        return ingredients;
    }

    public  ArrayList<String> setIngredients(){    ingredients.add(getStrIngredient1());    ingredients.add(strIngredient2);    ingredients.add(strIngredient3);    ingredients.add(strIngredient4);    ingredients.add(strIngredient5);    ingredients.add(strIngredient6);    ingredients.add(strIngredient7);    ingredients.add(strIngredient8);    ingredients.add(strIngredient9);    ingredients.add(strIngredient10);    ingredients.add(strIngredient11);
        ingredients.add(strIngredient12);    ingredients.add(strIngredient13);    return ingredients;}

    public ArrayList<String> getMeasures(){
        return measures;
    }

    public void setMeasures(String measure){
        ingredients.add(measure);
    }

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

}
