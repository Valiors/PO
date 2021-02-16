package cover.strategy.heuristic;

import cover.set.Set;

import java.util.ArrayList;
import java.util.Collections;

public class GreedyStrategy extends HeuristicStrategy {
    @Override
    public ArrayList<Integer> coverSet(ArrayList<Set> cover, int[] setToCover) {
        ArrayList<Integer> result = new ArrayList<>();

        boolean[] isCovered = new boolean[setToCover.length];

        boolean[] isSetUnavailable = new boolean[cover.size()];
        int availableSetCount = cover.size();

        int chosen;
        int chosenCoverCount;

        // While there are some sets from cover left
        while(availableSetCount > 0) {
            chosen = -1;
            chosenCoverCount = 0;

            for (int i = 0; i < cover.size(); i++) {
                if (!isSetUnavailable[i]) {
                    // Count how many elements of setToCover are covered by cover.get(i)
                    // which were not covered previously
                    int coverCount = setCoverIntersection(cover.get(i), setToCover, isCovered);

                    // We can forget about sets which don't cover uncovered elements
                    if (coverCount == 0) {
                        isSetUnavailable[i] = true;
                        availableSetCount--;
                    } else if (coverCount > chosenCoverCount) {
                        chosen = i;
                        chosenCoverCount = coverCount;
                    }
                }
            }

            if (chosen != -1) {
                markAsCovered(cover.get(chosen), setToCover, isCovered);

                isSetUnavailable[chosen] = true;
                availableSetCount--;

                result.add(chosen + 1);
            }
        }

        if (isSomethingNotCovered(isCovered)) {
            return null;
        }

        // Elements are usually not inserted in order, so sort is necessary
        Collections.sort(result);

        return result;
    }
}
