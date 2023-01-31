package Homework_2;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Start {
    public static void main (String[] args) {

        /*
         * Create and populate a 500 element array with a random
         * assortment of fish (1), bears (2), and empty (0).
         */
        Random rand = new Random();
        String[] river = new String[500];
        for (int i=0; i<500; i++) {
           int rand_num = rand.nextInt(3);
           if (rand_num == 0) { river[i] = "empty"; }
           else if (rand_num == 1) { river[i] = "fish"; }
           else { river[i] = "bear"; }
        }

        /*
         * Counts number of bears and fish
         */
        int num_bears = 0;
        int num_fish = 0;
        int num_null = 0;
        for (int i=0; i<500; i++) {
            if (river[i] == "bear") { num_bears++; }  // the method of == below seems extra
            else if (Objects.equals(river[i], "fish")) { num_fish++; }
            else { num_null++; }
        }

        /*
         * OUTPUT
         */
        System.out.println("There are " + num_bears + " bears.");
        System.out.println("There are " + num_fish + " fish.");
        System.out.println("There are " + num_null + " null spaces.");
    }


}
