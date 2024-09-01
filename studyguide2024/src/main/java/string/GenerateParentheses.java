package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public String generate(int n) {
        List<String> results = new ArrayList<>();
        helper("", n, 0, 0, results);

        StringBuilder sb = new StringBuilder();
        for (String s : results) {
            sb.append(s);
        }

        return sb.toString();
    }

    private void helper(String sb, int number, int open, int close, List<String> results) {
        if (open == close && open + close == number * 2) {
            results.add(sb);
            return;
        }

        if (open < number) {
            helper(sb + "(", number, open + 1, close, results);
        }

        if (close < open) {
            helper(sb + ")", number, open, close + 1, results);
        }
    }
}
