package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReverseBracketsTest {

    @Test
    public void TestCases() {
        ReverseBrackets rb = new ReverseBrackets();
        assertEquals("hgfedcba", rb.reverse("{abc{fed}gh}"));
        assertEquals("cba", rb.reverse("{abc}"));
        assertEquals("abc", rb.reverse("{{abc}}"));
        assertEquals("abcfedgh", rb.reverse("abc{def}gh"));
        assertEquals("cba", rb.reverse("{{{abc}}}"));
        assertThrows(IllegalStateException.class, () -> rb.reverse("abc"));
        assertThrows(IllegalStateException.class, () -> rb.reverse("abc}"));
        assertThrows(IllegalStateException.class, () -> rb.reverse("{abc"));
        assertThrows(IllegalStateException.class, () -> rb.reverse("{{abc}"));
    }
}
