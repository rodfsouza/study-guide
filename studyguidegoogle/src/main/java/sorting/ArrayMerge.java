package sorting;

import java.util.ArrayList;
import java.util.List;

public class ArrayMerge {

    public static int[] merge(int[] a, int[] b) {
        List<Integer> merged = new ArrayList<>();
        mergeHelper(a, b, 0, 0, merged);
        return toArray(merged);
    }

    public static int[] mergeRotated(int[] a, int[] b) {
        List<Integer> merged = new ArrayList<>();
        mergeRotatedHelper(a, b, a.length -1, b.length - 1, merged);
        return toArray(merged);
    }

    private static int[] mergeSortedArray(int[] a, int[] b) {
        if (a.length == 0 && b.length != 0) {
            return b;
        }

        if (a.length != 0 && b.length == 0) {
            return a;
        }

        int posA = 0;
        int posB = 0;

        List<Integer> mergedResult = new ArrayList<>();

        while (posA < a.length && posB < b.length) {
            if (a[posA] < b[posB]) {
                mergedResult.add(a[posA++]);
            } else if (a[posA] == b[posB]) {
                mergedResult.add(a[posA++]);
                posB++;
            } else {
                mergedResult.add(b[posB++]);
            }
        }

        while (posA < a.length) {
            mergedResult.add(a[posA++]);
        }

        while (posB < b.length) {
            mergedResult.add(b[posB++]);
        }

        return toArray(mergedResult);
    }

    private static List<Integer> mergeHelper(int[] a, int[] b, int posA, int posB, List<Integer> merged) {

        if (posA < a.length && posB < b.length) {

            if (a[posA] < b[posB]) {
                merged.add(a[posA++]);
                mergeHelper(a, b, posA, posB, merged);
            } else if (a[posA] == b[posB]) {
                merged.add(a[posA++]);
                mergeHelper(a, b, posA, ++posB, merged);
            } else {
                merged.add(b[posB++]);
                mergeHelper(a, b, posA, posB, merged);
            }
        }

        return merged;
    }


    private static List<Integer> mergeRotatedHelper(int[] a, int[] b, int posA, int posB, List<Integer> merged) {

        if (posA >= 0 && posB >= 0) {

            if (a[posA] < b[posB]) {
                merged.add(a[posA--]);
                mergeRotatedHelper(a, b, posA, posB, merged);
            } else if (a[posA] == b[posB]) {
                merged.add(a[posA--]);
                mergeRotatedHelper(a, b, posA, --posB, merged);
            } else {
                merged.add(b[posB--]);
                mergeRotatedHelper(a, b, posA, posB, merged);
            }
        }

        return merged;
    }

    private static int[] toArray(List<Integer> toBeConverted) {
        int[] result = new int[toBeConverted.size()];

        for (int i = 0, j = 0; j < toBeConverted.size(); i++, j++) {
            result[i] = toBeConverted.get(j);
        }
        return result;
    }
}
