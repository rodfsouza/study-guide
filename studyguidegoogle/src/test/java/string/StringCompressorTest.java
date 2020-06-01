package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCompressorTest {

    private StringCompressor compressor;

    @BeforeEach
    public void setup() {
        compressor = new StringCompressor();
    }

    @Test
    public void testStringCompressor() {
        final String expected = "a2b1c5a3";
        Assertions.assertEquals(expected,compressor.compress("aabcccccaaa" ));
    }

    @Test
    public void testStringCompressorSameString() {
        final String expected = "abcdefg";
        Assertions.assertEquals(expected, compressor.compress(expected));
    }

    @Test
    public void testStringCompressorLargeString() {
        final String expected = "a5b5c4d5e6";
        Assertions.assertEquals(expected, compressor.compress("aaaaabbbbbccccdddddeeeeee"));
    }
}
