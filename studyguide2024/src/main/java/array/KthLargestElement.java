package array;

import java.util.PriorityQueue;

public class KthLargestElement {

    public int find(int[] nums, int k) {
        PriorityQueue<Integer> smallest = new PriorityQueue<>();
        for (int i = 0; i < nums.length; ++i) {
            smallest.add(nums[i]);
            if (smallest.size() > k) {
                smallest.remove();
            }
        }
        return smallest.remove();
    }
}
