/**
 *  George Lake
 *  Homework 2
 *  CS 2235, Dr. Leslie Kerby
 *
 *  contains MAIN
 */
package Homework_2;
import java.util.Arrays;
import java.util.Random;


public class River {
    // Instance variables -------------------------------
    private int size = 0;
    private Animal[] animals;


    // Constructors -------------------------------------
    public River(int n) {
        animals = new Animal[n];
        size = n;
    }

    // Methods ------------------------------------------
    public int getSize() { // in progress
        /**
         * get the size of the river array.
         * DOES THIS MATTER IF SIZE IS PUBLIC?? ----------------------------
         */
        return size;
    }


    public void initialise(Animal b, Animal f) {  // in progress
        /**
         * Randomly fill an array with bears, fish, or nothing (null)
         */
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int rand_num = rand.nextInt(3);  // randomly assign a number 0-2
            if (rand_num == 2) { animals[i] = b; } // populate with a bear
            else if (rand_num == 1) { animals[i] = f; }  // populate with a fish
        }
    }

    public void iterate(River a) {     // in progress
        /**
         * Each iteration should determine if the bears and fish move,
         * and which direction they move, left or right.
         */
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int rand_num = rand.nextInt(3);  // randomly assign a number 0-2
            if (rand_num == 1) { a.moveLeft(); }
            else if (rand_num == 2) { a.moveRight(); }
            else { System.out.println("Animal did not move"); }
        }
    }

    public void moveLeft() {    // in progress
        /**
         * Move the animal left one space.
         */
        System.out.println("moveLeft ran");
    }

    public void moveRight() {   // in progress
        /**
         * Move the animal right one space.
         */
        System.out.println("moveRight ran");
    }

    public void createNew(Animal a) {   // in progress
        /**
         *  Creates a new animal (bear or fish) and then moves them to a null cell.
         */
        for (int i = 0; i < size; i++) {
            if (animals[i] == null) {
                animals[i] = a;
                break;
            }
        }
    }

    public void add(Animal a) {
        /**
         * Adds a bear to a cell containing a fish if they collide.
         */
    }

    public void remove(Animal a) {
        /**
         * Removes a fish from the array after it encountered a bear.
         */
    }

    public String summary() {   // in progress
        /**
         * Create a summary string displaying the number of bears, fish, and empty spots
         * in the river array.
         */
        String r = "River: \n";

        // NEED TO DETERMINE HOW TO HANDLE A NULL

        return r;
    }


    public boolean allBears() { // in progress
        /**
         * Search the river array
         * Return true if array contains all bears
         * otherwise return false.
         */
        int numBears = 0;

        for (int i = 0; i < size; i++) {
            if (animals[i] != null) {
                if (animals[i].getSpecies() == "bear") {
                    numBears ++;
                }
            }
        }
        System.out.println("allBears ran");
        return numBears == size;

    }



    // MAIN ----------------------------------------------------
    public static void main(String[] args) {
        River portneuf = new River(10);
        Animal bear = new Animal("bear");
        Animal fish = new Animal("fish");

        // populate river array
        portneuf.initialise(bear, fish);

        // testing an animal to the river array - replace with move method
        portneuf.createNew(bear);

        // testing allBears Boolean
        if (portneuf.allBears()) { System.out.println("The river is full of bears!"); }
        else { System.out.println("The bears have not won yet!"); }

        // Iteration - Run until the river is full of bears
//        do {
//            portneuf.iterate(portneuf);
//
//        } while (!portneuf.allBears());
        portneuf.iterate(portneuf);

        // final output string - CANNOT HANDLE NULL
        System.out.println(portneuf.summary());

    }
}
