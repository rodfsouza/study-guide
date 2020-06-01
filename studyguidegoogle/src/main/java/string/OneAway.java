package string;

import java.util.HashSet;
import java.util.Set;

public class OneAway {

    public boolean isOneAway(final String s, final String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return false;
        }

        Set uniques = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            uniques.add(s.charAt(i));
        }

        int countNotFound = 0;
        for (int j = 0; j < s.length(); j++) {
            if (j < t.length() && uniques.contains(t.charAt(j))) {
                continue;
            }
            countNotFound++;
        }

        return countNotFound == 1;
    }
}
