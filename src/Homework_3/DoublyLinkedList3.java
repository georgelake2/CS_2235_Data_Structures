/**
 *  George Lake
 *  Homework 3
 *  CS 2235, Dr. Leslie Kerby
 *
 *  This class contains the doubly linked list that will be used by the River3 class.
 */
package Homework_3;

public class DoublyLinkedList3<E> {
    //---------------- nested Node class ----------------
    public static class Node<E> {
        // State -------------------------------
        private E element;               // reference to the element stored at this node
        private Node<E> prev;            // reference to the previous node in the list
        private Node<E> next;            // reference to the subsequent node in the list

        // Constructors ----------------------------
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        // Methods - Accessor --------------------------
        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }

        // Methods - Update --------------------------
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
        public void setElement(E e) { element = e; }
    } //----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList ---------------
    protected Node<E> header;                    // header sentinel
    protected Node<E> trailer;                   // trailer sentinel
    private int size = 0;                      // number of elements in the list

    // Constructors -----------------------------------------
    public DoublyLinkedList3() {
        header = new Node<>(null, null, null);  // create header
        trailer = new Node<>(null, header, null);  // trailer is preceded by header
        header.setNext(trailer);                         // header is followed by trailer
    }

    // Methods - Accessor -------------------------------
    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();   // first element is beyond header
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();    // last element is before trailer
    }

    // Methods - Update -----------------------------
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());    // place just after the header
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);  // place just before the trailer
    }

    public E removeFirst() {
        if (isEmpty()) return null;                  // nothing to remove
        return remove(header.getNext());             // first element is beyond header
    }

    public E removeLast() {
        if (isEmpty()) return null;                  // nothing to remove
        return remove(trailer.getPrev());            // last element is before trailer
    }

    // private update methods
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        // CODE REMOVED, STRING WILL BE CREATED IN THE RIVER3 CLASS

//        Node<E> walk = header.getNext();
//        int num = 0;
//        while (walk != trailer) {
//            num ++;
//            sb.append(num + ": ");
//            sb.append(walk.getElement());
//            walk = walk.getNext();
//            if (walk != trailer)
//                sb.append("\n");
//        }
//        sb.append("\n");
//
        return null;
    }


}
