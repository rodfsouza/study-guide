package matrix;

public class CircularArrayCycle {

    public boolean hasCycle(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        int currentPos = 0;
        int size = array.length;

        for (int i = 0; i < size; i++) {
            currentPos = (currentPos + array[currentPos]) % size;

            if (currentPos < 0) {
                currentPos += size;
            }

            if (currentPos == 0 && i < size - 1) {
                return false;
            }
        }

        return currentPos == 0;
    }
}
