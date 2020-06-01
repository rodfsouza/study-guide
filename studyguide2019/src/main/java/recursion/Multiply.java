package recursion;

/**
 * Runtime: O (log s) - Where S is the smaller number.
 */
public class Multiply {

    public int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductHelper(smaller, bigger);
    }

    private int minProductHelper(int smaller, int bigger) {
        boolean isNegative = false;
        if (smaller == 0) {
            return 0;
        } else if (smaller < 0) {
            isNegative = true;
            smaller = -smaller;
        } else if (smaller == 1) {
            return bigger;
        }
        int s = smaller >> 1;
        int half = minProductHelper(s, bigger);

        if (smaller % 2 == 0) {
            return isNegative ? -(half + half) : half + half;
        } else {
            return isNegative ? -(half + half + bigger) : half + half + bigger;
        }
    }
}
