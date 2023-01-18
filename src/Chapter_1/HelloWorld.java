package Chapter_1;

public class HelloWorld {
    public static void main (String[] args){
        System.out.println("Hello World!");

        // single-line comment

        /*
         * This is a block comment
         */

        // Identifiers/names must start with a character, $, _
        //      can contain digits in the name
        //      cannot be any reserved word

        // Primitive / basic data types
        boolean flat = true; // note lowercase true/false
        char grade = 'A'; // single quotes
        int x = 7; // 32-bit int
        byte y = 1; // 8-bit int
        short z = 2; // 16-bit int
        long s = 3L; // 54-bit int (note L at the end)
        float pi = 3.1415F; // 32-bit floating point(note F at the end)
        double ee = 2.71828; // 64-bit floating point

        System.out.println((int)ee);  // casting as an int truncates the double

        String greeting = "Hello"; // use double quotes
        greeting = "Hola";
        greeting = greeting + String.valueOf(x);
        System.out.println(greeting);

        // Classes and objects
        Counter c; // declares a variable -- no object constructed.
        c = new Counter(); // constructs a Counter, assigns its reference to c

        //System.out.println("Value of c.count: " + c.count); // won't work as count is private
        System.out.println("Value of c.count: " + c.getCount());

        Counter c2 = new Counter(10);
        System.out.println("Value of c2.count: " + c2.getCount());

        c.increment();
        c.increment(5.2);
        System.out.println("Value of c.count: " + c.getCount());

        c2.increment(5.2);
        System.out.println("Value of c2.count: " + c2.getCount());

        c.increment(c2);
        System.out.println("Value of c.count: " + c.getCount());

    }
}
