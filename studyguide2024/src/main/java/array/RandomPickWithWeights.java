package array;

public class RandomPickWithWeights {

    private final int[] prefixSum;

    private final int totalSum;

    public RandomPickWithWeights(int[] w) {
        this.prefixSum = new int[w.length];

        int prefixSum = 0;
        for (int i : w) {
            prefixSum += i;
            this.prefixSum[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }

    public int pickIndex() {
        double target = totalSum * Math.random();
        int left = 0;
        int right = prefixSum.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (prefixSum[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
