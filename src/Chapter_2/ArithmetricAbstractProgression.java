package Chapter_2;

public class ArithmetricAbstractProgression extends AbstractProgression {
    // Instance Variables -----------------------------------
    protected long increment; // delta-x


    // Constructors -----------------------------------------
    public ArithmetricAbstractProgression(long stepsize, long start) { // default
        super(start);  // calls the superclass constructor (Progression)
        increment = stepsize;
    }

    public ArithmetricAbstractProgression() {  // choose either stepsize or start
        this(1,0);
    }

    public ArithmetricAbstractProgression(long stepsize) {
        this(stepsize, 0);
    }

    // Methods ----------------------------------------------
    // Override super method advance()
    protected void advance() {
        current += increment;
    }
}
