package com.project.drinks;

import com.project.Ingredient;

/**
 * The Coffee drink is made of 3 units of coffee, 1 unit sugar and 1 unit cream.
 */
public class Coffee extends Drink {
    public Coffee() {
        this.name = "Coffee";
        this.ingredientMeasurements.put(Ingredient.Coffee, 3);
        this.ingredientMeasurements.put(Ingredient.Sugar,1);
        this.ingredientMeasurements.put(Ingredient.Cream,1);
    }
}
