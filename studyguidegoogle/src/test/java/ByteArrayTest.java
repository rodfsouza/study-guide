import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ByteArrayTest {

    @Test
    public void findMedian() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        double result = findMedianSortedArrays(nums1, nums2);
        Assertions.assertTrue(result == 2.0);
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;

        if ((nums1.length + nums2.length) % 2 != 0) {
            int[] merged = merge(nums1, nums2);
            result = merged[merged.length / 2];
        } else {
            int half1 = nums1[nums1.length / 2];
            int half2 = nums2[(nums2.length / 2) -1 ];
            result = (half1 + half2) / 2.0;
        }
        return result;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();

        int pos1 = 0;
        int pos2 = 0;

        while (pos1 < nums1.length && pos2 < nums2.length) {
            if (nums1[pos1] < nums2[pos2]) {
                result.add(nums1[pos1++]);
            } else if (nums1[pos1] == nums2[pos2]) {
                result.add(nums1[pos1++]);
                pos2++;
            } else {
                result.add(nums2[pos2++]);
            }
        }

        while (pos1 < nums1.length) {
            result.add(nums1[pos1++]);
        }

        while (pos2 < nums2.length) {
            result.add(nums2[pos2++]);
        }

        return toIntArray(result);
    }

    private int[] toIntArray(List<Integer> list) {
        int[] result = new int[list.size()];

        int i = 0;
        for (Integer item : list) {
            result[i++] = item;
        }
        return result;
    }
}
