package TEST;

public class SingListT<E> {
    // NESTED NODE CLASS
    public static class Node<E> {
        //State
        private E element;
        private Node<E> next;

        //Constructor
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        //Access Methods
        public E getElement() { return element; }
        public Node<E> getNext() { return next; }

        //Update Methods
        public void setNext(Node<E> n) { next = n; }

        // END OF NESTED NODE
    }

    // STATE
    protected Node<E> head = null;
    protected Node<E> tail = null;
    private int size = 0;

    // CONSTRUCTOR
    public SingListT() {};

    // ACCESS METHODS
    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }
    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) { tail = head; }
        size ++;
    }

    public void addLast (E e) {
        Node<E> newest = new Node<>(e, null);
        if(isEmpty()) { head = newest; }
        else { tail.setNext(newest); }

        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) { tail = null; }

        return answer;
    }

    public String toString() {
        String out = "Singly Linked List : \n";

        return out;
    }



}
