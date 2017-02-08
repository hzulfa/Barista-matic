package com.project.drinks;

import com.project.Ingredient;

/**
 * The Caffe Americano drink is made of 3 unit espresso.
 */
public class CaffeAmericano extends Drink{
    public CaffeAmericano() {
        this.name = "Caffe Americano";
        this.ingredientMeasurements.put(Ingredient.Espresso, 3);
    }
}
