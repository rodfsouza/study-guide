package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ReverseWords2Test {

    private static ReverseWords2 rw;

    @BeforeAll
    public static void init() {
        rw = new ReverseWords2();
    }

    @Test
    public void testReverseWordsWithDoubleSpaces() {
        String[] input = {"ignore", "abc", "def", "cat"};
        String reversed = rw.reverse(input);
        Assertions.assertEquals("tac fed cba", reversed);
    }
}
