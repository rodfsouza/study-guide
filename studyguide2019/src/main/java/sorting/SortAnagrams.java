package sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortAnagrams {

    public List<String> groupBy(List<String> words) {
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

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> kv : map.entrySet()) {
            for (String s : kv.getValue()) {
                result.add(s);
            }
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
        return sb.toString();
    }
}
