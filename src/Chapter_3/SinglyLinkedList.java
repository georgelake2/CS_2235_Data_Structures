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
    private int size = 0;  // number of nodes in the list

    // Constructor for SinglyLinkedList
    public SinglyLinkedList() {} // construct an initially empty list

    // Methods for SinglyLinkedList
    // access methods
    public int getSize() { return size; }
    public boolean isEmpty () { return size==0; }
    public E first() { // return element of first node (head)
        if (isEmpty()) return null;
        return head.getElement();
    }
    public E last() { // return element of last node (tail)
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // update methods
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size==0) { tail = head; }

        size ++;
    }
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null); // new tail points to null
        if (isEmpty()) {
            head = newest;  // special case of just one node
        } else {
            tail.setNext(newest);
        }
        tail = newest; // new node becomes tail
        size++;
    }
    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size==0) { // if there had been one node before removeFirst() call
            tail = null;
        }
        return answer;
    }

    public String toString() {
        String out = "Singly Linked List: \n";
        if (isEmpty()) return out;
        out += "0 " + head.getElement() + "\n";
        Node<E> nextnode = head.getNext();
        for (int i=1; i<this.size; i++) {
            out += Integer.toString(i) + " " + nextnode.getElement() + "\n";
            nextnode = nextnode.getNext();
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println("I compiled");
        SinglyLinkedList<String> names = new SinglyLinkedList<>();

        names.addLast("Leslie");
        names.addLast("Collin");
        names.addLast("Russell");
        names.addFirst("Seth");
        names.addFirst("Karen");
        names.addFirst("Cesar");
        System.out.println(names.size);
        System.out.println(names);

        names.removeFirst();
        System.out.println(names);
    }


}
