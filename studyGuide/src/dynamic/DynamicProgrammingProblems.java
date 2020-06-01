package dynamic;

/**
 * Created by rodsou on 7/11/17.
 */
public class DynamicProgrammingProblems {

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};
        System.out.println(findMedianSortedArrays2(a, b));
        System.out.println(climbStairs2(6));
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid = 0;
        double median = 0.0;

        if (nums1.length == 0) {
            mid = nums2.length / 2;
            median = (mid == 0 || nums2.length % 2 != 0) ? nums2[mid] : ((double)nums2[mid] + (double)nums2[--mid]) / 2;
            return median;
        } else if (nums2.length == 0) {
            mid = nums1.length / 2;
            median = (mid == 0 || nums1.length % 2 != 0) ? nums1[mid] : ((double)nums1[mid] + (double)nums1[--mid]) / 2;
            return median;
        }

        int[] merged = mergeSortedArrays(nums1, nums2);
        mid = merged.length / 2;

        if (merged.length % 2 == 0) {
            median = ((double)merged[--mid] + (double)merged[++mid]) / 2;
        } else {
            median = merged[mid];
        }
        return median;
    }

    private static int[] mergeSortedArrays(int[] a, int[] b) {
        if (a.length == 0) {
            return b;
        }

        if (b.length == 0) {
            return a;
        }

        int posA = 0;
        int posB = 0;
        int mergePos = 0;
        int[] merged = new int[a.length + b.length];

        while (posA < a.length && posB < b.length) {
            if (a[posA] < b[posB]) {
                merged[mergePos++] = a[posA++];
            } else if (b[posB] < a[posA]) {
                merged[mergePos++] = b[posB++];
            } else if (a[posA] == b[posB]) {
                merged[mergePos++] = a[posA++];
                merged[mergePos++] = b[posB++];
            }
        }

        if (posA < a.length) {
            for (int i = posA; i < a.length; i++) {
                merged[mergePos++] = a[i];
            }
        } else if (posB < b.length) {
            for (int i = posB; i < b.length; i++) {
                merged[mergePos++] = b[i];
            }
        }
        return merged;
    }

    static double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    static double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) {
            return B[bStart + k - 1];
        }
        if (bStart > B.length - 1) {
            return A[aStart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        int i = aStart + k/2, j = bStart + k/2;
        if (i - 1 < A.length) {
            aMid = A[i - 1];
        }
        if (j - 1 < B.length) {
            bMid = B[j - 1];
        }

        int kk = k - k / 2;
        if (aMid < bMid) {
            return getkth(A, i, B, bStart, kk);// Check: aRight + bLeft
        }
        else {
            return getkth(A, aStart, B, j, kk);// Check: bRight + aLeft
        }
    }

    static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return n;
        } else if (n == 2) {
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    static int climbStairs2(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            a = (b += a) - a;
        }
        return a;
    }
}
