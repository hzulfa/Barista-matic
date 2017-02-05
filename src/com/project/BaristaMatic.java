package com.project;

import com.project.drinks.*;
import com.project.ingredients.*;
import com.project.ingredients.Coffee;
import com.project.ingredients.DecafCoffee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ummehunn on 2/4/2017.
 */
public class BaristaMatic {

    HashMap<IngredientNames, Ingredient> ingredients = new HashMap<>();
    ArrayList<Drink> drinks = new ArrayList<>();
    Inventory inventory = new Inventory();

    public BaristaMatic() {
        createIngredientList();
        createMenu();
        createInventory();
    }

    public void createIngredientList(){

        Coffee coffee = new Coffee();
        DecafCoffee decafCoffee = new DecafCoffee();
        Sugar sugar = new Sugar();
        Cream cream = new Cream();
        SteamedMilk steamedMilk = new SteamedMilk();
        FoamedMilk foamedMilk = new FoamedMilk();
        Espresso espresso = new Espresso();
        Cocoa cocoa = new Cocoa();
        WhippedCream whippedCream = new WhippedCream();

        ingredients.put(IngredientNames.Coffee, coffee);
        ingredients.put(IngredientNames.DecafCoffee, decafCoffee);
        ingredients.put(IngredientNames.Sugar, sugar);
        ingredients.put(IngredientNames.Cream, cream);
        ingredients.put(IngredientNames.SteamedMilk, steamedMilk);
        ingredients.put(IngredientNames.FoamedMilk, foamedMilk);
        ingredients.put(IngredientNames.Espresso, espresso);
        ingredients.put(IngredientNames.Cocoa, cocoa);
        ingredients.put(IngredientNames.WhippedCream, whippedCream);
    }

    public void createMenu(){
        com.project.drinks.Coffee drinkCoffee =  new com.project.drinks.Coffee(ingredients);
        com.project.drinks.DecafCoffee drinkDecafCoffee = new com.project.drinks.DecafCoffee(ingredients);
        CaffeLatte caffeLatte = new CaffeLatte(ingredients);
        CaffeAmericano caffeAmericano = new CaffeAmericano(ingredients);
        CaffeMocha caffeMocha = new CaffeMocha(ingredients);
        Cappucchino cappucchino = new Cappucchino(ingredients);
        drinks.addAll(Arrays.asList(drinkCoffee, drinkDecafCoffee, caffeLatte, caffeAmericano, caffeMocha, cappucchino));
    }

    public void stockInventory(){
        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        for (Ingredient ingredient: ingredients.values()){
            ingredientList.add(ingredient);
        }
        inventory.stockAll(ingredientList);
    }

    public void createInventory(){
        stockInventory();
        inventory.addDrinks(drinks);
    }

    public void processInput(int choice){
        char ch = (char)choice;
        if(Character.isDigit(ch)){
            choice = Character.getNumericValue(ch);
            if( choice> 0 && choice <= inventory.drinks.size()){
                Drink drink = inventory.getDrinks().get(choice-1);
                if(inventory.getAvailability(drink))
                    inventory.dispenseDrink(drink);
                else
                    System.out.println("Out of Stock: " + drink.getName());
                return;
            }
        }
        System.out.println("Invalid selection: " + ch);
    }
}
