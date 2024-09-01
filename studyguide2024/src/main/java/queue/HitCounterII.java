package queue;

import java.util.ArrayDeque;

public class HitCounterII {

    private final int LIMIT = 300;

    private final int[] hits;

    private int position = 0;

    private int currSize = 0;

    public HitCounterII() {
        this.hits = new int[LIMIT];
    }

    public void hit(int timestamp) {
        if (position == LIMIT - 1) {
            position = 0;
            hits[position] = timestamp;
            currSize = 1;
        } else {
            hits[position++] = timestamp;
            currSize++;
        }
    }

    public int getHits(int timestamp) {
        int left = 0;
        int right = currSize;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hits[mid] <= timestamp - LIMIT) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Math.max(currSize - left, 0);
    }
}
