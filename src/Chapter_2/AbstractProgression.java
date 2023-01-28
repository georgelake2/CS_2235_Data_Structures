package Chapter_2;

public abstract class AbstractProgression {
    // instance variables
    protected long current;

    // Constructors
    public AbstractProgression(long start) { current = start; }

    public AbstractProgression() { this(0); }

    // Methods
    public void printProgression(int n) { // Concrete Method
        System.out.println("Current Value " + current);
        System.out.println("Next " + n + " values: ");
        for (int i = 0; i < n; i++) {
            System.out.print(nextValue() + " ");
        }
        System.out.println();
    }

    public long nextValue() {
        advance();
        return current;
    }
    protected abstract void advance();  // note the semicolon -- abstract method

}
