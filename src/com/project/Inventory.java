package com.project;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * The inventory class represents the ingredient inventory. The capacity of each ingredient is 10 according to the specification.
 * Each time its restocked, all the ingredient quantities become 10.
 * This class is only used by the Barista-matic class therefore was not made a singleton class.
 * @author ummehunn
 */

public class Inventory {

    /**
     * Initially the Barista-matic contains 10 units of all ingredients, and restocking the machine restores each ingredient to a maximum of 10 units.
     *
     * @param ingredient
     */

    private int SIZE = 10;

    /**
     * This TreeMap contains the ingredient enum as key and holds the current quantity.
     */
    private TreeMap<Ingredient, Integer> quantity = new TreeMap<>(new IngredientNameComparator());

    /**
     * This method is used to set the size of the inventory
     *
     * @param SIZE The size of the inventory for each ingredient. If invalid size is used, default is assumed.
     */
    public Inventory(int SIZE) {
        if(SIZE > 0){
            this.SIZE = SIZE;
        }
    }

    /**
     * This method is used to stock the intended ingredient as per the SIZE.
     * If the same ingredient is stocked more than once, the amount is rewritten since hashmap.
     * @param ingredient Stock the specified ingredient.
     */
    public void stockIngredient(Ingredient ingredient) {
        quantity.put(ingredient, SIZE);
    }

    /**
     * This method is used to stock all ingredient as per the SIZE.
     */
    public void stockAll() {
        for (Ingredient ingredient : Ingredient.values()) {
            stockIngredient(ingredient);
        }
    }

    /**
     * This method gets the quantitity of the ingredient passed as a parameter.
     *
     * @param ingredient To get the quantity of this ingredient.
     * @return quantity of the ingredient, -1 if the key does not exist
     */
    public int getQuatity(Ingredient ingredient) {
        if(quantity.containsKey(ingredient))
            return quantity.get(ingredient);
        return -1;
    }

    /**
     * This method is used to use up spcified amount of an ingredient from the inventory. It is used during dispensing of a selected drink.
     * @param ingredient The ingredient to use
     * @param amount Amount of the ingredient
     */
    public void useIngredient(Ingredient ingredient, int amount) {
        if(quantity.containsKey(ingredient)){
            int newAmount =  quantity.get(ingredient) - amount;
            if(newAmount> 0){
                quantity.put(ingredient, newAmount);
            }else {
                // amount cannot be negative. Since we will be testing the availability before calling this method, this condition should never happen.
                // ideally in such a case the method should throw exception.
                quantity.put(ingredient, 0);
            }
        }
    }

    /**
     * This method displays the inventory status in alphabetic order (by ingredient name or drink name, respectively), in the following format:<p>
     * Inventory:<p>
     * [ingredient name,quantity in inventory]
     */
    public void printInventory() {
        System.out.println("Inventory:");
        for (Ingredient ingredient : quantity.keySet()) {
            System.out.println(ingredient.description() + "," + quantity.get(ingredient));
        }
    }

    /**
     * This comparator is used to keep the ingredient list sorted according to the name of the ingredient.
     */
    class IngredientNameComparator implements Comparator<Ingredient> {
        @Override
        public int compare(Ingredient a, Ingredient b) {
            return a.description().compareTo(b.description());
        }
    }

}
