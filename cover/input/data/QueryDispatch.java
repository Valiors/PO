package cover.input.data;

import cover.solver.SetCoverSolver;
import cover.strategy.Strategy;

public class QueryDispatch implements Dispatch {
    private final int[] setToCover;
    private final Strategy strategy;

    public QueryDispatch(int[] setToCover, Strategy strategy) {
        this.setToCover = setToCover;
        this.strategy = strategy;
    }

    public int[] getSetToCover() {
        return setToCover;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    @Override
    public void performOperation(SetCoverSolver s) {
        s.performOperation(this);
    }
}
