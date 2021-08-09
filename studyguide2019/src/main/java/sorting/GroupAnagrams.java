package sorting;

import java.util.*;

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
            //char[] wordCount = word.toCharArray();

            //Count the occurrences
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                ++count[c - 'a'];
            }

            StringBuilder sb = new StringBuilder();
            for (int p : count) {
                sb.append(p).append("#");
            }

            //If key does not exists adds
            String key = sb.toString();//buildKey(count, word);
            if (!map.contains(key)) {
                map.add(key);
            }
        }
        return map.size();
    }

    public List<List<String>> groupBy2(final List<String> words) {
        if (words == null || words.isEmpty()) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> results = new ArrayList<>();
        int[] count = new int[256];

        //Parse the input
        for (String word : words) {

            //Count the occurrences
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                ++count[c - 'a'];
            }

            //Build key
            StringBuilder sb = new StringBuilder();
            int counter = 0;
            for (int p : count) {
                sb.append(p).append("#");
                count[counter++] = 0;
            }

            //If key does not exists adds
            String key = sb.toString();//buildKey(count, word);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        results.addAll(map.values());
        return results;
    }

    //Most efficient
    public List<List<String>> groupBy3(final List<String> words) {

        if (words == null || words.isEmpty()) {
            return null;
        }

        Map<String, List<String>> groups = new HashMap<>();

        for (String str : words) {

            //Amortized O (n log(n))
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);

            if (!groups.containsKey(sorted)) {
                groups.put(sorted, new LinkedList<>());
            }

            groups.get(sorted).add(str);
        }
        return new LinkedList<>(groups.values());
    }

}
