package Chapter_2;

/** Generates a simple progressions. By default: 0, 1, 2, ... */

public class Progression {
    /*
     * Instance Variables -----------------------------------
     */

    protected long current;

    /*
     * Constructors ----------------------------------------
     */

    //Constructs a progression with a given start value
    public Progression(long start) { current = start; }  // default

    // Constructs a progression starting at zero.
    public Progression() { this(0); }

    /*
     * Methods -----------------------------------------
     */

    // Returns the next value of the progression
    public long nextValue() {
        advance();
        return current;
    }

    // Advances the current value to the next value of the progression
    protected void advance() {
        current ++;
    }

    // Prints the next n values of the progression, separated by spaces
    public void printProgression(int n) {
        System.out.println("Current Value " + current);
        System.out.println("Next " + n + " values: ");
        for (int i=0; i<n; i++) {
            System.out.print(nextValue() + " ");
        }
        System.out.println();
        System.out.println();

    }


}
