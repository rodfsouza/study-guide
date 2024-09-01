package string;

import java.util.Stack;

public class ReverseBrackets {

    public String reverse(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }

        char[] toBeReversed = s.toCharArray();
        Stack<Integer> positions = new Stack<>();
        boolean foundOpen = false;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '{') {
                positions.push(i);
                foundOpen = true;
            } else if (c == '}') {
                if (positions.isEmpty()) {
                    throw new IllegalStateException("Missing open bracket");
                } else {
                    int iniPos = positions.pop();
                    reverseHelper(toBeReversed, iniPos + 1, i - 1);
                }
            }
        }

        if (!foundOpen) {
            throw new IllegalStateException("Missing open bracket");
        }

        if (!positions.isEmpty()) {
            throw new IllegalStateException("Missing close bracket");
        }

        StringBuilder sb = new StringBuilder();
        for (char c : toBeReversed) {
            if (c == '{' || c == '}') {
                continue;
            }
            sb.append(c);
        }

        return sb.toString();
    }

    private void reverseHelper(char[] toBeReversed, int iniPos, int endPos) {
        while (iniPos < endPos) {
            char temp = toBeReversed[iniPos];
            toBeReversed[iniPos] = toBeReversed[endPos];
            toBeReversed[endPos] = temp;
            iniPos++;
            endPos--;
        }
    }
}
