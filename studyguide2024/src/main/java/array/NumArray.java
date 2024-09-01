package array;

public class NumArray {

    private final int[] preComputed;

    public NumArray(int[] nums) {
        preComputed = nums;
        for (int i = 1; i < nums.length; i++) {
            preComputed[i] = preComputed[i] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return preComputed[right];
        }
        return preComputed[right] - preComputed[left - 1];
    }

}
