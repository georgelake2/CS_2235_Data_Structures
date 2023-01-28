package Chapter_2;

/** Generates a simple progressions. By default: 0, 1, 2, ... */

public class Progression {
    /*
     * Instance Variables
     */

    protected long current;

    public Progression(long start) { current = start; }  // default


    public Progression() { this(0); }


    public long nextValue() {
        advance();
        return current;
    }

    protected void advance() {
        current ++;
    }

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
