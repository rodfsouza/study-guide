package stack;

import linkedlist.SinglyNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class StackListTest {

    private StackList<Integer> stack;

    @BeforeEach
    public void setup() {
        stack = new StackList<>();

        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(10);
    }

    @Test
    public void testStackMax() {
        Assertions.assertEquals(10, (int) stack.max());
    }

    @Test
    public void testStackPop() {
        Assertions.assertEquals(10, (int) stack.pop());
        Assertions.assertEquals(2, (int) stack.pop());
    }

    @Test
    public void testStackPopEmpty() {
        while (!stack.isEmpty()) {
            stack.pop();
        }

        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    public void testReversePolishEval() {
        String rpn = "2,3,*";
        Assertions.assertEquals(6, reversePolishEval(rpn, ","));
    }

    @Test
    public void testPolishEval() {
        String polish = "*,2,3";
        Assertions.assertEquals(6, polishEval(polish, ","));
    }

    @Test
    public void testWellFormed() {
        String valid = "([]){()}";
        String invalid = "{)";

        Assertions.assertTrue(isWellFormed(valid));
        Assertions.assertFalse(isWellFormed(invalid));
    }

    @Test
    public void testShortestPath() {
        String first = "/usr/lib/../bin/gcc";
        String shortestPath = shortestPath(first);
        Assertions.assertEquals("/usr/bin/gcc", shortestPath);

        String second = "scripts//./../scripts/awkscripts/././";
        shortestPath = shortestPath(second);
        Assertions.assertEquals("scripts/awkscripts", shortestPath);
    }

    @Test
    public void testSetJumpOrder() {
        SinglyNode<Integer> a = new SinglyNode<>();
        a.data = -1;

        SinglyNode<Integer> b = new SinglyNode<>();
        b.data = -1;


        SinglyNode<Integer> c = new SinglyNode<>();
        c.data = -1;

        SinglyNode<Integer> d = new SinglyNode<>();
        d.data = -1;

        a.next = b;
        b.next = c;
        c.next = d;

        a.jump = c;
        b.jump = d;
        c.jump = b;
        d.jump = d;

        setJumpOrder(a);
        Assertions.assertNotNull(a);
    }

    private int reversePolishEval(String rpnExpression, final String delimiter) {
        StackList<Integer> intermediateResults = new StackList<>();

        String[] splittedSymbols = rpnExpression.split(delimiter);

        for (String token : splittedSymbols) {
            if (token.length() == 1 && "+-*/".contains(token)) {
                int a = intermediateResults.pop();
                int b = intermediateResults.pop();

                switch (token.charAt(0)) {
                    case '+' :
                        intermediateResults.push(a + b);
                        break;
                    case '-' :
                        intermediateResults.push(a - b);
                        break;
                    case '*' :
                        intermediateResults.push(a * b);
                        break;
                    case '/' :
                        intermediateResults.push(a / b);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            } else {
                intermediateResults.push(Integer.parseInt(token));
            }
        }
        return intermediateResults.pop();
    }

    private int polishEval(String polish, final String delimiter) {
        StackList<Integer> numbers = new StackList<>();
        StackList<Character> operands = new StackList<>();
        StackList<Integer> intermediateResults = new StackList<>();

        String supportedOperations = "+-*/";

        String[] splittedNotations = polish.split(delimiter);

        for (String token : splittedNotations) {
            if (token.length() == 1 && supportedOperations.contains(token)) {
                operands.push(token.charAt(0));
                continue;
            }

            numbers.push(Integer.parseInt(token));
        }

        while (!numbers.isEmpty()) {
            int a = numbers.pop();
            int b = numbers.pop();

            Character operation = operands.pop();

            switch (operation) {
                case '+':
                    intermediateResults.push(a + b);
                    break;
                case '-':
                    intermediateResults.push(a - b);
                    break;
                case '*':
                    intermediateResults.push(a * b);
                    break;
                case '/':
                    intermediateResults.push(a / b);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return intermediateResults.pop();
    }

    private boolean isWellFormed(String s) {
        StackList<Character> foundLeftMatches = new StackList<>();

        for (int  i = 0; i < s.length(); i++) {
            Character token = s.charAt(i);

            if (token == '{' || token == '(' || token == '[') {
                foundLeftMatches.push(token);

            } else {
                if (foundLeftMatches.isEmpty()) {
                    return false;
                }

                if ((token == '}' && foundLeftMatches.peek() != '{')
                    || (token == ')' && foundLeftMatches.peek() != '(')
                    || token == ']' && foundLeftMatches.peek() != '[') {
                    return false;
                }

                foundLeftMatches.pop();
            }
        }

        return foundLeftMatches.isEmpty();
    }

    private String shortestPath(String path) {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException();
        }

        StackList<String> paths = new StackList<>();

        if (path.charAt(0) == '/') {
            paths.push("/");
        }

        for (String token : path.split("/")) {
            if (token.isEmpty() || token.equals(".")) {
                continue;
            }

            if (token.equals("..")) {
                if (paths.isEmpty() || paths.peek().equals("..")) { //first .. or double one like /../../
                    paths.push(token);
                } else {
                    if (paths.peek().equals("/")) { //Illegal to back up
                        throw new IllegalStateException("Illegal path string");
                    }
                    paths.pop();
                }
            } else {
                paths.push(token);
            }
        }

        StackList<String> revert = new StackList<>();
        while (!paths.isEmpty()) {
            revert.push(paths.pop());
        }

        StringBuilder resultBuilder = new StringBuilder();
        while (!revert.isEmpty()) {
            String token = revert.pop();

            if (token.equals("/")) {
                continue;
            }

            resultBuilder.append("/" + token);
        }

        return resultBuilder.toString();
    }

    private void setJumpOrder(SinglyNode<Integer> node) {
        setJumpOrder(node, 0);
    }

    private int setJumpOrder(SinglyNode<Integer> node, int order) {
        if (node != null && node.data == -1) {
            node.data = order++;
            setJumpOrder(node.jump, order);
            setJumpOrder(node.next, order);
        }
        return order;
    }

    private void setJumpOrderIteratively(SinglyNode<Integer> node) {
        if (node == null) {
            return;
        }

        Deque<SinglyNode<Integer>> stack = new LinkedList<>();
        stack.addFirst(node);

        int order = 0;

        while(!stack.isEmpty()) {
            SinglyNode<Integer> current = stack.removeFirst();

            if (current != null && current.data == -1) {
                current.data = order++;
                stack.addFirst(current.next);
                stack.addFirst(current.jump);
            }
        }
    }
}
