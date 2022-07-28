package queue;

public class MaxCircularQueue {
    //1 [1,0,0,0,0]
    //3 [3,1,0,0,0]
    //2 [3,2,1,0,0]
    //2 []
    public void add(int[] arr, int item) {
        boolean inserted = false;
        for (int i = 0; i < arr.length; ++i) {
            if (item >= arr[i]) {
                int tmp = arr[i];
                arr[i] = item;
                int j = i + 1;
                if (j < arr.length && arr[j] < tmp) {
                    if (j + 1 < arr.length) {
                        arr[j + 1] = arr[j];
                    }
                    arr[j] = tmp;
                }
                inserted = true;
            }
            if (inserted) {
                break;
            }
        }

        if (!inserted) {
            arr[arr.length - 1] = item;
        }
    }
}