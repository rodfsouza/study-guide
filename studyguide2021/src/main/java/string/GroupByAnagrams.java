package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupByAnagrams {

    private static final String KEY_SEPARATOR = "#";

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new LinkedList<>();
        }

        Map<String, List<String>> groupedBy = groupBy(strs);

        List<List<String>> results = transformTo(groupedBy);

        return results;
    }

    private List<List<String>> transformTo(Map<String, List<String>> groupedBy) {

        List<List<String>> results = new LinkedList<>();

        for(Map.Entry<String, List<String>> kv : groupedBy.entrySet()) {
            results.add(groupedBy.get(kv.getKey()));
        }

        return results;
    }

    private Map<String, List<String>> groupBy(String[] strs) {

        Map<String, List<String>> groupedBy = new HashMap<>();

        for (String word : strs) {

            String key = buildKey(word);
            List<String> group = null;

            if (!groupedBy.containsKey(key)) {

                group = new LinkedList<>();

            } else {

                group = groupedBy.get(key);
            }

            group.add(word);
            groupedBy.put(key, group); //overwrite
        }

        return groupedBy;
    }

    private String buildKey(String word) {

        int[] counts = new int[256];

        for (int i = 0; i < word.length(); ++i) {
            counts[word.charAt(i)] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts.length; ++i) {

            if (counts[i] == 0) {
                continue;
            }

            char c = (char)i;
            sb.append(c).append(KEY_SEPARATOR).append(counts[i]).append(KEY_SEPARATOR);
        }

        return sb.toString();
    }
}
