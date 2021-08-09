package array;

/*
4. Median of Two Sorted Arrays
Hard

4268

565

Favorite

Share
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]du

The median is (2 + 3)/2 = 2.5
 */

public class MedianOfTwoArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merged = merge(nums1, nums2);
        return median(merged);
    }

    private double median(int[] arr) {

        if (arr.length == 0) {
            return 0.0;
        }

        if (arr.length % 2 == 0) {
            return medianForEven(arr);
        } else {
            return medianForOdd(arr);
        }
    }

    private double medianForOdd(int[] arr) {
        int middle = arr.length / 2;
        return (double) arr[middle];
    }

    private double medianForEven(int[] arr) {
        int middle = arr.length / 2;

        if (middle == 0) {
            return (double) arr[middle];
        }

        if (middle - 1 <= arr.length) {
            return (double) (arr[middle - 1] + arr[middle]) / 2;
        }

        return 0.0;
    }

    private int[] merge(int[] a, int[] b) {
        int posA = 0;
        int posB = 0;
        int pointer = 0;
        int[] res = new int[a.length + b.length];

        while (posA < a.length && posB < b.length) {

            if (a[posA] < b[posB]) {
                res[pointer++] = a[posA++];

            } else if (a[posA] > b[posB]) {
                res[pointer++] = b[posB++];

            } else {
                res[pointer++] = a[posA++];
                res[pointer++] = b[posB++];
            }
        }

        while (posA < a.length) {
            res[pointer++] = a[posA++];
        }

        while (posB < b.length) {
            res[pointer++] = b[posB++];
        }

        return res;
    }

}
