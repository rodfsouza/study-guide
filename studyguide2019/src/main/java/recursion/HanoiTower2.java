package recursion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class HanoiTower2 {

    public void computeTowerHanoi(int numofRings) {
        if (numofRings <= 0) {
            return;
        }
        List<Deque<Integer>> pegs = new ArrayList<>();
        //Create towers (pegs)
        for(int i =0; i < 3; ++i) {
            pegs.add(new LinkedList<>());
        }

        for (int i = numofRings; i >= 0; --i) {
            pegs.get(0).addFirst(i);
        }

        computeTowerHanoiSteps(numofRings, pegs, 0, 1, 2);
    }

    private void computeTowerHanoiSteps(int numberOfRingsToMove, List<Deque<Integer>> pegs, int fromPeg,
                                        int toPeg, int usePeg) {

        if (numberOfRingsToMove > 0) {
            computeTowerHanoiSteps(numberOfRingsToMove - 1, pegs, fromPeg, usePeg, toPeg);
            pegs.get(toPeg).addFirst(pegs.get(fromPeg).removeFirst());
            System.out.println("Move from peg " + fromPeg + " to peg " + toPeg);
            computeTowerHanoiSteps(numberOfRingsToMove - 1, pegs, usePeg, toPeg, fromPeg);
        }
    }

}
