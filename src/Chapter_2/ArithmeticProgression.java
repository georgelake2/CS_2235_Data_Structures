package Chapter_2;

public class ArithmeticProgression extends Progression {
    // Instance Variables -----------------------------------
    protected long increment; // delta-x


    // Constructors -----------------------------------------
    public ArithmeticProgression(long stepsize, long start) { // default
        super(start);  // calls the superclass constructor (Progression)
        increment = stepsize;
    }

    public ArithmeticProgression() {  // choose either stepsize or start
        this(1,0);
    }

    public ArithmeticProgression(long stepsize) {
        this(stepsize, 0);
    }

    // Methods ----------------------------------------------

}
