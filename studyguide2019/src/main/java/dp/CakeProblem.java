package dp;

import java.util.Arrays;

public class CakeProblem {

    public static class CakeType {

        final int weight;
        final int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value  = value;
        }
    }

    public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {

        if (weightCapacity < 0) {
            return 0;
        }
        // calculate the maximum value that we can carry
        long[] maxValues= new long[weightCapacity + 1];

        Arrays.fill(maxValues, 0);

        for (CakeType cake : cakeTypes) {
            int currValue = cake.value;
            int currWeight = cake.weight;

            if (currWeight > weightCapacity) {
                continue;
            }

            for (int w = currWeight; w <= weightCapacity; w += currWeight) {
                int remainder = w - currWeight;
                long maxValueUsingCake = maxValues[remainder] + currValue;
                long max = Math.max(maxValueUsingCake, maxValues[w]);
                maxValues[w] = max;
            }
        }
        return maxValues[weightCapacity];
    }

}
