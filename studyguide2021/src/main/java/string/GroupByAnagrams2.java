package string;

import java.util.*;

public class GroupByAnagrams2 {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new LinkedList<>();
        }

        //Arrays.sort(strs);
        Map<String, List<String>> groupedBy = groupByAnagramKey(strs);
        List<List<String>> anagrams = new LinkedList<>();

        for (Map.Entry<String, List<String>> kv : groupedBy.entrySet()) {
            anagrams.add(kv.getValue());
        }

        return anagrams;
    }

    private Map<String, List<String>> groupByAnagramKey(String[] strs) {

        Map<String, List<String>> groupedBy = new HashMap<>();

        for (String word : strs) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);

            List<String> anagrams;

            if (!groupedBy.containsKey(key)) {
                anagrams = new LinkedList<>();
            } else {
                anagrams = groupedBy.get(key);
            }

            anagrams.add(word);
            groupedBy.put(key, anagrams);
        }

        return groupedBy;
    }
}
