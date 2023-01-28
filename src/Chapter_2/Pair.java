package Chapter_2;

public class Pair <A, B> {
    // Instance Variables
    A first;
    B second;

    // Constructors
    public Pair (A a, B b) {
        first = a;
        second = b;
    }

    // Methods
    public A getFirst() { return first; }
    public B getSecond() { return second; }
    public String toString() { // overrides toString() method
        return ("");
    }

    public static void main(String[] args) {

    }

}
