/**
 *  George Lake
 *  Homework 2
 *  CS 2235, Dr. Leslie Kerby
 *
 *  This class contains the animals that will be in the river array
 */

package Homework_2;

public class Animal {
    // Instance variables
    private String species = null;
    protected boolean flag;  // will be set by the Superclass if the animal moves right.

    // Constructors
    public Animal(String s) {
        species = s;
    }

    // Methods
    public String getSpecies() {
        return species;
    }

    public Boolean getFlag() {
        return flag;
    }

}
