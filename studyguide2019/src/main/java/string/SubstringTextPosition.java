package string;

import java.util.ArrayList;
import java.util.List;

public class SubstringTextPosition {

    public List<SubStringPosition> subPositions(String text, String pattern) {
        //TODO: Add input sanity checks

        List<SubStringPosition> result = new ArrayList<>();
        int subSize = pattern.length();
        int subHash = hash(pattern);
        int[] cache = buildCache(pattern);

        for (int i = 0; i < text.length()  && i + subSize - 1 < text.length(); ++i) {
            String window = text.substring(i, i + subSize);
            if (hash(window) == subHash && checkEquals(window, cache)) {
                result.add(new SubStringPosition(i, i + subSize - 1));
            }
        }
        return result;
    }

    private int hash(String str) {
        int hash = 0;
        int base = 256;
        int prime = 101;
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            hash += (c * base) % prime;
        }
        return hash;
    }

    private boolean checkEquals(String str, int[] cache) {
        int[] local = buildCache(str);

        for (int i = 0; i < str.length(); ++i) {
            if (local[str.charAt(i)] != cache[str.charAt(i)]) {
                return false;
            }
        }
        return true;
    }

    private int[] buildCache(String str) {
        int[] cache = new int[256];
        for (int i = 0; i < str.length(); ++i) {
            cache[str.charAt(i)] += 1;
        }
        return cache;
    }

    static class SubStringPosition {
        int initial;
        int end;

        public SubStringPosition(int ini, int end) {
            this.initial = ini;
            this.end = end;
        }
    }
}
