package string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class URLifyTest {

    private URLify url;

    @BeforeEach
    public void setup() {
        url = new URLify();
    }

    @Test
    public void testToUrl() {
        String expected = "Mr%20John%20Smith";
        assertEquals(expected, url.toUrl("Mr John Smith"));
    }

    @Test
    public void testToUrlNoSpaces() {
        final String noSpaces = "Mr%20John%20Smith";
        assertEquals(noSpaces, url.toUrl(noSpaces));
    }

    @Test
    public void testToUrlEmptyString() {
        assertEquals("", url.toUrl(""));
    }
}
