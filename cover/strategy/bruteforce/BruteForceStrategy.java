package cover.strategy.bruteforce;

import cover.set.Set;
import cover.strategy.Strategy;

import java.util.ArrayList;

public class BruteForceStrategy extends Strategy {
    private ArrayList<Integer> bestSubset;

    // Checks if given subset of cover covers setToCover
    private boolean checkSubset(ArrayList<Set> cover, int[] setToCover, ArrayList<Integer> subset) {
        boolean[] isCovered = new boolean[setToCover.length];

        for (int i : subset) {
            markAsCovered(cover.get(i - 1), setToCover, isCovered);
        }

        return !isSomethingNotCovered(isCovered);
    }

    // Traverses all subsets of [1, 2, ..., n] (int[] all) in lexicographical order
    private void traverseSubsetsLexicographically(int[] all, ArrayList<Integer> subset, int pos,
                                                  ArrayList<Set> cover, int[] setToCover) {
        for (int i = pos; i < all.length; i++) {
            subset.add(all[i]);

            if (checkSubset(cover, setToCover, subset)) {
                if (bestSubset == null || (subset.size() > 0 && subset.size() < bestSubset.size())) {
                    bestSubset = new ArrayList<>(subset);
                }
            }

            traverseSubsetsLexicographically(all, subset, i + 1, cover, setToCover);

            subset.remove(subset.size() - 1);
        }
    }

    @Override
    public ArrayList<Integer> coverSet(ArrayList<Set> cover, int[] setToCover) {
        int[] indices = new int[cover.size()];

        for (int i = 0; i < indices.length; i++) {
            indices[i] = i + 1;
        }

        bestSubset = null;

        traverseSubsetsLexicographically(indices, new ArrayList<>(), 0, cover, setToCover);

        return bestSubset;
    }
}