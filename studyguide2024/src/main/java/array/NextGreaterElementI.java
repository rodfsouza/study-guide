package array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {

    public int[] find(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> items = new ArrayDeque<>();

        for (int num : nums2) {
            while(!items.isEmpty() && items.peek() < num) {
                nextGreater.put(items.pop(), num);
            }
            items.push(num);
        }

        while (!items.isEmpty()) {
            nextGreater.put(items.pop(), -1);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            result[i] = nextGreater.get(nums1[i]);
        }
        return result;
    }
}
