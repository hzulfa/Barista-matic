package com.project.drinks;

import com.project.Ingredient;

/**
 * The Cuppuccino drink is made of 2 units of espresso, 1 unit steamed milk and 1 unit foamed milk.
 */
public class Cappuccino extends Drink{
    public Cappuccino() {
        this.name = "Cappuccino";

        this.ingredientMeasurements.put(Ingredient.Espresso, 2);
        this.ingredientMeasurements.put(Ingredient.SteamedMilk, 1);
        this.ingredientMeasurements.put(Ingredient.FoamedMilk, 1);
    }
}
