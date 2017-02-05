package com.project.drinks;

import com.project.IngredientNames;
import com.project.ingredients.*;

import java.util.HashMap;

/**
 * Created by ummehunn on 2/4/2017.
 */
public class CaffeMocha extends Drink{
    public CaffeMocha(HashMap<IngredientNames, Ingredient> ingredientHashMap) {
        this.name = "Caffe Mocha";
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.Espresso), 1);
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.Cocoa), 1);
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.SteamedMilk), 1);
        this.ingredientMeasurements.put(ingredientHashMap.get(IngredientNames.WhippedCream), 1);
    }
}
