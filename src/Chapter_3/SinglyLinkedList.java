package Chapter_3;

public class SinglyLinkedList<E> {
    // Nested Node class
    private static class Node<E> {
        // State
        private E element; // element stored at this node/cell
        private Node<E> next; // reference to next node/cell

        // Constructor
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        // Access Methods
        public E getElement() { return element; }
        public Node<E> getNext() { return next; }

        // Update Methods
        public void setNext(Node<E> n) { next = n; }

        // END of nested node
    }


    // State for SinglyLinkedList
    private Node<E> head = null; // head node of list (or null if empty)
    private Node<E> tail = null; // tail node of list (or null if empty)
    private int size = 0;

    // Constructor for SinglyLinkedList
    public SinglyLinkedList() {} // construct an initially empty list

    // Methods for SinglyLinkedList
}
