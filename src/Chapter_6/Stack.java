package Chapter_6;

public interface Stack<E> {
    // access methods
    E top(); // Peek at, return, top element
    int size(); // returns # of elements
    boolean isEmpty(); // returns true if stack is empty

    // update methods
    void push(E e); // add element to stack
    E pop (); // remove element from stack
}
