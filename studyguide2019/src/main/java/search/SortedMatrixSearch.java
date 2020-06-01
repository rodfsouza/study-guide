package search;

public class SortedMatrixSearch {

    public boolean find(int[][] matrix, int toFind) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int row = 0; row < matrix.length; ++row) {
            int low = 0;
            int high = matrix[0].length - 1;

            if (binarySearch(matrix[row], low, high, toFind)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int low, int high, int toFind) {
        if (low > high) {
            return false;
        }

        int mid = (low + high) / 2;
        int left = low;
        int right = high;

        if (arr[mid] < toFind) {
            return binarySearch(arr, mid + 1, right, toFind);
        } else if (arr[mid] > toFind) {
            return binarySearch(arr, low, mid -1, toFind);
        } else {
            return true;
        }
    }
}
