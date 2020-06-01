package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Runtime: O (n!)
 */
public class Parenteses {

    public List<String> parents(int n) {
        if (n <=0) {
            return Collections.emptyList();
        }

        char[] str = new char[n * 2];
        List<String> res = new ArrayList<>();
        parents(str, res, n, n, 0);
        return res;
    }

    private void parents(char[] str, List<String> res, int left, int right, int index) {
        if (left < 0 || right < left) {
            return;
        }

        if (left == 0 && right == 0) {
            res.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            parents(str, res, left - 1, right, index + 1);

            str[index] = ')';
            parents(str, res, left, right - 1, index + 1);
        }
    }
}
