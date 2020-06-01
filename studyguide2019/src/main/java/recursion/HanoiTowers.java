package recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public class HanoiTowers {

    public static class Tower {
        private final Deque<Integer> disks;
        private final int index;

        public Tower(int i) {
            disks = new ArrayDeque<>();
            index = i;
        }

        public void add(int disk) {
            if (!disks.isEmpty() && disks.peek() <= disk) {
                throw new IllegalArgumentException("Invalid disk placement");
            }
            disks.push(disk);
        }

        public void moveTopTo(Tower t) {
            if (t == null) {
                throw new IllegalArgumentException();
            }
            int top = disks.pop();
            t.add(top);;
        }

        public void moveDisk(int index, Tower destination, Tower buffer) {
            if (index > 0) {
                moveDisk(index - 1, buffer, destination);
                moveTopTo(destination);
                moveDisk(index - 1, destination, this);
            }
        }
    }
}
