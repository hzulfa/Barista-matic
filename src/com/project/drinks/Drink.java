package com.project.drinks;

import com.project.Ingredient;

import java.util.HashMap;

/**
 * Drink class is the base class for any drink.
 * Drinks can be created by combining the ingredients in different amounts.
 * This class could be used for all the different drinks created later buy creating different drink objects with different recipes and names but the code could be less maintainable.
 * Concrete classes for each drink has been made so that new drinks can be added without touching previous code base.
 */
public abstract class Drink{

    protected String name;
    protected HashMap<Ingredient, Integer> ingredientMeasurements = new HashMap<>();

    /**
     * This method returns the display name of the drink.
     * @return Display name of the drink
     */
    public String getName(){
        return name;
    }

    /**
     * This method returns the recipe of the Drink.
     * The ingredientMeasurements hashmap contains the recipe of the drink where the ingredient is the key and amount required to make the drink is the value.
     * @return The recipe of the drink
     */
    public HashMap<Ingredient, Integer> getIngredientMeasurements(){
        return ingredientMeasurements;
    }

    /**
     * This method returns the cost of a drink. The cost of a drink is determined by its component ingredients
     * @return cost of drink
     */
    public double getCost(){
        double cost = 0.0;
        for(Ingredient ingredient: ingredientMeasurements.keySet()){
            cost += ingredient.cost() * ingredientMeasurements.get(ingredient);
        }
        return cost;
    }

}
