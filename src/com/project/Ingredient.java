package com.project;

/**
 * This Enum holds the display names and the costs of each ingredient.
 * If a new ingredient needs to be added, a new enum value needs to be added here. Everything else will be automatically updated.
 * Per-unit ingredient costs are stored here.
 * <ul>
 *     <li>Coffee $0.75</li>
 *     <li>Decaf Coffee $0.75</li>
 *     <li>Sugar $0.25</li>
 *     <li>Cream $0.25</li>
 *     <li>Steamed Milk $0.35</li>
 *     <li>Foamed Milk $0.35</li>
 *     <li>Espresso $1.10</li>
 *     <li>Cocoa $0.90</li>
 *     <li>Whipped Cream $1.00</li>
 * </ul>
 */
public enum Ingredient {
    Coffee("Coffee", 0.75),
    DecafCoffee("Decaf Coffee", 0.75),
    Sugar("Sugar", 0.25),
    Cream("Cream", 0.25),
    SteamedMilk("Steamed Milk", 0.35),
    FoamedMilk("Foamed Milk", 0.35),
    Espresso("Espresso", 1.10),
    Cocoa("Cocoa", 0.90),
    WhippedCream("Whipped Cream", 1.00);

    private final String description;
    private double cost;

    Ingredient(String description, double cost) {
        this.cost = cost;
        this.description = description;
    }

    public String description() {
        return description;
    }

    public double cost() {
        return cost;
    }
}
