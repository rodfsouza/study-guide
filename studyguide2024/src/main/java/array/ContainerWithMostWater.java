package array;

public class ContainerWithMostWater {

    //1,8,6,2,5,4,8,3,7
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int maxArea = 0;

        for(int left = 0, right = height.length - 1; left < right;) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
