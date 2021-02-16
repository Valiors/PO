package cover.input.input;

import cover.input.data.Dispatch;
import cover.input.data.InsertDispatch;
import cover.input.data.QueryDispatch;
import cover.set.*;
import cover.strategy.Strategy;
import cover.strategy.bruteforce.BruteForceStrategy;
import cover.strategy.heuristic.GreedyStrategy;
import cover.strategy.heuristic.NaiveStrategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StandardInput implements Input {
    // Lines are read by BufferedReader, remembered and tokenized
    // by StringTokenizer to allow fast retrieval of single next integers
    private final BufferedReader in;
    private StringTokenizer tokenizer;

    public StandardInput() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    // Returns next token which is not a whitespace character
    private String next() {
        while (tokenizer == null || !tokenizer.hasMoreElements()) {
            try {
                tokenizer = new StringTokenizer(in.readLine());
            } catch (Throwable e) {
                return null;
            }
        }

        return tokenizer.nextToken();
    }

    private Integer nextInt() {
        String aux = next();

        if (aux == null) {
            return null;
        }

        return Integer.parseInt(aux);
    }

    private InsertDispatch getNextInsert(Integer a) {
        ArrayList<Set> list = new ArrayList<>();

        while (a != 0) {
            Integer b = nextInt();

            if (b == null) {
                return null;
            }

            if (b >= 0) {
                list.add(new Singleton(a));

                a = b;

                continue;
            }

            Integer c = nextInt();

            if (c == null) {
                return null;
            }

            if (c >= 0) {
                list.add(new ArithmeticProgression(a, -b));

                a = c;

                continue;
            }

            list.add(new BoundedArithmeticProgression(a, -b, -c));

            a = nextInt();

            if (a == null) {
                return null;
            }
        }

        if (list.isEmpty()) {
            return new InsertDispatch(new EmptySet());
        } else if (list.size() == 1) {
            return new InsertDispatch(list.get(0));
        } else {
            return new InsertDispatch(new UnionSet(list));
        }
    }

    private QueryDispatch getNextQuery(int a) {
        a = -a;
        Integer strategyID = nextInt();

        if (strategyID == null) {
            return null;
        }

        int[] setToCover = new int[a];
        for (int i = 0; i < setToCover.length; i++) {
            setToCover[i] = i + 1;
        }

        Strategy strategy = null;

        switch (strategyID) {
            case 1:
                strategy = new BruteForceStrategy();
                break;
            case 2:
                strategy = new GreedyStrategy();
                break;
            case 3:
                strategy = new NaiveStrategy();
                break;
        }

        return new QueryDispatch(setToCover, strategy);
    }

    @Override
    public Dispatch getNextData() {
        Integer a = nextInt();

        if (a == null) {
            return null;
        }

        if (a >= 0) {
            return getNextInsert(a);
        } else {
            return getNextQuery(a);
        }
    }
}
