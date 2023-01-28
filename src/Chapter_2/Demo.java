package Chapter_2;

public class Demo {

    public static void main(String[] args) {
        Progression sequence;
        ArithmeticProgression sequence1;
        GeometricProgression sequence2;
        FibonacciProgression sequence3;
        ArithmetricAbstractProgression sequence4;

        // Simple progression
        System.out.println("---Simple/default progression---");
        sequence = new Progression();
        sequence.printProgression(10);


        // Arithmetic Progression
        System.out.println(("---Arithmetic progression---"));
        sequence1 = new ArithmeticProgression(10);
        sequence1.printProgression(10);


        // Geometric Progression
        System.out.println(("---Geometric progression---"));
        sequence2 = new GeometricProgression(2);
        sequence2.printProgression(10);


        // Fibonacci Progression
        System.out.println(("---Fibonacci progression---"));
        sequence3 = new FibonacciProgression();
        sequence3.printProgression(10);

        // Arithmetic Abstract Progression
        System.out.println(("---Arithmetic Abstract progression---"));
        sequence4 = new ArithmetricAbstractProgression(10);
        sequence4.printProgression(10);
    }
}
