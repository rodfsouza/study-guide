package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: O (n!) - Where n is the size of string.
 * Why? Because, for each string permutation we do i.e. 4 * 3 * 2 * 1 = 24
 */
public class Permutation2 {

    public List<String> permute(String s) {
        List<String> result = new ArrayList<>();
        permute("", s, result);
        return result;
    }

    private void permute(String prefix, String remainder, List<String> result) {
        if (remainder.length() == 0) {
            result.add(prefix);
        }

        for (int i = 0; i < remainder.length(); ++i) {
            char c = remainder.charAt(i);
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, remainder.length());
            permute(prefix + c, before + after, result);
        }
    }
}
