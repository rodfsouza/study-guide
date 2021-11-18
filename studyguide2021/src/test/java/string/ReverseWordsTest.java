package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ReverseWordsTest {

    private static ReverseWords rw;

    @BeforeAll
    public static void init() {
        rw = new ReverseWords();
    }

    @Test
    public void testReverseWordsWithDoubleSpaces() {
        String input = "a good   example";
        String reversed = rw.reverseWords(input);
        Assertions.assertEquals("example good a", reversed);
    }

    @Test
    public void testReverseWordsSimpleSpaces() {
        String input = "the sky is blue";
        String reversed = rw.reverseWords(input);
        Assertions.assertEquals("blue is sky the", reversed);
    }

    @Test
    public void testReverseWordsSimpleAtEndSpaces() {
        String input = "  hello world  ";
        String reversed = rw.reverseWords(input);
        Assertions.assertEquals("world hello", reversed);
    }

    @Test
    public void testReverseWordsManySpaces() {
        String input = "  Bob    Loves  Alice   ";
        String reversed = rw.reverseWords(input);
        Assertions.assertEquals("Alice Loves Bob", reversed);
    }

    @Test
    public void testReverseWordsNoSpaces() {
        String input = "Alice does not even like bob";
        String reversed = rw.reverseWords(input);
        Assertions.assertEquals("bob like even not does Alice", reversed);
    }
}
