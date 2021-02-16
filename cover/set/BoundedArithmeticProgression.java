package cover.set;

public class BoundedArithmeticProgression extends ArithmeticProgression {
    private final int bound;

    public BoundedArithmeticProgression(int firstElement, int difference, int bound) {
        super(firstElement, difference);
        this.bound = bound;
    }

    @Override
    public boolean contains(int x) {
        return x <= bound && super.contains(x);
    }
}
