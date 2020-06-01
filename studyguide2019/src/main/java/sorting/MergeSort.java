package sorting;

public class MergeSort {

    public  void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int low, int high) {
        if (low > high) {
            return;
        }
        int middle = low + (low + high) / 2;
        mergeSort(arr, temp, 0, middle);
        mergeSort(arr, temp, middle + 1, high);
        merge(arr, temp, low, middle, high);
    }

    private void merge(int[] arr, int[] temp, int low, int middle, int high) {
        for(int i = low; i <= high; ++i) {
            temp[i] = arr[i];
        }

        int left = low;
        int right = middle;
        int index = low;

        while (left <= middle && right <= high) {
            if (arr[left] <= arr[right]) {
                arr[index] = temp[left];
                left++;
            } else {
                arr[index] = temp[right];
                right++;
            }
            index++;
        }

        int remaining = middle - left;
        for (int i = 0; i <= remaining; ++i) {
            arr[index + i] = temp[left + i];
        }
    }
}
