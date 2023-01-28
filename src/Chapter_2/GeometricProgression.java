package Chapter_2;

public class GeometricProgression extends Progression {
    // Instance Variables ---------------------------------
    protected long multiplier;

    // Constructors ---------------------------------------
    public GeometricProgression (long m, long start) { // DEFAULT
        super(start);
        multiplier = m;
    }

    public GeometricProgression() { this(2,1); }

    public GeometricProgression(long m) { this(m, 1); }

    // Methods --------------------------------------------
    protected void advance() {
        current *= multiplier;
    }
}
