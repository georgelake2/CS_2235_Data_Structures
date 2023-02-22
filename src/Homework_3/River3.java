/**
 *  George Lake
 *  Homework 3
 *  CS 2235, Dr. Leslie Kerby
 *
 *  contains MAIN
 */
package Homework_3;

import java.util.Random;

public class River3 {
    // Instance variables -------------------------------
    private int size = 0;
    private DoublyLinkedList3<Animal3> animals;

    // Constructors -------------------------------------
    public River3(int n) {
        animals = new DoublyLinkedList3<Animal3>();
        size = n;
    }


    // Methods ------------------------------------------
    public int getSize() {
        /*
         * get the size of the river
         */
        return size;
    }

    public void initialize(Animal3 b, Animal3 f) {
        /*
         * Randomly fill with bears, fish, or nothing (null)
         */
        Random rand = new Random();
        int numBears = 0;  // counts number of bears

        for (int i = 0; i < size; i++) {
            int rand_num = rand.nextInt(3);
            if (rand_num == 1) { animals.addFirst(b); }
            else if (rand_num == 2) { animals.addFirst(f); }
            else { animals.addFirst(null); }
        }


        // randomly assign a number 0-2
        // populate with a bear
        // populate with a fish

        // Loop to count the number of bears.

        // If there are less than 2 bears, manually add.  Otherwise, there will be an infinite loop.


    }

    public void iterate(River3 a) {
        /*
         * Each iteration should determine if the bears and fish move,
         * and which direction they move, left or right.
         */
        Random rand = new Random();

        // reset movement flags

        // randomly attempt to move right, left, or stay on each cell in the array.

        // only move if the cell contains an animal
        // only move if the animal has yet to move
        // randomly assign a number 0-2

    }

    public void moveLeft() {
        /*
         * Move the animal left one space.
         * First cell does not move
         * If the animals are the same - original cell = null, new cell = animal, replace a null cell with animal
         * If bear moves to fish - original cell = null, new cell = bear, remove fish
         * If animal moves to null - original cell = null, new cell = animal
         */
        // if index is not zero
        // bear or fish moves to null

        // animals are the same

        // fish moves to bear or bear moves to fish

        // bear and fish collide

    }

    public void moveRight() {
        /*
         * Move the animal right one space.
         * Last cell does not move
         * If the animals are the same - original cell = null, new cell = animal, replace a null cell with animal
         * If bear moves to fish - original cell = null, new cell = bear, remove fish
         * If animal moves to null - original cell = null, new cell = animal
         * -
         * Movement Flags -
         * If a bear or fish move right onto a null cell
         * If a bear moves right to a fish cell
         * Do not trigger if a fish moves to bear.
         * Do not trigger flag if a new animal is created
         */
        // if index is not the last cell
        // new cell is null
        // animal has moved this round

        // animals are the same

        // bear moves to fish
        // the bear moved this round

        // fish moves to bear

    }

    public void createNew() {
        /*
         *  Creates a new animal (bear or fish) and then moves them to a null cell.
         */

    }

    public void addAnimal(int a) {
        /*
         * Adds a bear to a cell containing a fish if they collide.
         */
    }

    public void removeAnimal(int a) {
        /*
         * Removes a fish from the array after it encountered a bear.
         */
    }

//    public String summary(int s) {
//        int bears = 0;
//        int fish = 0;
//        int empty = 0;
//
//        for (int i = 0; i < size; i++) {
//
//        }
//
//        String r = "-----------------------------\n";
//        r += "| Step Number : ";
//        r += s + "\t\t\t|\n";
//        r += "-----------------------------\n";
//        r += "| There are currently:\t\t|\n";
//        r += "| " + fish + " fish\t\t\t\t\t|\n";
//        r += "| " + bears + " bear(s)\t\t\t\t|\n";
//        r += "| " + empty + " null cell(s)\t\t\t|\n";
//        r += "-----------------------------\n";
//        return r;
//    }

    public String toString() {
        /*
         * Create a summary string displaying the number of bears, fish, and empty spots
         * in the river array.
         */

        String sb = "test";
        DoublyLinkedList3.Node<Animal3> walk = animals.header.getNext();
        int num = 1;
        for (int i = 0; i < animals.size(); i++) {
            if (walk.getElement() != null) {
                sb += num + ". " + walk.getElement().getSpecies() + "\n";
            } else { sb += num + ". null \n"; }
            walk = walk.getNext();
            num ++;
        }
        return sb;
    }

    public boolean allBears() {
        /*
         * Search the river array
         * Return true if array contains all bears
         * otherwise return false.
         */
        int numBears = 0;
        for (int i = 0; i < size; i++) {

        }
        return numBears == size;
    }

    // MAIN ----------------------------------------------------
    public static void main(String[] args) {
        River3 snakeRiver = new River3(10);
        Animal3 bear = new Animal3("bear");
        Animal3 fish = new Animal3("fish");

        // Initialize - populate river array
        snakeRiver.initialize(bear, fish);

        // Iteration - Run until the river is full of bears
        int n = 0;
//        do {
//            n++;
//            portneuf.iterate(portneuf);
//            System.out.println(portneuf.summary(n));
//        } while (!portneuf.allBears());

        // Program completion output
        System.out.println(snakeRiver);


    }
}
