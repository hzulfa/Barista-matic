package com.project.drinks;

import com.project.IngredientNames;
import com.project.ingredients.Ingredient;

import java.util.HashMap;

/**
 * Created by ummehunn on 2/4/2017.
 */
public class DecafCoffee extends Drink{
    public DecafCoffee(HashMap<IngredientNames, Ingredient> ingredientHashMap) {
        this.name = "Decaf Coffee";
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.DecafCoffee), 3);
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.Sugar),1);
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.Cream),1);
    }


}
