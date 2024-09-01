package array;

public class FindMedianOfSortedArrays {

    public double findMedian(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);
        double med = median(merged);
        return med;
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

    private int[] merge(int[] nums1, int[] nums2) {
        int posA = 0;
        int posB = 0;
        int pos = 0;
        int[] result = new int[nums1.length + nums2.length];

        while (posA < nums1.length && posB < nums2.length) {
            if (nums1[posA] < nums2[posB]) {
                result[pos++] = nums1[posA++];
            } else if (nums1[posA] > nums2[posB]) {
                result[pos++] = nums2[posB++];
            } else {
                result[pos++] = nums1[posA++];
                result[pos++] = nums2[posB++];
            }
        }

        while (posA < nums1.length) {
            result[pos++] = nums1[posA++];
        }

        while (posB < nums2.length) {
            result[pos++] = nums2[posB++];
        }

        return result;
    }
}
