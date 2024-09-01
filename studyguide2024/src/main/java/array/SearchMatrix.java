package array;

public class SearchMatrix {

    public boolean search(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (binarySearch(row, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == target) {
                return true;
            }

            if (target < row[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
