package com.example.rihaf.diabetesdietexpert;

/**
 * Created by rihaf on 12/21/2016.
 */
public class DataProvidergol {
    private String mealtime;
    private String calorie;
    private String carbo;
    private String protein;
    private String veggie;
    private String fruit;
    private String milk;

    public String getMealtime() {
        return mealtime;
    }

    public void setMealtime(String mealtime) {
        this.mealtime = mealtime;
    }

    public String getCalorie() {
        return calorie;
    }

    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }

    public String getCarbo() {
        return carbo;
    }

    public void setCarbo(String carbo) {
        this.carbo = carbo;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getVeggie() {
        return veggie;
    }

    public void setVeggie(String veggie) {
        this.veggie = veggie;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public DataProvidergol(String mealtime, String calorie, String carbo, String protein, String veggie, String fruit, String milk)
    {
        this.mealtime = mealtime;
        this.calorie = calorie;
        this.carbo = carbo;
        this.protein = protein;
        this.veggie = veggie;
        this.fruit = fruit;
        this.milk = milk;


    }
}
