package cover;

import cover.input.data.Dispatch;
import cover.input.input.Input;
import cover.input.input.StandardInput;
import cover.solver.SetCoverSolver;

public class Main {
    public static void main(String[] args) {
        SetCoverSolver solver = new SetCoverSolver();
        Input input = new StandardInput();

        Dispatch dispatch = null;
        while ((dispatch = input.getNextData()) != null) {
            dispatch.performOperation(solver);
        }
    }
}
