package Homework_3;

import java.util.Random;

public class RiverList<E> {

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

    // Constructors ----
    public RiverList(int n) {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
        setSize = n;
    }

    // Accessor Methods ------
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
    // Update Methods ------
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
    public void initialize(E b, E f) {
        /**
         * Create a linked list of a pre-determined size.
         * The nodes of the list shall contain a random assortment of fish, bears, and null nodes.
         */
        Random rand = new Random();

        for (int i = 0; i < setSize; i++) {
            int rand_num = rand.nextInt(3);
            if (rand_num == 1) { this.addFirst(b); }
            else if (rand_num == 2) { this.addFirst(f); }
            else { this.addFirst(null); }
        }
    }
    public void iterate() {
        /**
         * Iterate through the list.
         * Look at each node.  If the node is null, then do nothing.
         * If the node contains a bear or fish, randomly select whether to move right or left.
         */
        Node walk = header.getNext();
        Random rand = new Random();

        while (walk != trailer) {
            if (walk.getElement() != null) {
                int rand_num = rand.nextInt(3);
                if (rand_num == 1) { this.moveLeft(walk); }
                else if (rand_num == 2) { this.moveRight(walk); }
            }
            walk = walk.getNext();
        }
    }
    public boolean allBears() {
        /**
         * NOT DONE
         */
        return false;
    }
    // Private Update Methods -----------------------
    private void moveLeft(Node<E> w){
        /**
         * Attempt to move an animal left.
         * The first Node does not move.
         * If animals are the same - original node = null, new node = animal, another null node = animal
         * If bear moves to fish - original node = null, new node = bear, fish removed.
         * If fish moves to bear - original node = null, new node = bear, fish removed.
         * If animal moves to null - original node = null, new node = animal.
         */
        System.out.println("moveLeft " + w.getElement());
        if (w != header); {
            // bear or fish moves to null
            if (w.getPrev().getElement() == null) {
                w.getPrev().setElement(w.getElement());
                w.setElement(null);
            // animals are the same
            } else if (w.getPrev().getElement() == w.getElement()) {
                this.replaceNull(w);

            }
        }
    }
    private void moveRight(Node<E> w) {
        /**
         * NOT DONE
         */
        System.out.println("moveRight " + w.getElement() );

    }
    private void replaceNull(Node<E> w){
        /**
         * NOT DONE
         */

    }
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        /**
         * Creates a new animal at a defined location in the list.
         * Replaces XXXX from HW2 River Array
         */
        Node<E> newNode = new Node<>(e, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
    }
    private E remove(Node<E> node) {
        /**
         * NOT DONE
         */
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    // String Builder --------------------------
    public String toString() {
        /**
         * NOT DONE
         */
        StringBuilder sb = new StringBuilder();
        Node<E> walk = header.getNext();
        sb.append("( ");
        while (walk != trailer) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != trailer)
                sb.append(", ");
        }
        sb.append(" )");
        return sb.toString();
    }

    // MAIN --------------------------------------------------
    public static void main(String[] args) {

        RiverList<String> snakeRiver = new RiverList<>(10);
        snakeRiver.initialize("Bear", "Fish");
        System.out.println(snakeRiver);

        snakeRiver.iterate();

        System.out.println(snakeRiver);




    }
}
