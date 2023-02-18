package Homework_3;

import java.util.Random;

public class RiverList<E> {
    // NESTED NODE CLASS ---------------------------------
    // This nested node takes the place of the Animal Class that was in HW2
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
        public void setElement(Node<E> e) {}
    }
    // END OF NESTED NOTE CLASS --------------------------

    // DOUBLYLINKEDLIST ----------------------------------
    // State -----
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    private int startSize = 0;

    // Constructors ----
    public RiverList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);

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
         * Fill a doublylinkedlist with bears, fish, or nothing (null)
         */
        Random rand = new Random();

        for(int i = 0; i < startSize; i++ ) {
            int rand_num = rand.nextInt(3);
        }
        this.addFirst(b);
        this.addFirst(f);
        this.addFirst(f);
        this.addFirst(b);

        }

    // Private Update Methods ------
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newNode = new Node<>(e, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setNext(newNode);
        size++;
    }
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    // String Builder
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> walk = header.getNext();
//        int num = 0;
//        while (walk != trailer) {
//            num ++;
//            sb.append(num + ": ");
//            sb.append(walk.getElement());
//            walk = walk.getNext();
//            if (walk != trailer) { sb.append("\n"); }
//        }
        sb.append("test");
        return sb.toString();
    }

    // MAIN --------------------------------------------------
    public static void main(String[] args) {

        RiverList<String> snakeRiver = new RiverList<>();
        //snakeRiver.initialize("Bear", "Fish");

        snakeRiver.addFirst("bear");
        snakeRiver.addFirst("fish");
        snakeRiver.addFirst("fish");
        snakeRiver.addFirst("bear");

        System.out.println(snakeRiver);




    }















}
