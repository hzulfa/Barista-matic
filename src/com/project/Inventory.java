package com.project;

import com.project.drinks.Drink;
import com.project.ingredients.Ingredient;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * Created by ummehunn on 2/4/2017.
 */
//TODO singleton
public class Inventory {
    int SIZE = 10;

    TreeMap<Ingredient, Integer> quantity = new TreeMap<Ingredient, Integer>(new IngredientNameComparator());
    ArrayList<Drink> drinks = new ArrayList<Drink>();

    public void stockIngredient(Ingredient ingredient){
        quantity.put(ingredient, SIZE);
    }

    public void stockAll(ArrayList<Ingredient> ingredients){
        for (Ingredient ingredient: ingredients) {
            stockIngredient(ingredient);
        }
    }

    public void addDrinks(ArrayList<Drink> drinks){
        this.drinks = drinks;
        Collections.sort(drinks,
                (o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    public int getQuantity(String ingredient){
        return quantity.get(ingredient);
    }

    public ArrayList<Drink> getDrinks(){
        return drinks;
    }

    public boolean getAvailability(Drink drink){
        HashMap<Ingredient,Integer> ingredientMesureMent = drink.getIngredientMeasurements();
        for (Ingredient ingredient: ingredientMesureMent.keySet()){
            if(quantity.get(ingredient) < ingredientMesureMent.get(ingredient)){
                return false;
            }
        }
        return true;
    }



    public void printInventory(){
        System.out.println("Inventory:");
        for (Ingredient ingredient: quantity.keySet()) {
            System.out.println(ingredient.getName() + ", " + quantity.get(ingredient));
        }
    }


    public void printMenu(){
        System.out.println("Menu:");
        int i=1;
        NumberFormat formatter = new DecimalFormat("#0.00");
        for (Drink drink: drinks) {
            System.out.println(i++  +","+drink.getName() + ", $" + formatter.format(drink.getCost())+","+getAvailability(drink));
        }
    }

    public void dispenseDrink(Drink drink){
        HashMap<Ingredient, Integer> measureMents = drink.getIngredientMeasurements();
        for (Ingredient ingredient: measureMents.keySet()){
            quantity.put(ingredient, quantity.get(ingredient)- measureMents.get(ingredient));
        }
        System.out.println("Dispensing: " + drink.getName());
    }

    class IngredientNameComparator implements Comparator<Ingredient> {

        @Override
        public int compare(Ingredient a, Ingredient b) {
            return a.getName().compareTo(b.getName());
        }
    }


}
