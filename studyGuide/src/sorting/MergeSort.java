package sorting;

/**
 * Created by rodsou on 7/20/17.
 */
public class MergeSort {

    public void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int[] helper = new int[arr.length];
        sort(arr, helper, 0, arr.length - 1);
    }

    private void sort(int arr[], int[] helper, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(arr, helper, left, middle);
            sort(arr, helper, middle + 1, right);
            merge(arr, helper, left, middle, right);
        }
    }

    private void merge(int arr[], int[] helper, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }

        int left = low;
        int right = middle + 1;
        int current = low;

        while (left <= middle && right <= high) {
            if (helper[left] <= helper[right]) {
                arr[current++] = helper[left++];
            } else {
                arr[current++] = helper[right++];
            }
        }

        int remaining = middle - left;
        for (int i = 0; i <= remaining; i++) {
            arr[current + i] = helper[left + i];
        }
    }
}
