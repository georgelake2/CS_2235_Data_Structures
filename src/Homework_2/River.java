/**
 *  George Lake
 *  Homework 2
 *  CS 2235, Dr. Leslie Kerby
 *
 *  contains MAIN
 */



package Homework_2;
import java.util.Random;

public class River {
    // Instance variables
    private int size = 0;
    private Animal[] animals;

    // Constructors
    public River(int n) {
        animals = new Animal[n];
        size = n;
    }

    // Methods
    public int getSize() {      // in progress
        return size;
    }


    public void initialise() {  // in progress
        /**
         * Randomly fill an array with bears, fish, or nothing (null)
         */
        Random rand = new Random();
        Animal b = new Animal("bear");
        Animal f = new Animal("fish");
        for (int i = 0; i < size; i++) {
            int rand_num = rand.nextInt(3);
            if (rand_num == 2) {
                animals[i] = b;
            } else if (rand_num == 1) {
                animals[i] = f;
            }
            // TEST CODE - REMOVE WHEN DONE
            if (animals[i] != null) {
                System.out.println(animals[i].getSpecies());
            } else {
                System.out.println("null");
            }
            // END TEST CODE
        }
    }

    public void iterate() {     // in progress

    }

    public void moveLeft() {    // in progress

    }

    public void moveRight() {   // in progress

    }

    public void createNew() {   // in progress

    }

    public void add() {  // in progress
        /**
         * This method is invoked when two similar animals collide in a cell.
         * One animal should return home and the other should move to
         * an existing null cell.
         */

    }

    public String summary() {   // in progress
        return summary();
    }

    public boolean allBears() { // in progress
        return allBears();
    }



    // MAIN ----------------------------------------------------
    public static void main(String[] args) {

        River portneuf = new River(10);
        portneuf.initialise();

    }
}
