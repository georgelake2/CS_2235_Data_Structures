package Chapter_1;

public class Counter {
    // State
    private int count;

    // Constructors
    public Counter() {}  // default constructor
    public Counter(int initial) { count = initial; } // overloading

    // Methods
    public int getCount() { return count; } // getter or accessor method
    public void increment() { count++; } // update or modifier method
    public void increment(double multiplier) { count *= (int)multiplier; }
    public void increment(int delta) { count += delta; }
    public void increment(Counter ct) {
        this.count += ct.getCount(); // will work with or without adding "this"
    }
    public void reset() { count = 0; }
}

