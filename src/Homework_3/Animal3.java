/**
 *  George Lake
 *  Homework 3
 *  CS 2235, Dr. Leslie Kerby
 *
 *  This class contains the animals that will be in the river LinkedList
 */

package Homework_3;

public class Animal3 {
    // Instance variables
    private String species = null;
    protected boolean flag;  // will be set by the Superclass if the animal moves right.

    // Constructors
    public Animal3(String s) {
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
