package string;

import java.util.*;

/**
 * Find whether S2 is one Edit away of S1, one edit can be:
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Runtime: O (m + n) - Where n is S1 and m is S2
 * Space: O(m + n) - Worst case will store the whole S2.
 */
public class OneEditAway {

    public boolean oneEdit(String s1, String s2) {
        Map<Character, Integer> existOnFirst = new HashMap<>();

        for (int i = 0; i < s1.length(); ++i) {
            Character c = s1.charAt(i);
            if (existOnFirst.containsKey(c)) {
                int ocurrence = existOnFirst.get(c);
                existOnFirst.put(c, ++ocurrence);
                continue;
            }
            existOnFirst.put(c, 1);
        }
        List<Character> notExistOnFirst = new ArrayList<>();
        for (int i = 0; i < s2.length(); ++i) {
            Character c = s2.charAt(i);
            if (!existOnFirst.containsKey(c)) {
                notExistOnFirst.add(c);
            }
        }
        return notExistOnFirst.size() == 0 || notExistOnFirst.size() == 1;
    }

    /**
     * Find whether S2 is one Edit away of S1, one edit can be:
     * Insert a character
     * Delete a character
     * Replace a character
     *
     * Runtime: O (n)
     * Space: O(1)
     */
    public boolean OneEdit2(String s1, String s2) {
        int edits = 0;
        int s1Pos = 0;
        int s2Pos = 0;

        while(s1Pos < s1.length() && s2Pos < s2.length()) {
            if (s1.charAt(s1Pos) != s2.charAt(s2Pos)) {

                if (!(edits == 0 || edits == 1)) {
                    return false;
                }

                if (s1.length() > s2.length()) {
                    s1Pos++;
                } else if (s2.length() > s1.length()) {
                    s2Pos++;
                } else {
                    s1Pos++;
                    s2Pos++;
                }
                edits++;
            } else {
                s1Pos++;
                s2Pos++;
            }
        }

        if (s1Pos < s1.length() || s2Pos < s2.length()) {
            edits++;
        }
        return edits == 0 || edits == 1;
    }
}
