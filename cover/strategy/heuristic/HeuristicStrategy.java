package cover.strategy.heuristic;

import cover.set.Set;
import cover.strategy.Strategy;

public abstract class HeuristicStrategy extends Strategy {
    // Counts number of common elements of setFromCover and setToCover which
    // are not already covered
    public int setCoverIntersection(Set setFromCover, int[] setToCover, boolean[] isCovered) {
        int count = 0;

        for (int i = 0; i < setToCover.length; i++) {
            if (!isCovered[i] && setFromCover.contains(setToCover[i])) {
                count++;
            }
        }

        return count;
    }
}
