package string;

import java.util.LinkedList;

public class ReverseWords {

    public String reverseWords(String s) {

        if (s == null || s.length() == 0) {
            return null;
        }

        LinkedList<String> stack = new LinkedList<>();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {

            if (s.charAt(i) == ' ') {

                if (word.length() > 0) {
                    stack.addFirst(word.toString());
                    word = new StringBuilder();
                }

            } else {
                word.append(s.charAt(i));
            }
        }

        if (word.length() > 0) {
            stack.addFirst(word.toString());
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        return sb.toString().trim();
    }
}
