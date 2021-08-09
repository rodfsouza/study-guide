package array;

import java.util.*;

public class LetterCombinations {

    private static Map<Character, List<Character>> numberToLetters = new HashMap<>();

    static {
        numberToLetters.put('0', new ArrayList<>());
        numberToLetters.put('1', new ArrayList<>());
        numberToLetters.put('2', Arrays.asList('a', 'b', 'c'));
        numberToLetters.put('3', Arrays.asList('d', 'e', 'f'));
        numberToLetters.put('4', Arrays.asList('g', 'h', 'i'));
        numberToLetters.put('5', Arrays.asList('j', 'k', 'l'));
        numberToLetters.put('6', Arrays.asList('m', 'n', 'o'));
        numberToLetters.put('7', Arrays.asList('p', 'q', 'r', 's'));
        numberToLetters.put('8', Arrays.asList('t', 'u', 'v'));
        numberToLetters.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> results = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        combine(digits, digits.length(), "", visited, results);

        return results;
    }

    private void combine(String sub, int originalSize, String letter, Set<String> visited, List<String> results) {

        for (int i = 0; i < sub.length(); ++i) {
            for (Character c : numberToLetters.get(sub.charAt(i))) {
                String appended = letter + c;

                int subSize = i + 1;
                if (!visited.contains(appended) && subSize <= sub.length()) {
                    visited.add(appended);
                    combine(sub.substring(subSize), originalSize, appended, visited, results);

                    if (appended.length() == originalSize) {
                        results.add(appended);
                    }
                }
            }
        }
    }
}
