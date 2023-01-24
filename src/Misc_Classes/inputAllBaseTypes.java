/**
 * Reinforcement Exercise - R-1.1
 * Write a short Java method, inputAllBaseTypes, that inputs a different value
 * of each base type form the standard input device and prints it back to the
 * standard output device
 *
 * Different method - used classes
 */

package Misc_Classes;

import java.util.Scanner;

public class inputAllBaseTypes {
    // Instance variables ---------------------------------------------
    private boolean a;
    private String b;
    private byte c;
    private short d;
    private int e;
    private long f;
    private float g;
    private double h;

    // Constructors --------------------------------------------------
    // Initialize
    public inputAllBaseTypes () {
        Scanner temp = new Scanner(System.in);
        System.out.print("Enter a boolean: "); a = temp.nextBoolean();
        System.out.print("Enter a character: "); b = temp.next();
        System.out.print("Enter a byte: "); c = temp.nextByte();
        System.out.print("Enter a short: "); d = temp.nextShort();
        System.out.print("Enter an int: "); e = temp.nextInt();
        System.out.print("Enter a long: "); f = temp.nextLong();
        System.out.print("Enter a float: "); g = temp.nextFloat();
        System.out.print("Enter a double: "); h = temp.nextDouble();
    }

    // Accessor methods ----------------------------------------------
    public boolean getBoolean() { return a; }
    public String getString() { return b; }
    public byte getByte() { return c; }
    public short getShort() { return d; }
    public int getInt() { return e; }
    public long getLong() { return f; }
    public float getFloat() { return g; }
    public double getDouble() { return h; }


    public static void main (String[] args){

        inputAllBaseTypes first_bases = new inputAllBaseTypes();

        System.out.println("For boolean, you entered: "+ first_bases.getBoolean());
        System.out.println("For char, you entered: "+ first_bases.getString());
        System.out.println("For byte, you entered: "+ first_bases.getByte());
        System.out.println("For short, you entered: "+ first_bases.getShort());
        System.out.println("For int, you entered: "+ first_bases.getInt());
        System.out.println("For long, you entered: "+ first_bases.getLong());
        System.out.println("For float, you entered: "+ first_bases.getFloat());
        System.out.println("For double, you entered: "+ first_bases.getDouble());
    }




}
