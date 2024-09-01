package string;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char open =  stack.peek();
                if (c == ')' && open != '(' || c == ']' && open != '[' || c == '}' && open != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
