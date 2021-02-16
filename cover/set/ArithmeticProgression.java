package cover.set;

public class ArithmeticProgression implements Set {
    private final int firstElement;
    private final int difference;

    public ArithmeticProgression(int firstElement, int difference) {
        this.firstElement = firstElement;
        this.difference = difference;
    }

    @Override
    public boolean contains(int x) {
        return x >= firstElement && (x - firstElement) % difference == 0;
    }
}
