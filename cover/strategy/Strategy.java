package cover.strategy;

import cover.set.Set;

import java.util.ArrayList;

// Implements Strategy pattern
public abstract class Strategy {
    // Returns indices of such sets from cover that fully cover setToCover
    public abstract ArrayList<Integer> coverSet(ArrayList<Set> cover, int[] setToCover);

    // Marks elements of setFromCover in setToCover as covered
    protected void markAsCovered(Set setFromCover, int[] setToCover, boolean[] isCovered) {
        for (int i = 0; i < setToCover.length; i++) {
            if (!isCovered[i] && setFromCover.contains(setToCover[i])) {
                isCovered[i] = true;
            }
        }
    }

    // Checks whether not every element is covered by some set from cover
    protected boolean isSomethingNotCovered(boolean[] isCovered) {
        for (boolean x : isCovered) {
            if (!x) {
                return true;
            }
        }

        return false;
    }
}
