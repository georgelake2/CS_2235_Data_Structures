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
    // Instance variables -------------------------------
    private int size = 0;
    private Animal[] animals;


    // Constructors -------------------------------------
    public River(int n) {
        animals = new Animal[n];
        size = n;
    }

    // Methods ------------------------------------------
    public int getSize() {
        /**
         * get the size of the river array
         */
        return size;
    }

    public void initialize(Animal b, Animal f) {
        /**
         * Randomly fill an array with bears, fish, or nothing (null)
         */
        Random rand = new Random();
        int numBears = 0;  // counts number of bears

        for (int i = 0; i < size; i++) {
            int rand_num = rand.nextInt(3);  // randomly assign a number 0-2
            if (rand_num == 2) { animals[i] = b; } // populate with a bear
            else if (rand_num == 1) { animals[i] = f; }  // populate with a fish
        }
        // Loop to count the number of bears.
        for (int i = 0; i < size; i++) {
            if (animals[i] != null) {
                if (animals[i].getSpecies() == "bear") { numBears++; }
            }
        }
        // If there are less than 2 bears, manually add.  Otherwise, there will be an infinite loop.
        if (numBears == 0) { animals[0] = b; animals[1] = b; }
        else if (numBears == 1) { animals[0] = b; }

    }

    public void iterate(River a) {
        /**
         * Each iteration should determine if the bears and fish move,
         * and which direction they move, left or right.
         */
        Random rand = new Random();

        // reset movement flags
        for (int i = 0; i < size; i++) {
            if (animals[i] != null) { animals[i].flag = false; }
        }

        // randomly attempt to move right, left, or stay on each cell in the array.
        for (int i = 0; i < size; i++) {
            if (animals[i] != null) { // only move if the cell contains an animal
                if (!animals[i].getFlag()) { // only move if the animal has yet to move
                    int rand_num = rand.nextInt(3);  // randomly assign a number 0-2
                    if (rand_num == 1) { a.moveLeft(i); }
                    else if (rand_num == 2) { a.moveRight(i); }
                }
            }
        }
    }

    public void moveLeft(int cell) {
        /**
         * Move the animal left one space.
         * First cell does not move
         * If the animals are the same - original cell = null, new cell = animal, replace a null cell with animal
         * If bear moves to fish - original cell = null, new cell = bear, remove fish
         * If animal moves to null - original cell = null, new cell = animal
         */
        if (cell != 0) { // if index is not zero
            // bear or fish moves to null
            if (animals[cell - 1] == null) {
                animals[cell - 1] = animals[cell];
                animals[cell] = null;
            // animals are the same
            } else if (animals[cell - 1].getSpecies() ==  animals[cell].getSpecies()) {  // animals are the same
                this.createNew(animals[cell]);
            // fish moves to bear or bear moves to fish
            } else if ((animals[cell - 1].getSpecies() == "fish" & animals[cell].getSpecies() == "bear") |
                    (animals[cell - 1].getSpecies() == "bear" & animals[cell].getSpecies() == "fish")) {
                // bear and fish collide
                this.removeAnimal(cell - 1);
                this.addAnimal(cell - 1);
                animals[cell] = null;
            }
        }
    }

    public void moveRight(int cell) {
        /**
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
        if (cell != size - 1) { // if index is not the last cell
            // new cell is null
            if (animals[cell + 1] == null) {
                animals[cell + 1] = animals[cell];
                animals[cell + 1].flag = true; // animal has moved this round
                animals[cell] = null;
            // animals are the same
            } else if (animals[cell + 1].getSpecies() == animals[cell].getSpecies()) {
                this.createNew(animals[cell]);
            // bear moves to fish
            } else if (animals[cell + 1].getSpecies() == "fish" & animals[cell].getSpecies() == "bear") {
                this.removeAnimal(cell + 1);
                this.addAnimal(cell + 1);
                animals[cell+1].flag = true;  // the bear moved this round
                animals[cell] = null;
            // fish moves to bear
            } else if (animals[cell + 1].getSpecies() == "bear" & animals[cell].getSpecies() == "fish") {
                this.removeAnimal(cell + 1);
                this.addAnimal(cell + 1);
                animals[cell] = null;
            }
        }
    }

    public void createNew(Animal a) {
        /**
         *  Creates a new animal (bear or fish) and then moves them to a null cell.
         */
        for (int i = 0; i < size; i++) {
            if (animals[i] == null) { animals[i] = a; break; }
        }
    }

    public void addAnimal(int a) {
        /**
         * Adds a bear to a cell containing a fish if they collide.
         */
        animals[a] = new Animal("bear");
    }

    public void removeAnimal(int a) {
        /**
         * Removes a fish from the array after it encountered a bear.
         */
        animals[a] = null;
    }

    public String summary(int s) {
        int bears = 0;
        int fish = 0;
        int empty = 0;

        for (int i = 0; i < size; i++) {
            if (animals[i] == null) { empty++; }
            else if (animals[i].getSpecies() == "fish") { fish ++; }
            else if (animals[i].getSpecies() == "bear") { bears ++; }
        }

        String r = "-----------------------------\n";
        r += "| Step Number : ";
        r += s + "\t\t\t|\n";
        r += "-----------------------------\n";
        r += "| There are currently:\t\t|\n";
        r += "| " + fish + " fish\t\t\t\t\t|\n";
        r += "| " + bears + " bear(s)\t\t\t\t|\n";
        r += "| " + empty + " null cell(s)\t\t\t|\n";
        r += "-----------------------------\n";
        return r;
    }

    public String toString() {
        /**
         * Create a summary string displaying the number of bears, fish, and empty spots
         * in the river array.
         */
        String r = "River: \n";
        for (int i = 0; i < size; i++) {
            if (animals[i] == null) { r += (i) + ". null \n"; }
            else { r += (i) + ". " + animals[i].getSpecies() + "\n"; }
        }
        return r;
    }

    public boolean allBears() {
        /**
         * Search the river array
         * Return true if array contains all bears
         * otherwise return false.
         */
        int numBears = 0;
        for (int i = 0; i < size; i++) {
            if (animals[i] != null) {
                if (animals[i].getSpecies() == "bear") { numBears ++; }
            }
        }
        return numBears == size;
    }

    // MAIN ----------------------------------------------------
    public static void main(String[] args) {
        River portneuf = new River(500);
        Animal bear = new Animal("bear");
        Animal fish = new Animal("fish");

        // Initialize - populate river array
        portneuf.initialize(bear, fish);

        // Iteration - Run until the river is full of bears
        int n = 0;
        do {
            n++;
            portneuf.iterate(portneuf);
            System.out.println(portneuf.summary(n));
        } while (!portneuf.allBears());

        // Program completion output
        if (portneuf.allBears()) {
            System.out.println(" THE BEARS HAVE WON!!! ");
            System.out.println(" It took an excess of " + (n-1) + " rounds.");
            System.out.println(" ... it would have been faster if the bears were lions from Detroit ... ");}
    }
}
