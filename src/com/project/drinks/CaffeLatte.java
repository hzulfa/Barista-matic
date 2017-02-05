package com.project.drinks;

import com.project.IngredientNames;
import com.project.ingredients.Ingredient;

import java.util.HashMap;

/**
 * Created by ummehunn on 2/4/2017.
 */
public class CaffeLatte extends Drink {
    public CaffeLatte(HashMap<IngredientNames, Ingredient> ingredientHashMap) {
        this.name = "Caffe Latte";
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.Espresso), 2);
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.SteamedMilk),1);
    }
}
