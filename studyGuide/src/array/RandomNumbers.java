package array;

import java.util.Random;

public class RandomNumbers {

    private static int[] selection;
    private static int internalSize;

    public RandomNumbers(int size) {
        internalSize = size;
        selection = new int[size];
    }

    public int getNextRandom() {
        if (internalSize == 0) {
            return Integer.MAX_VALUE;
        }

        Random random = new Random();
        int next = random.nextInt(internalSize);
        if (next != internalSize) {
            swap(next, internalSize--);
        }
        return selection[next];
    }

    private void swap(int ini, int end) {
        int temp = selection[ini];
        selection[ini] = end;
        selection[end] = temp;
    }
}
