package recursion;

public class MagicIndex {

    public int magic(int[] arr) {
        return magicFast(arr, 0, arr.length -1);
    }

    private int magicFast(int[] arr, int ini, int end) {
        if (end < ini) {
            return -1;
        }

        int mid = (ini + end) / 2;

        if (arr[mid] == mid) {
            return mid;
        } else if (arr[mid] > mid) {
            return magicFast(arr, ini, mid - 1);
        } else {
            return magicFast(arr, mid + 1, end);
        }
    }
}
