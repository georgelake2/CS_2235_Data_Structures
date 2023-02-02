package Homework_2;
import java.util.Arrays;
import java.util.Random;

public class RiverTest {
    // Instance Variables
    private int[] river; // array that stores the animals in the river
    private String compiledRiver;


    // Constructors
    public RiverTest(int capacity) { river = new int[capacity]; }


    // Methods
    public void populateRiver() {
        Random rand = new Random();
        for (int i = 0; i < river.length; i++) {
            int rand_num = rand.nextInt(3);
            river[i] = rand_num;
            System.out.println(river[i]);
        }

    }

    public String getRiver() {
        compiledRiver = Arrays.toString(river);
        return compiledRiver; }


    // MAIN
    public static void main(String[] args) {
        // Create new river array
        RiverTest river1 = new RiverTest(20);

        // Populate river array with bears, fish, and null
        river1.populateRiver();

        // Ouput river
        System.out.println(river1.getRiver());

    }

}

