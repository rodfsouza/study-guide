package sorting;

public class Sort {

    /***
     * Merge sort implementation
     * Avg: O(n log n), Worst: O(n log n)
     * Space: O(n)
     * Stability: Stable
     * @param toSort
     */
    public static void mergeSort(int[] toSort) {
        if (toSort == null || toSort.length == 0) {
            return;
        }

        int[] helper = new int[toSort.length];
        sort(toSort, helper, 0, toSort.length - 1);
    }

    private static void sort(int[] toSort, int[] helper, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(toSort, helper, left, middle);
            sort(toSort, helper, middle + 1, right);
            merge(toSort, helper, left, middle, right);
        }
    }

    private static void merge(int[] toSort, int[] helper, int start, int middle, int end) {

        for (int i = 0; i < toSort.length; i++) {
            helper[i] = toSort[i];
        }

        int left = start;
        int right = middle + 1;
        int current = start;

        while (left <= middle && right <= end) {
            if (helper[left] <= helper[right]) {
                toSort[current++] = helper[left++];
            } else {
                toSort[current++] = helper[right++];
            }
        }

        int remaining = middle - left;
        for (int i = 0; i <= remaining; i++) {
            toSort[current + i] = helper[left + i];
        }
    }


    /***
     * Quick sort implementation
     * Avg: O(n log n), Worst: O(nˆ2)
     * Space: Avg: O(n log n)
     * Stability: Not Stable, depends on choice of pivot point.
     * @param toSort
     */
    public static void quickSort(int[] toSort) {
        if (toSort == null || toSort.length == 0) {
            return;
        }

        quickSort(toSort, 0, toSort.length - 1);
    }

    private static void quickSort(int[] toSort, int left, int right) {

        int pivot = partition(toSort, left, right);

        if (left < pivot - 1) {
            quickSort(toSort, left, pivot - 1);
        }

        if (right > pivot) {
            quickSort(toSort, pivot, right);
        }
    }

    private static int partition(int[] toSort, int left, int right) {
        int pivot = toSort[(left + right) / 2];

        while (left <= right) {

            while (toSort[left] < pivot)
                left++;

            while (toSort[right] > pivot)
                right--;

            if (left <= right) {
                swap(toSort, left++, right--);
            }
        }

        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
