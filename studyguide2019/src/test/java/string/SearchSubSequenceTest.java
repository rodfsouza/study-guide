package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchSubSequenceTest {

    @Test
    public void testSearchSubSequenceSucess() {
        String txt = "hiremeinmongodb";
        String sub = "mdb";

        SearchSubSequence search = new SearchSubSequence();
        boolean result = search.isSubSequence(txt, sub);
        Assertions.assertTrue(result);
    }

    @Test
    public void testSearchSubSequenceFalse() {
        String txt = "hiremeinmongodb";
        String sub = "adb";

        SearchSubSequence search = new SearchSubSequence();
        boolean result = search.isSubSequence(txt, sub);
        Assertions.assertFalse(result);
    }

    @Test
    public void testSearchSubSequenceFalse2() {
        //"aaaaaa"
        //"bbaaaa"
        String txt = "bbaaaa";
        String sub = "aaaaaa";

        SearchSubSequence search = new SearchSubSequence();
        boolean result = search.isSubSequence(txt, sub);
        Assertions.assertFalse(result);
    }

    @Test
    public void testSearchSubSequenceFalse3() {
        String txt = "";
        String sub = "";

        SearchSubSequence search = new SearchSubSequence();
        boolean result = search.isSubSequence(txt, sub);
        Assertions.assertTrue(result);
    }

    @Test
    public void testSearchSubSequenceSucess2() {
        String txt = "a";
        String sub = "a";

        SearchSubSequence search = new SearchSubSequence();
        boolean result = search.isSubSequence(txt, sub);
        Assertions.assertTrue(result);
    }

    @Test
    public void testSearchSubSequenceSucess3() {
        String txt = "a";
        String sub = "";

        SearchSubSequence search = new SearchSubSequence();
        boolean result = search.isSubSequence(txt, sub);
        Assertions.assertTrue(result);
    }
}
