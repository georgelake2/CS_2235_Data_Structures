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

    /**
     * INITIALIZE
     * Randomly fill the doublylinkedlist with bears, fish and null nodes.
     * @param b = Animal3 bear
     * @param f = Animal3 fish
     */
    public void initialize(Animal3 b, Animal3 f) {

        Random rand = new Random();
        int numBears = 0;  // counts number of bears

        for (int i = 0; i < size; i++) {
            int rand_num = rand.nextInt(3);  // create a random number 0-2
            if (rand_num == 1) { animals.addFirst(b); }  // populate with a bear
            else if (rand_num == 2) { animals.addFirst(f); }  // populate with a fish
            else { animals.addFirst(null); }  // populate with null
        } }

    /**
     * ITERATE
     * Move through the doubly linked list.
     * Each iteration will determine if each bear or fish node moves and which direction they move, left or right.
     * Null nodes do not move.
     *
     */
    public void iterate() {
        Random rand = new Random();


        // reset movement flags

        // create node that will be used to walk through the list
        // start at the first node after the header.
        DoublyLinkedList3.Node<Animal3> walk = animals.header.getNext();

        // randomly attempt to move right, left, or stay on each cell in the array.
        for (int i = 0; i < animals.size(); i++) {
            if (walk != null) {  // only move if the cell contains animal
                int rand_num = rand.nextInt(2);
                if ((rand_num == 0) & (walk.getPrev() != animals.header)) { this.moveLeft(walk); } // move left if not first
                else if ((rand_num == 1) & (walk.getNext() != animals.trailer)) { this.moveRight(walk); } // move right if not last
            }
            walk = walk.getNext();
        } }


    /**
     * MOVE LEFT
     * Move the animal left one space.
     * First cell does not move.
     * If the animals are the same - original cell = null, new cell = animal, replace an existing null with animal
     * If bear moves to fish - original cell = null, new cell = bear, remove fish
     * If fish moves to bear - original cell = null
     * If animal moves to null - original cell = null, new cell = animal
     */
    public void moveLeft(DoublyLinkedList3.Node<Animal3> w) {
        // bear or fish moves to null
        if (w.getPrev().getElement() == null) {
            w.getPrev().setElement(w.getElement());
        }
        // animals are the same
        else if (w.getPrev().getElement() == w.getElement()) {
            this.createNew(w.getElement());
            w.setElement(null);
        }
        // bear moves to fish
        else if ((w.getElement().getSpecies() == "bear") & (w.getPrev().getElement().getSpecies() == "fish")) {
            w.getPrev().setElement(w.getElement());
            w.setElement(null);
        }
        // fish moves to bear
        else if ((w.getElement().getSpecies() == "fish") & (w.getPrev().getElement().getSpecies() == "bear")) {
            w.setElement(null);
        } }

    /**
     * MOVE RIGHT
     *
     */
    public void moveRight(DoublyLinkedList3.Node<Animal3> w) {
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
        // bear or fish moves to null
        if (w.getNext().getElement() == null) {
            w.getNext().setElement(w.getElement());
        }
        // animals are the same
        else if (w.getNext().getElement() == w.getElement()) {
            this.createNew(w.getElement());
            w.setElement(null);
        }
        // bear moves to fish
        else if ((w.getElement().getSpecies() == "bear") & (w.getNext().getElement().getSpecies() == "fish")) {
            w.getNext().setElement(w.getElement());
            w.setElement(null);
        }
        // fish moves to bear
        else if ((w.getElement().getSpecies() == "fish") & (w.getNext().getElement().getSpecies() == "bear")) {
            w.setElement(null);
        } }

    /**
     * CREATE NEW
     * Search through the list and replace the first null cell with the provided animal.
     * @param a = Animal that will replace a null cell.
     */
    public void createNew(Animal3 a) {
        DoublyLinkedList3.Node<Animal3> walk = animals.header.getNext();
        for (int i = 0; i < animals.size(); i++) {
            if (walk.getElement() == null) {
                walk.setElement(a);
                break;
            }
            walk = walk.getNext();
        } }

    /**
     *
     * @param a
     */
    public void addAnimal(int a) {

    }

    /**
     *
     * @param a
     */
    public void removeAnimal(int a) {

    }

    /**
     *
     * @param s
     * @return
     */
    public String summary(int s) {
        int bears = 0;
        int fish = 0;
        int empty = 0;
        DoublyLinkedList3.Node<Animal3> walk = animals.header.getNext();
        for (int i = 0; i < animals.size(); i++) {
            if (walk.getElement().getSpecies() == "bears") { bears ++; }
            else if (walk.getElement().getSpecies() == "fish") { fish ++; }
            else { empty ++; }
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

    /**
     *
     * @return
     */
    public String toString() {

        String sb = "";
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

    /**
     *
     * @return
     */
    public boolean allBears() {
        /*
         * Search the river array
         * Return true if array contains all bears
         * otherwise return false.
         */
        DoublyLinkedList3.Node<Animal3> walk = animals.header.getNext();
        int numBears = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (walk.getElement().getSpecies() == "bear") { numBears++; }
            walk = walk.getNext();
        }
        return numBears == animals.size();
    }

    // MAIN ----------------------------------------------------
    public static void main(String[] args) {
        River3 snakeRiver = new River3(10);
        Animal3 bear = new Animal3("bear");
        Animal3 fish = new Animal3("fish");

        // Initialize - populate river array
        snakeRiver.initialize(bear, fish);
        System.out.println(snakeRiver);

        // Iteration - Run until the river is full of bears
        int n = 0;
        do {
            n++;
            snakeRiver.iterate();
            System.out.println(snakeRiver.summary(n));
        } while (!snakeRiver.allBears());

        // Program completion output



    }
}
