package array;

public class MedianOfTwoArraysBinarySearch {

    //https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/4071182/99-99-acceptance-with-optimised-solution-explained-in-detail/
    public double findMedian(int[] a, int[] b) {

        if (a.length > b.length) {
            return findMedian(b, a);
        }

        int x = a.length;
        int y = b.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : a[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : a[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : b[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : b[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {

                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side
                low = partitionX + 1;
            }
        }

        throw new IllegalStateException("Arrays are not ordered");
    }
}
