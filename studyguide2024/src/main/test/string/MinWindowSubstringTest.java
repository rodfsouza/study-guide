package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinWindowSubstringTest {

    @Test
    public void TestMinWindow() {
        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindowSubstring.minWindow(s, t);
        String k = "BANC";
        assertEquals(k, result);

        s = "a";
        t = "a";
        result = minWindowSubstring.minWindow(s, t);
        k = "a";
        assertEquals(k, result);

        t = "aa";
        k = "";
        result = minWindowSubstring.minWindow(s, t);
        assertEquals(k, result);
    }
}
