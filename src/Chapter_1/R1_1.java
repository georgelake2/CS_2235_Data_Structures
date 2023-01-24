/**
 * Reinforcement Exercise - R-1.1
 * Write a short Java method, inputAllBaseTypes, that inputs a different value
 * of each base type form the standard input device and prints it back to the
 * standard output device
 *
 */

package Chapter_1;
import java.util.Scanner;


public class R1_1 {

    public static void main(String[] args) {

        // get an input for each of the base types
        // then display all inputs entered
        R1_1.inputAllBaseTypes();



    }

    public static void inputAllBaseTypes() {

        // get input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a true/false boolean value: ");
        boolean a = input.nextBoolean();
//        System.out.print("Enter a single digit character: ");
//        char b = (char)input.read();
        System.out.print("Enter a number -256 < x < 255: ");
        byte c = input.nextByte();
        System.out.print("Enter a number -32,768 < x < 32,767: ");
        short d = input.nextShort();
        System.out.print("Enter a number -2,147,483,648 < x < 2,147,483,647: ");
        int e = input.nextInt();
        System.out.print("Enter a signed 64 bit number: ");
        long f = input.nextLong();
        System.out.print("Enter a 32-bit floating point number: ");
        float g = input.nextFloat();
        System.out.print("Enter a 64-bit floating point number: ");
        double h = input.nextDouble();

        // display output
        System.out.println("For boolean, you entered: " + a);
        System.out.println("For byte, you entered: " + c);
        System.out.println("For short, you entered: " + d);
        System.out.println("For int, you entered: " + e);
        System.out.println("For long, you entered: " + f);
        System.out.println("For float, you entered: " + g);
        System.out.println("For double, you entered: " + h);


    }


}
