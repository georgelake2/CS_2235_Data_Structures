package Chapter_5;

public class Factorial {
    public static long factorialLoop(long n) {
        if (n < 1) return 1;
        long result = 1;
        for (long i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    public static long factorialRecursion(long n) {
        if (n < 1) return 1;
        return n * (factorialRecursion(n-1));
    }


    public static void main(String[] args) {
    System.out.println(factorialLoop(5));
    System.out.println(factorialRecursion(5));

    long number = 10;
    int trials = 100000000;

    // For Loop Time
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < trials; i ++) {
        factorialLoop(number);
    }
    long stopTime = System.currentTimeMillis();
    System.out.println("For loop time for " + number + ": " + (stopTime - startTime));

    // Recursion Time
    startTime = System.currentTimeMillis();
    for (int i = 0; i < trials; i++) {
        factorialRecursion(number);
    }
    stopTime = System.currentTimeMillis();
    System.out.println("Recursion time for " + number + ": " + (stopTime - startTime));
    }
}
