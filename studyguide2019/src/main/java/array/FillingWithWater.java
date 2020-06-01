package array;

public class FillingWithWater {

    public static int howMuchWater(int[] elevation) {

        int prev = 0;
        int after = 2;
        int size = elevation.length - 1;
        int sum = 0;

        for (int curr = 1; curr <= size; ++curr) {
            int elevCurr = elevation[curr];
            if (after <= size) {
                int elePrev = elevation[prev];
                int eleAfter = elevation[after];
                if (elevCurr < elePrev && elevCurr < eleAfter) {
                    if (elePrev > eleAfter) {
                        sum+= elePrev - eleAfter;
                    } else {
                        sum+= eleAfter - elePrev;
                    }
                    prev = curr;
                    after++;
                } else {
                    prev++;
                    after++;
                }
            }
        }
        return sum;
    }
}
