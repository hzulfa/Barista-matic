package com.project.drinks;

import com.project.Ingredient;

/**
 * The Caffe Mocha drink is made of 1 unit espresso, 1 unit of cocoa, 1 unit steamed milk and 1 unit whipped cream.
 */
public class CaffeMocha extends Drink{
    public CaffeMocha() {
        this.name = "Caffe Mocha";
        this.ingredientMeasurements.put(Ingredient.Espresso, 1);
        this.ingredientMeasurements.put(Ingredient.Cocoa, 1);
        this.ingredientMeasurements.put(Ingredient.SteamedMilk, 1);
        this.ingredientMeasurements.put(Ingredient.WhippedCream, 1);
    }
}
