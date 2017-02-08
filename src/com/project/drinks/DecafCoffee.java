package com.project.drinks;

import com.project.Ingredient;

/**
 * The Decaf Coffee drink is made of 3 units of decaf coffee, 1 unit sugar and 1 unit cream.
 */
public class DecafCoffee extends Drink{
    public DecafCoffee() {
        this.name = "Decaf Coffee";
        this.ingredientMeasurements.put(Ingredient.DecafCoffee, 3);
        this.ingredientMeasurements.put(Ingredient.Sugar,1);
        this.ingredientMeasurements.put(Ingredient.Cream, 1);
    }


}
