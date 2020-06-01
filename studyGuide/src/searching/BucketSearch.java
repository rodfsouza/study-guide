package searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by rodsou on 7/14/17.
 */
public class BucketSearch {

    private Map<Integer, List<String>> sortedBySize;
    private List<String>[] sortedArray;

    public BucketSearch(List<String> words) {
        if (words == null || words.isEmpty()) {
            return;
        }
        preProcess(words);
    }

    private void preProcess(List<String> words) {
        Map<String, Integer> wordCount = countWords(words);
        Map<Integer, List<String>> bucket = bucketize(wordCount);
        //sortedBySize = sortBySize(bucket);
        sortedArray = sortBySize2(bucket);
    }

    private Map<String, Integer> countWords(final List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
                continue;
            }
            wordCount.put(word, 1);
        }
        return wordCount;
    }

    private Map<Integer, List<String>> bucketize(final Map<String, Integer> wordCount) {

        Map<Integer, List<String>> bucket = new HashMap<>();
        for (Map.Entry<String, Integer> kv : wordCount.entrySet()) {
            Integer key = kv.getValue();
            String word = kv.getKey();
            List<String> words;
            if (bucket.containsKey(key)) {
                words = bucket.get(key);
                words.add(word);
                bucket.put(key, words);
                continue;
            }
            words = new ArrayList<>();
            words.add(word);
            bucket.put(key, words);
        }
        return bucket;
    }

    private static Map<Integer, List<String>> sortBySize(Map<Integer, List<String>> wordsByCount) {
        List<Map.Entry<Integer, List<String>>> list =
            new LinkedList<>(wordsByCount.entrySet());

        Collections.sort(list, (o1, o2) -> ((Integer) o2.getValue().size()).compareTo(o1.getValue().size()));

        Map<Integer, List<String>> sortedByValueSize = new LinkedHashMap<>();
        int pos = 1;
        for (Map.Entry<Integer, List<String>> kv : list) {
            sortedByValueSize.put(pos++, kv.getValue());
        }
        return sortedByValueSize;
    }

    private static List<String>[] sortBySize2(Map<Integer, List<String>> wordsByCount) {
        List<Map.Entry<Integer, List<String>>> list =
            new LinkedList<>(wordsByCount.entrySet());

        Collections.sort(list, (o1, o2) -> ((Integer) o2.getValue().size()).compareTo(o1.getValue().size()));

        List<String>[] sortedByValueSize = new List[list.size()];
        int pos = 0;
        for (Map.Entry<Integer, List<String>> kv : list) {
            sortedByValueSize[pos++] = kv.getValue();
        }
        return sortedByValueSize;
    }

    public List<String> getWords2(int position) {
        if (position <= 0 || position > sortedArray.length) {
            throw new IllegalArgumentException();
        }

        if (sortedArray.length == 0) {
            return new ArrayList<>();
        }
        return sortedArray[--position];
    }

    public List<String> getWords(int position) {
        if (sortedBySize == null || sortedBySize.isEmpty()) {
            return new ArrayList<>();
        }
        return sortedBySize.get(position);
    }
}
