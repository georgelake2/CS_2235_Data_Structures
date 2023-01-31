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
        return ("[" + first + ", " + second + "]");
    }



    public static void main(String[] args) {
        Pair<String,Double> bid;  // A=String, B=Double
        bid = new Pair<String,Double>("ORCL", 32.07); // example giving types explicitly
        System.out.println(bid); // or bid.toString

        Pair<Double,Double> point = new Pair<>(1.5, 2.25); // A=Double, B=Double; example
        System.out.println((point));
    }

}
