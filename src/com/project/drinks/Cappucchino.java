package com.project.drinks;

import com.project.IngredientNames;
import com.project.ingredients.Ingredient;

import java.util.HashMap;

/**
 * Created by ummehunn on 2/4/2017.
 */
public class Cappucchino extends Drink{
    public Cappucchino(HashMap<IngredientNames, Ingredient> ingredientHashMap) {
        this.name = "Cappucchino";

        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.Espresso), 2);
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.SteamedMilk), 1);
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.FoamedMilk), 1);
    }
}
