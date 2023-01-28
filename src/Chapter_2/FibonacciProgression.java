package Chapter_2;

public class FibonacciProgression extends Progression {
    // Instance Variables
    protected long previous;
    protected long temp;

    // Constructors
    public FibonacciProgression(long first, long second) {
        super(second);
        previous = first;
    }

    public FibonacciProgression () { this (0,1); }

    // Methods
    // Override advance ()
    protected void advance() {
        // either method will work
        // method 1
        //current = current + previous;
        //previous = current - previous;

        // method 2
        temp = current;
        current = current + previous;
        previous = temp;

    }

}
