package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    public List<List<String>> groupBy(List<String> words) {
        if (words == null || words.isEmpty()) {
            //throw
        }

        Map<String, List<String>> map = new HashMap<>(); //Assuming the Key will exist
        for (String word : words) {
            String key = buildKey(word);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(key, list);
            } else {
                List<String> current = map.get(key);
                current.add(word);
                map.put(key, current);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> kv : map.entrySet()) {
            List<String> l = new ArrayList<>();
            for (String s : kv.getValue()) {
                l.add(s);
            }
            result.add(l);
        }
        return result;
    }

    private String buildKey(String word) {
        int[] count = new int[256]; //ASCII

        for(int i = 0; i < word.length(); ++i) {
            count[word.charAt(i)] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; ++i) {
            if (count[i] == 0) {
                continue;
            }

            char c = (char)i;
            sb.append(c).append("#").append(count[i]).append("#");
        }
        return sb.toString();
    }

}
