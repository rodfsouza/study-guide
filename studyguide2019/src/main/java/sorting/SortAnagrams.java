package sorting;

import java.util.*;

public class SortAnagrams {

    public List<List<String>> groupBy(List<String> words) {
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : words) {
            String key = buildKey(s);
            if (!map.containsKey(key)) {
                List<String> values = new ArrayList<>();
                values.add(s);
                map.put(key, values);
            } else {
                List<String> currValues = map.get(key);
                currValues.add(s);
                map.put(key, currValues);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> kv : map.entrySet()) {
            List<String> l = new ArrayList<>();
            for (String s : kv.getValue()) {
                l.add(s);
            }
            result.add(l);
        }
        return result;
    }

    private String buildKey(String str) {
        int[] count = new int[256]; //ASCII
        for (int i = 0; i < str.length(); ++i) {
            count[str.charAt(i)] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; ++i) {
            if (count[i] == 0) {
                continue;
            }
            char c = (char)i;
            sb.append(c).append("#").append(count[i]).append("#");
        }
//        for (int i = 0; i < str.length(); ++i) {
//            char c = str.charAt(i);
//            sb.append(count[c]).append(c).append("#");
//        }
//        String currentStr = sb.toString();
//        Arrays.sort(currentStr.toCharArray());
        return sb.toString();
    }
}
