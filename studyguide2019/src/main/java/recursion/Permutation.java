package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public List<String> permute(String s) {
        List<String> permutations = new ArrayList<>();
        permute(s.toCharArray(), 0, new StringBuilder(), permutations);
        return permutations;
    }

    private void permute(char[] s, int ini, StringBuilder sb, List<String> res) {
        if (ini > s.length) {
            return;
        }

        if (s.length == sb.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = ini; i < s.length; ++i) {
            char c = swap(s, i, ini).charAt(i);
            sb.append(c);
            permute(s, i + 1, sb, res);
            swap(s, i, ini);
        }
    }

    private String swap(char[] s, int ini, int end) {
        char temp = s[end];
        s[end] = s[ini];
        s[ini] = temp;
        return new String(s);
    }
}
