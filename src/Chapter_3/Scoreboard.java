package Chapter_3;

public class Scoreboard {
    // state (instance variables)
    private int numEntries;  // number of actual entries
    private GameEntry[] board;  // This is composition (generally better than inheritance)

    // constructors
    public Scoreboard(int capacity) {  // constructor that allows you to assign size
        board = new GameEntry[capacity];
    }

    public Scoreboard() {  // default constructor
        this(10);
    }

    // methods
    public boolean add(GameEntry e) { // Try to add a high score, returns True if sucessful
        int newScore = e.getScore();  // do this if using a variable multiple times
        // Check if the new score is a high score, and if so add it to the board
//        if ( numEntries < board.length ) {
//            numEntries++;
//            int j = numEntries - 1;
//            while ( board[j-1].getScore() < newScore ) {
//                board[j] = board[j-1];
//                j--;
//            }

        if (newScore > board[0].getScore()); {
            System.out.println("Goes on Board");
            return true;
        }


    }



    public static void main(String[] args) {
        // test GameEntry
        GameEntry ge = new GameEntry("George", 80);
        Scoreboard highscores = new Scoreboard (10);
        highscores.add(ge);
    }
}
