package com.project.drinks;

import com.project.IngredientNames;
import com.project.ingredients.Ingredient;

import java.util.HashMap;

/**
 * Created by ummehunn on 2/4/2017.
 */
public class Coffee extends Drink {
    public Coffee(HashMap<IngredientNames, Ingredient> ingredientHashMap) {
        this.name = "Coffee";
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.Coffee), 3);
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.Sugar),1);
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.Cream),1);
    }
}
