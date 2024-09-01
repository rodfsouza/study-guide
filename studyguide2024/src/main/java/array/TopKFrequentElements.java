package array;

import java.util.*;

public class TopKFrequentElements {
    public int[] topK(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> topElements = new PriorityQueue<>((a, b) ->
                Integer.compare(a.getValue(), b.getValue()));

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            topElements.add(entry);
            if (topElements.size() > k) {
                topElements.remove();
            }
        }

        int pos = k - 1;
        int[] topKElements = new int[k];
        while (!topElements.isEmpty() && pos >= 0) {
            topKElements[pos--] = topElements.remove().getKey();
        }

        return topKElements;
    }
}
