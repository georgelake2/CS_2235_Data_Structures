package Chapter_6;

import Chapter_3.SinglyLinkedList;

public class ArrayStack<E> implements Stack<E> {
    // instance variables
    private E[] data;
    private static int CAPACITY = 1000;
    private int t = -1; // index to the top (last) element of the stack

    // constructors
    public ArrayStack() { this(CAPACITY); }
    public ArrayStack( int capacity) {
        data = (E[]) new Object[capacity];  // use this because of generics
    }

    // methods
    // access methods ---------------------------------------
    // Peek at, return, top element
    public E top() {
        if (isEmpty()) { return null; }

        return data[t];
    }

    // returns # of elements
    public int size () { return t + 1; }

    // returns true if stack is empty
    public boolean isEmpty() { return (t == -1); }

    // update methods ---------------------------------
    // add element to stack
    public void push(E e) {
        if (size()==data.length) throw new IllegalStateException("Stack is full.");  // could also resize data[] w/ dynamic sizing
        data[++t] = e;
    }

    // remove element from stack
    public E pop () {
        if (isEmpty()) return null;

        E answer = data[t];
        data[t--] = null;
        return answer;
    }


    // MAIN
    public static void main(String[] args) {
        ArrayStack<Integer> S = new ArrayStack<>();
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
