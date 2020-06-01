package sorting;

import java.util.Arrays;

/**
 * Created by rodsou on 7/14/17.
 */
public class SortingProblems {

    public static void main(String... args) {
        int[] arr = generateRandomArray(10);
        int[] arr2 = generateRandomArray(10);

        System.out.println(Arrays.toString(arr));

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);

        System.out.println(Arrays.toString(arr));

        System.out.println();
        System.out.println(Arrays.toString(arr2));

        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr2, 0, arr2.length - 1);

        System.out.println(Arrays.toString(arr2));
    }

    private static int[] generateRandomArray(int arraySize) {
        int[] theArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            theArray[i] = (int) (Math.random() * 50) + 10;
        }
        return theArray;
    }
}
