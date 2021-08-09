package searching;

public class BinarySearch {

    /***
     * Implements a binary search through the given array.
     * @param array
     * @param toFind
     * @return
     */
    public static boolean isPresent(int[] array, int toFind) {

        if (array == null || array.length == 0) {
            return false;
        }

        int middle = array.length / 2; //overflow

        if (toFind > array[middle]) {
            return binarySearch(array, ++middle, array.length - 1, toFind);
        }

        return binarySearch(array, 0, middle, toFind);
    }

    private static boolean binarySearch(int[] array, int start, int end, int toFind) {

        while (start <= end) {
            if (array[start] == toFind) {
                return true;
            }
            start++;
        }
        return false;
    }
}
