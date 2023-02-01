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
    public void add(GameEntry entry) {
        int newScore = entry.getScore();

        if (numEntries < board.length || newScore > board[numEntries-1].getScore()) {
            if (numEntries < board.length)
                numEntries++;
            int j = numEntries-1;
            while (j > 0 && board[j-1].getScore() < newScore) {
                board[j] = board[j-1];
                j--;
            }
            board[j] = entry;
        }
    }



    public static void main(String[] args) {


    }
}
