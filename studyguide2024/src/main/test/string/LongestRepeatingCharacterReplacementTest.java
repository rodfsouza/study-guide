package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestRepeatingCharacterReplacementTest {

    @Test
    public void testCharacterReplacementSuccess() {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        String s = "AABABBA";
        int k = 1;
        assertEquals(4, longestRepeatingCharacterReplacement.characterReplacement(s, k));
    }

    @Test
    public void testCharacterReplacementSuccess2() {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        String s = "ABAB";
        int k = 2;
        assertEquals(4, longestRepeatingCharacterReplacement.characterReplacement(s, k));
    }
}
