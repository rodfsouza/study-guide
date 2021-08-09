package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LetterCombinationsTest {

    @Test
    public void letterCombinationTest1() {
        LetterCombinations lc = new LetterCombinations();
        List<String> results = lc.letterCombinations("23");
        Assertions.assertFalse(results.isEmpty());
        Assertions.assertTrue(results.size() == 9);
    }

    @Test
    public void letterCombinationTestEmpty() {
        LetterCombinations lc = new LetterCombinations();
        List<String> results = lc.letterCombinations("");
        Assertions.assertTrue(results.isEmpty());
    }

    @Test
    public void letterCombinationTestOne() {
        LetterCombinations lc = new LetterCombinations();
        List<String> results = lc.letterCombinations("1");
        Assertions.assertTrue(results.isEmpty());
    }

    @Test
    public void letterCombinationTestSingleDigit() {
        LetterCombinations lc = new LetterCombinations();
        List<String> results = lc.letterCombinations("2");
        Assertions.assertFalse(results.isEmpty());
        Assertions.assertTrue(results.size() == 3);
    }

    @Test
    public void letterCombinationTestMultiDigit() {
        LetterCombinations lc = new LetterCombinations();
        List<String> results = lc.letterCombinations("234");
        Assertions.assertFalse(results.isEmpty());
        Assertions.assertTrue(results.size() == 27);
    }

    @Test
    public void letterCombinationTestMultiDigit2() {
        LetterCombinations lc = new LetterCombinations();
        List<String> results = lc.letterCombinations("2345");
        Assertions.assertFalse(results.isEmpty());
        Assertions.assertTrue(results.size() == 81);
    }
}
