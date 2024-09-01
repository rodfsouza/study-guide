package array.matrix;

import java.util.Arrays;

public class MaxSquareField {

    public int MaxSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MOD = 1_000_000_007;

        Arrays.sort(hFences);
        Arrays.sort(vFences);

        int maxH = Math.max(hFences[0], m - hFences[hFences.length - 1]);
        for (int i = 1; i < hFences.length; i++) {
            maxH = Math.max(maxH, hFences[i] - hFences[i - 1]);
        }

        int maxV = Math.max(vFences[0], n - vFences[vFences.length - 1]);
        for (int i = 1; i < vFences.length; i++) {
            maxV = Math.max(maxV, vFences[i] - vFences[i - 1]);
        }

        int maxSide = Math.min(maxH, maxV);
        if (maxSide <= 0) {
            return -1;
        }

        return (int) ((long) maxSide * maxSide % MOD);
    }
}
