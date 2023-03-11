package Chapter_6;

import Chapter_3.SinglyLinkedList;

public class ArrayStack {
    // instance variables
    private E[] data;
    private static int CAPACITY = 1000;
    private int t = -1;

    // constructors
    public E() {}

    // methods
    // access methods
    // Peek at, return, top element
    public E top() { return list.first(); }

    // returns # of elements
    public int size() { return list.getSize(); }

    // returns true if stack is empty
    public boolean isEmpty() { return list.isEmpty(); }

    // update methods
    // add element to stack
    public void push(E e) { list.addFirst(e); }

    // remove element from stack
    public E pop () { return list.removeFirst(); };


    // MAIN
    public static void main(String[] args) {
        LinkedStack<Integer> S = new LinkedStack<>();
        S.push(5);
        S.push(9);
        System.out.println("Size: " + S.size());
        System.out.println("Peek: " + S.top());
        System.out.println("Pop: " + S.pop());
        System.out.println("Empty? " + S.isEmpty());

        System.out.println("Peek: " + S.top());
        System.out.println("Pop: " + S.pop());
        System.out.println("Empty? " + S.isEmpty());

        System.out.println("Peek: " + S.top());
        System.out.println("Pop: " + S.pop());
        System.out.println("Empty? " + S.isEmpty());

    }

}
