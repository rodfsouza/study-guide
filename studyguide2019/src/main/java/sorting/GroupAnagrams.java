package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupAnagrams {


    public int groupBy(final List<String> words) {

        if (words == null || words.isEmpty()) {
            return 0;
        }

        Set<String> groups = new HashSet<>();

        //O (n log(n))
        Collections.sort(words);

        for (String str : words) {

            //Amortized O (n log(n))
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);

            if (!groups.contains(sorted)) {
                groups.add(sorted);
            }
        }
        return groups.size();
    }

    public int groupByCount(final List<String> words) {
        if (words == null || words.isEmpty()) {
            return 0;
        }

        Set<String> map = new HashSet<>();

        //Parse the input
        for (String word : words) {
            int[] count = new int[256];
            char[] wordCount = word.toCharArray();

            //Count the occurrences
            for (int i = 0; i < wordCount.length; ++i) {
                ++count[wordCount[i]];
            }

            //If key does not exists adds
            String key = buildKey(count, wordCount);
            if (!map.contains(key)) {
                map.add(key);
            }
        }
        return map.size();
    }

    private String buildKey(int[] counter, char[] letters) {
        StringBuilder key = new StringBuilder();
        for (int j = 0;j < letters.length; ++j) {
            key.append(counter[letters[j]]).append("#");
        }
        return key.toString();
    }

}
