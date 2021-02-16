package cover.solver;

import cover.input.data.InsertDispatch;
import cover.input.data.QueryDispatch;
import cover.set.Set;
import cover.strategy.Strategy;

import java.util.ArrayList;

public class SetCoverSolver {
    private final ArrayList<Set> cover;

    public SetCoverSolver() {
        cover = new ArrayList<>();
    }

    public void addSet(Set set) {
        cover.add(set);
    }

    public ArrayList<Integer> coverSet(int[] setToCover, Strategy strategy) {
        return strategy.coverSet(cover, setToCover);
    }

    // Implements visitor pattern

    public void performOperation(InsertDispatch data) {
        addSet(data.getSet());
    }

    public void performOperation(QueryDispatch data) {
        ArrayList<Integer> result = coverSet(data.getSetToCover(), data.getStrategy());

        if (result == null || result.size() == 0) {
            System.out.println('0');
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));

                if (i != result.size() - 1) {
                    System.out.print(' ');
                }
            }

            System.out.println();
        }
    }
}
