package sorting;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class QuickSort {

    public void sortIterative(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(high);
        stack.push(low);

        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();

            int pivot = partition(arr, left, right);

            if (pivot - 1 > left) {
                stack.push(pivot - 1);
                stack.push(left);
            }

            if (pivot + 1 < right) {
                stack.push(right);
                stack.push(pivot + 1);
            }
        }
        System.out.println(Arrays.stream(arr).toString());
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        int i = left - 1;

        for (int j = left; j <= right; ++j) {
            if (arr[j] <= pivot) {
                int temp = arr[++i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        return i + 1;
    }
}
