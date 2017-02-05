package com.project.drinks;

import com.project.IngredientNames;
import com.project.ingredients.Ingredient;

import java.util.HashMap;

/**
 * Created by ummehunn on 2/4/2017.
 */
public class CaffeAmericano extends Drink{
    public CaffeAmericano(HashMap<IngredientNames, Ingredient> ingredientHashMap) {
        this.name = "Caffe Americano";
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.Espresso), 3);
    }
}
