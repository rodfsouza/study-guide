package array;

import java.util.HashMap;
import java.util.Map;

public class FindElementWithHighestFrequency {

    public int find(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int higher = -1;
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int number : array) {
            if (!occurrences.containsKey(number)) {
                occurrences.put(number, 1);
                if (!occurrences.containsKey(higher)) {
                    higher = number;
                    continue;
                }
            }
            occurrences.put(number, occurrences.get(number) + 1);
            if (occurrences.get(higher) < occurrences.get(number)) {
                higher = number;
            }
        }
        return higher;
    }
}
