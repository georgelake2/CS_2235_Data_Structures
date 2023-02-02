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
    public void add(GameEntry entry) {  // adds a new entry and puts it in the correct spot
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

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= numEntries)
            throw new IndexOutOfBoundsException("Invalid index: "+ i);
        GameEntry temp = board[i];
        for (int j = i; j < numEntries -1; j++)
            board[j] = board[j+1];
        board[numEntries-1] = null;
        numEntries--;
        return temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int j = 0; j < numEntries; j++) {
            if (j > 0)
                sb.append(", ");
            sb.append(board[j]);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Scoreboard highscores = new Scoreboard(10);

        GameEntry frank = new GameEntry("Frank", 222);
        System.out.println("Adding "+ frank);
        highscores.add(frank);
        GameEntry ted = new GameEntry("Ted", 111);
        highscores.add(ted);
        GameEntry sarah = new GameEntry("Sarah", 555);
        highscores.add(sarah);


        System.out.println(" Scoreboard: " + highscores);

    }
}
