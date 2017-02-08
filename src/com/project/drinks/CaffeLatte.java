package com.project.drinks;

import com.project.Ingredient;

/**
 * The Caffe Latte drink is made of 2 unit espresso and  1 unit steamed milk.
 */
public class CaffeLatte extends Drink {
    public CaffeLatte() {
        this.name = "Caffe Latte";
        this.ingredientMeasurements.put(Ingredient.Espresso, 2);
        this.ingredientMeasurements.put(Ingredient.SteamedMilk,1);
    }
}
