package cover.set;

import java.util.ArrayList;
import java.util.HashMap;

// Represents union of other sets
public class UnionSet implements Set {
    // HashMap to optimize querying belonging numbers
    private final HashMap<Integer, Boolean> isInUnionSet;
    private final ArrayList<Set> list;

    public UnionSet(ArrayList<Set> list) {
        isInUnionSet = new HashMap<>();
        this.list = list;
    }

    @Override
    public boolean contains(int x) {
        // If belonging of x was asked about before then HashMap remembers it
        Boolean isIn = isInUnionSet.get(x);
        if (isIn != null) {
            return isIn;
        }

        // Check if any set from union contains x and remember result in HashMap
        boolean aux = list.stream().anyMatch(p -> p.contains(x));
        isInUnionSet.put(x, aux);
        return aux;
    }
}
