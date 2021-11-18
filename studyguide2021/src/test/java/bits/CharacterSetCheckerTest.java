package bits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Assert("010", 2);
Assert("111111101010101010", 2);
Assert("00", 1);
Assert("0011", 2);
Assert("0010101010111111", 2);
Assert("11111110110", 1);
 */

public class CharacterSetCheckerTest {

    private static CharacterSetChecker checker;

    @BeforeAll
    public static void init() {
        checker = new CharacterSetChecker();
    }

    @Test
    public void testCharacterSetChecker() {
        assertEquals(1, checker.isAsciiOrKanji("00"));
        assertEquals(2, checker.isAsciiOrKanji("11"));
        assertEquals(-1, checker.isAsciiOrKanji("01"));
        assertEquals(2, checker.isAsciiOrKanji("110"));
        //assertEquals(2, checker.isAsciiOrKanji("1010"));
        assertEquals(1, checker.isAsciiOrKanji("011110"));
    }
}
