package sorting;

/**
 * Initialize the auxillary array  as .
 * Note: The size of this array should be .
 * Traverse array  and store the count of occurrence of each element in the appropriate index of the  array, which means, execute Aux[A[i]]++ for each , where  ranges from .
 * Initialize the empty array
 * Traverse array  and copy  into  for  number of times where .
 */
public class CountingSort {

    public int[] sort(int[] arr) {

        int lineSize = arr.length;
        int maxRange = 0;

        //Get the max range on the current array
        for (int i = 0; i < lineSize; ++i) {
            maxRange = Math.max(maxRange, arr[i]);
        }

        //Initialize an array with range + 1 of the original array.
        int[] count = new int[maxRange + 1];
        for (int i = 0; i < lineSize; ++i) {
            count[arr[i]]++;
        }

        int[] sorted = new int[lineSize];
        int j = 0;

        for (int i = 0; i < count.length; ++i) {
            int item = count[i];

            while (item-- > 0) {
                sorted[j] = i;
                j++;
            }
        }
        return sorted;
    }
}
