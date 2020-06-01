package array;

public class ContainerMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int maxArea = 0;

        for (int l = 0, r = height.length - 1; l < r;) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }
}
