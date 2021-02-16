package cover.input.data;

import cover.set.Set;
import cover.solver.SetCoverSolver;

public class InsertDispatch implements Dispatch {
    private final Set set;

    public InsertDispatch(Set set) {
        this.set = set;
    }

    public Set getSet() {
        return set;
    }

    @Override
    public void performOperation(SetCoverSolver s) {
        s.performOperation(this);
    }
}
