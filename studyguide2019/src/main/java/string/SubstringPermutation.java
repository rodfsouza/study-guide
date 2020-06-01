package string;

import java.util.HashSet;
import java.util.Set;

public class SubstringPermutation {

    public void printPermutations(String s, String b) {
        if (s == null || b == null) {
            return;
        }

        if (s.length() == 0 || b.length() == 0) {
            return;
        }

        int[] count = new int[256];
        count = countOccurrences(count, s);

        String sKey = buildKey(count, s);
        Set<String> map = new HashSet<>();
        map.add(sKey);

        for (int i = 0; i < b.length(); ++i) {
            if (i + s.length() <= b.length()) {
                String window = b.substring(i, i + s.length());
                int[] countTemp = new int[256];
                countTemp = countOccurrences(countTemp, window);
                String subKey = buildKey(countTemp, window);
                if (map.contains(subKey)) {
                    System.out.println("Initial: " + i + " End: " + i + s.length());
                }
            }
        }
    }

    private int[] countOccurrences(int[] count, String str) {
        for (int i = 0; i < str.length(); ++i) {
            count[str.charAt(i)] += 1;
        }
        return count;
    }

    private String buildKey(int[] count, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            sb.append(count[str.charAt(i)]).append("#");
        }
        return sb.toString();
    }
}
