package Homework_3;

import java.util.Random;

public class River3_old<E> {

    // NESTED NODE CLASS ---------------------------------
    // This nested class takes the place of the Animal Class that was in HW2
    public static class Node<E> {
        // State -------
        private E element;
        private Node<E> prev;
        private Node<E> next;

        // Constructors ----
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        // Accessor Methods --------
        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        // Update Methods ----------
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
        public void setElement(E e) { element = e; }
    }
    // END OF NESTED NOTE CLASS --------------------------

    // DOUBLYLINKEDLIST ----------------------------------
    // State -----
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    private int setSize;

    // Constructors
    public River3_old(int n) {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
        setSize = n;
    }

    // ACCESSOR METHODS ---------------------------------------------------
    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }
    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }
    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }
    // PUBLIC UPDATE METHODS ----------------------------------------------
    public void addFirst(E e) { addBetween(e, header, header.getNext()); }

    public void addLast(E e) { addBetween(e, trailer.getPrev(), trailer); }

    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    /**
     * Create a linked list of a pre-determined size.
     * The nodes of the list shall contain a random assortment of fish, bears, and null nodes.
     */
    public void initialize(E b, E f) {
        Random rand = new Random();
        for (int i = 0; i < setSize; i++) {
            int rand_num = rand.nextInt(3);
            if (rand_num == 1) { this.addFirst(b); }
            else if (rand_num == 2) { this.addFirst(f); }
            else { this.addFirst(null); }
        } }

    /**
     * Iterate through the list.
     * Look at each node.  If the node is null, then do nothing.
     * If the node contains a bear or fish, randomly select whether to move right or left.
     */
    public void iterate() {
        Node<E> walk = header.getNext();
        Random rand = new Random();
        while (walk != trailer) {
            if (walk.getElement() != null) {
                int rand_num = rand.nextInt(3);
                if (rand_num == 1) { this.moveLeft(walk); }
                else if (rand_num == 2) { this.moveRight(walk); }
            }
            walk = walk.getNext();
        } }

    /**
     * Count the number of bears
     * return true if the list contains all bears.
     */
    public boolean allBears() {

        int numBears = 0;
        Node<E> walk = header.getNext();

        while (walk != trailer) {
            if (walk.getElement() == "bear") { numBears++; }
            walk = walk.getNext();
        }
        return (numBears == getSize());
    }

    // PRIVATE UPDATE METHODS --------------------------------------------------------
    /**
     * Attempt to move an animal left.
     * The first Node does not move.
     * If animals are the same - original node = null, new node = animal, another null node = animal
     * If bear moves to fish - original node = null, new node = bear, fish removed.
     * If fish moves to bear - original node = null, new node = bear, fish removed.
     * If animal moves to null - original node = null, new node = animal.
     */
    private void moveLeft(Node<E> w){
        // first node does not move
        if (w.getPrev() != header) {

            // animal moves to null
            if (w.getPrev().getElement() == null) {
                w.getPrev().setElement(w.getElement());
                w.setElement(null);

            // animals are the same
            } else if (w.getPrev().getElement() == w.getElement()) {
                this.replaceNull(w);

            // bear moves to fish
            } else if ((w.getElement() == "bear") & (w.getPrev().getElement() == "fish")) {
                w.getPrev().setElement(w.getElement());
                w.setElement(null);

            // fish moves to bear
            } else if ((w.getElement() == "fish") & (w.getPrev().getElement() == "bear")) {
                w.setElement(null);
            } } }

    /**
     * Attempt to move an animal right.
     * The last Node does not move.
     * If animals are the same - original node = null, new node = animal, another null node = animal
     * If bear moves to fish - original node = null, new node = bear, fish removed.
     * If fish moves to bear - original node = null, new node = bear, fish removed.
     * If animal moves to null - original node = null, new node = animal.
     */
    private void moveRight(Node<E> w) {
        // last node does not move
        if (w.getNext() != trailer) {

            // animal moves to null
            if (w.getNext().getElement() == null) {
                w.getNext().setElement(w.getElement());
                w.setElement(null);

                // animals are the same
            } else if (w.getNext().getElement() == w.getElement()) {
                this.replaceNull(w);

                // bear moves to fish
            } else if ((w.getElement() == "bear") & (w.getNext().getElement() == "fish")) {
                w.getNext().setElement(w.getElement());
                w.setElement(null);

                // fish moves to bear
            } else if ((w.getElement() == "fish") & (w.getNext().getElement() == "bear")) {
                w.setElement(null);
            } } }

    /**
     * Replace the first null node found with either a bear or fish,
     * determined from move left or move right
     * w - node that will move.
     */
    private void replaceNull(Node<E> w) {
        Node<E> walk = header.getNext();
        while (walk != trailer) {
            if (walk.getElement() == null) {
                walk.setElement(w.getElement());
                break;
            }
            walk = walk.getNext();
        } }

    /**
     * Creates a new animal at a defined location in the list.
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newNode = new Node<>(e, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
    }

    /**
     * Used by removeFirst and removeLast
     */
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    // String Builders ----------------------------------------------
    /**
     * Create a string that will display the elements contained in the list.
     */
    public String toString() {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        Node<E> walk = header.getNext();
        sb.append("Contents of RiverList: ");
        sb.append("( ");
        while (walk != trailer) {
            i++;
            sb.append(i);
            sb.append(".");
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != trailer)
                sb.append(", ");
        }
        sb.append(" )");
        return sb.toString();
    }

    /**
     * Create a string that will display the number of bears, fish and null nodes in the list.
     * int s - step number
     */
    public String summary(int s) {
        int numBears = 0;
        int numFish = 0;
        int numNull = 0;
        StringBuilder sb = new StringBuilder();
        Node<E> walk = header.getNext();

        // count number of each node.
        while (walk != trailer) {
            if (walk.getElement() == "bear") { numBears++; }
            else if (walk.getElement() == "fish") { numFish++; }
            else { numNull++; }
            walk = walk.getNext();
        }
        // create summary
        sb.append("-----------------------------\n");
        sb.append("| Step Number : ");
        sb.append(s);
        sb.append(" \t\t\t|\n");
        sb.append("-----------------------------\n");
        sb.append("| There are currently : \t|\n");
        sb.append("| ");
        sb.append(numFish);
        sb.append(" fish \t\t\t\t\t|\n");
        sb.append("| ");
        sb.append(numBears);
        sb.append(" bear(s) \t\t\t\t|\n");
        sb.append("| ");
        sb.append(numNull);
        sb.append(" null node(s)\t\t\t|\n");
        sb.append("-----------------------------\n");

        return sb.toString();
    }

    // MAIN --------------------------------------------------
    public static void main(String[] args) {

        System.out.println("\nWelcome to the river ecosystem simulator.");

        River3_old<String> snakeRiver = new River3_old<>(500);
        snakeRiver.initialize("bear", "fish");
        System.out.println(snakeRiver);

        int step = 0;
        while (!snakeRiver.allBears()) {
            step++;
            snakeRiver.iterate();
            System.out.println(snakeRiver.summary(step));
        }

        System.out.println("The bears have taken over the ecosystem.  It took them " + step + " rounds.");
        System.out.println("Good job bears, sleep well and wake up refreshed.");




    }
}
