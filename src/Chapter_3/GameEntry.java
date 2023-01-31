package Chapter_3;

public class GameEntry {
    // instance variables
    private String name;
    private int score;

    // constructor
    public GameEntry(String n, int s){
        name = n;
        score = s;
    }

    // methods
    public String getName() { return name; }
    public int getScore() { return score; }
    public String toString() {
        return "(" + name + ", " + score + ")";
    }
}

