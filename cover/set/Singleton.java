package cover.set;

public class Singleton implements Set {
    private final int element;

    public Singleton(int element) {
        this.element = element;
    }

    @Override
    public boolean contains(int x) {
        return element == x;
    }
}
