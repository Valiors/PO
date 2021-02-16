package cover.strategy.heuristic;

import cover.set.Set;

import java.util.ArrayList;

public class NaiveStrategy extends HeuristicStrategy {
    @Override
    public ArrayList<Integer> coverSet(ArrayList<Set> cover, int[] setToCover) {
        ArrayList<Integer> result = new ArrayList<>();

        boolean[] isCovered = new boolean[setToCover.length];

        for (int i = 0; i < cover.size(); i++) {
            if (setCoverIntersection(cover.get(i), setToCover, isCovered) > 0) {
                markAsCovered(cover.get(i), setToCover, isCovered);
                result.add(i + 1);
            }
        }

        if (isSomethingNotCovered(isCovered)) {
            return null;
        }

        return result;
    }
}
