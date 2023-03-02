package TEST;

import java.security.PublicKey;
import java.util.Random;

public class Array2D {
    // State ---------------------------------------------------
    int numColumns;
    int numRows;
    private int[][] array;



    // Constructors -------------------------------------------
    public Array2D(int r, int c) {
        numColumns = c;
        numRows = r;
        array = new int [r][c];
    }

    // Methods --------------------------------------------
    public int getRows() { return numRows; }
    public int geColumns() { return numColumns; }

    /**
     *  INITIALIZE
     */
    private void initialize () {
        Random rand = new Random();

        // fill rows
        for (int r=0; r<numRows; r++) {
            // fill columns
            for (int c=0; c<numColumns; c++) {
                int number = rand.nextInt(100,1000);
                array[r][c] = number;

            } } }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n Array Contents: \n");
        // rows
        for (int r = 0; r < numRows; r++) {
            // fill columns
            for (int c = 0; c < numColumns; c++) {
                sb.append("[" + array[r][c] + "]\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }




    // MAIN ------------------------------
    public static void main(String[] args) {
        // Experimental Computation Time - Initialize
        int trials = 10;
        long startTime;
        long endTime;
        long avgTime;

        // Experimental Computation Time - START
        startTime = System.currentTimeMillis();

        // Create new array
        Array2D firstArray = new Array2D(100,100);
        int numCells = firstArray.geColumns() * firstArray.getRows();

        // Initialize Array
        firstArray.initialize();

        // Print Size of Array
        System.out.println("There are " + firstArray.getRows() + " rows in the array");
        System.out.println("There are " + firstArray.geColumns() + " columns in the array");
        System.out.println("There are a total of " + numCells + " cells.");

        // Print Contents of Array
        System.out.println(firstArray);

        // Experimental Computational Time - END
        endTime = System.currentTimeMillis();

        // Experimental Computational Time - Calculations
        avgTime = (endTime - startTime) / trials;
        System.out.println("Experimental Computational Time (2D Array) n = " + numCells + ", average time = " + avgTime + " ms");






    }




}
