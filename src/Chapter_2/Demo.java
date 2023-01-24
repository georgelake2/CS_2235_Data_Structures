package Chapter_2;

public class Demo {

    public static void main(String[] args) {
        Progression sequence;

        // Simple progression
        System.out.println("---Simple/default progression--- \n");
        //sequence = new Progression();
        //sequence.printProgression(10);


        // Arithmetic Progression
        System.out.println(("---Arithmetic progression---"));
        sequence = new ArithmeticProgression();
        sequence.printProgression(10);
    }
}
