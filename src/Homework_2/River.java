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

    public void iterate() {     // in progress
        /**
         * Each iteration should determine if the bears and fish move,
         * and which direction they move, left or right.
         */
        System.out.println("iteration ran");



    }

    public void moveLeft() {    // in progress

    }

    public void moveRight() {   // in progress

    }

    public void createNew() {   // in progress

    }

    public void add(Animal a) {
        /**
         * Search for the first null (empty) cell in the river array.
         * Replace it with a fish or a bear.
         */
        for (int i = 0; i < size; i++) {
            if (animals[i] == null) {
                animals[i] = a;
                break;
            }
        }
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
        portneuf.add(bear);

        // testing allBears Boolean
        if (portneuf.allBears()) { System.out.println("The river is full of bears!"); }
        else { System.out.println("The bears have not won yet!"); }

        // Iteration - Run until the river is full of bears
        int temp = 0;
        do {
            portneuf.iterate();
            System.out.println("temp = " + temp);
            temp ++;
        } while (!portneuf.allBears() & temp < 10);

        // final output string - CANNOT HANDLE NULL
        System.out.println(portneuf.summary());

    }
}
