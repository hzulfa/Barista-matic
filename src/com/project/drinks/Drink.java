package com.project.drinks;

import com.project.ingredients.Ingredient;

import java.util.HashMap;

/**
 * Created by ummehunn on 2/4/2017.
 */
public abstract class Drink{
    String name;

    HashMap<Ingredient, Integer> ingredientMeasurements = new HashMap<>();
    public String getName(){
        return name;
    }
    public double getCost(){
        double cost = 0.0;
        for(Ingredient ingredient: ingredientMeasurements.keySet()){
            cost +=ingredient.getCost()*ingredientMeasurements.get(ingredient);
        }
        return cost;
    }

    public HashMap<Ingredient, Integer> getIngredientMeasurements(){
        return ingredientMeasurements;
    }

}
