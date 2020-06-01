package dp;

public class CakeProblem2 {

    public static class CakeType2 {

        final int weight;
        final int value;

        public CakeType2(int weight, int value) {
            this.weight = weight;
            this.value  = value;
        }
    }

    public static long maxDuffelBagValue(CakeType2[] cakeTypes, int weightCapacity) {

        long [][] cakesVsCapacity = new long[cakeTypes.length + 1][weightCapacity + 1];

        for (int i = 0; i <= cakeTypes.length; ++i) {

            for (int j = 0; j <= weightCapacity; ++j) {

                if (i == 0 || j == 0) {
                    cakesVsCapacity[i][j] = 0;
                    continue;
                }

                CakeType2 cakeType = cakeTypes[i - 1];
                if (cakeType.weight > j) {
                    cakesVsCapacity[i][j] = cakesVsCapacity[i - 1][j];
                } else {
                    cakesVsCapacity[i][j] = Math.max(cakeType.value +
                            cakesVsCapacity[i - 1][j - cakeType.weight], cakesVsCapacity[i - 1][j]);
                }
            }
        }
        return cakesVsCapacity[cakeTypes.length][weightCapacity];
    }
}
