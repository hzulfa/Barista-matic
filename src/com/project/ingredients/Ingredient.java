package com.project.ingredients;

/**
 * Created by ummehunn on 2/4/2017.
 */
public class Ingredient implements Comparable{
    String name;
    double cost;

    public double getCost(){
        return this.cost;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
