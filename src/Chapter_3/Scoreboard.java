package Chapter_3;

import java.util.Random;
import java.util.Arrays;

public class Scoreboard {
    // state
    private int numEntries; // number of actual entries
    private GameEntry[] board; // This is composition (generally better than inheritance)

    // constructor
    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }
    public Scoreboard() { // default constructor with capacity 10
        this(10);
    }

    // methods
    public boolean add(GameEntry e) { // Try to add a high score, returns True if score added
        int newScore = e.getScore(); // do this if using it multiple times
        // Check if the new score is a high score, and if so add it to board
        if ( numEntries < board.length ) { // covers possibilites of board being empty or partially full
            numEntries++;
        } else if ( newScore <= board[numEntries-1].getScore() ) { // board is full, check if score is less than/equal to last (lowest) score
            return false;
        }
        int j = numEntries - 1;
        while ( j > 0 && board[j-1].getScore() < newScore ) {
            board[j] = board[j-1];
            j--;
        }
        board[j] = e;
        return true;

        /* Shows that accessing null element of board crashes the program
        if (newScore > board[0].getScore()) {
            System.out.println("Goes on board.");
            return true;
        }
        return false;
         */
    }

    public String toString() {
        String sb = "Scoreboard: \n";
        for (int i = 0; i < numEntries; i++) {
            sb += (i+1) + ". " + board[i].getName() + "\t" + board[i].getScore() + "\n";
        }
        return sb;
    }



    public static void main(String[] args) {
        /* test GameEntry
        GameEntry ge = new GameEntry("Leslie", 85);
        Scoreboard highscores = new Scoreboard(10);
        highscores.add(ge);
        System.out.println(highscores);
        */

        Scoreboard highscores = new Scoreboard(10);
        String[] names = {"Leslie", "Gary", "Andrija", "Russell", "Rhett", "Alex",
            "Val", "Dominik", "Karen", "Porter"};
        Random rand = new Random();
        int[] scores = new int[10];
        rand.setSeed(System.currentTimeMillis());
        //System.out.println(rand.nextInt(3)); // randomly choose an int in range [0, bound-1]
        for (int i=0; i<10; i++) {
            scores[i] = rand.nextInt(101); // scores between 0 and 100
        }
        //System.out.println(Arrays.toString(scores));
        // Arrays.sort(scores);

        // Create GameEntry's and add to Scoreboard
        for (int i=0; i<10; i++) {
            GameEntry ge = new GameEntry(names[i], scores[i]);
            System.out.println(ge);
            highscores.add(ge);
        }
        System.out.println(highscores);
    }
}
