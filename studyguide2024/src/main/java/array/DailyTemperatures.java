package array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; ++i) {
            for (int j = i + 1; j < temperatures.length; ++j) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    public int[] numberOfDays(int[] temperatures) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> temps = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; ++i) {
            while (!temps.isEmpty() && temperatures[temps.peek()] < temperatures[i]) {
                nextGreater.put(temps.pop(), i);
            }
            temps.push(i);
        }

        while (!temps.isEmpty()) {
            nextGreater.put(temps.pop(), 0);
        }

        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; ++i) {
            result[i] = nextGreater.get(i) == 0 ? 0 : nextGreater.get(i) - i;
        }
        return result;
    }
}
