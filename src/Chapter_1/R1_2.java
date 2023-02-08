/**
 * Create an array A[5] of GameEntry (replaced with R1_2) objects, which has an integer scores field.
 * Clone A and store result in array B
 * Set A[4].score to 550, what is B[4]?
 *
 */
package Chapter_1;

public class R1_2 {
    // instance variables
    private GameEntry[] entry;
    private int size;

    // Constructors
    public R1_2(int n) { // Construct an array called entry n cells long and populated with game entries
        entry = new GameEntry[n];
        size = n;
    }


    // Methods

    // MAIN
    public static void main(String[] args) {

    }


}
