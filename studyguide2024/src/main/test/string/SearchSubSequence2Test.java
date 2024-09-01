package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchSubSequence2Test {

    @Test
    public void testSearchSubSequence2Sucess() {
        String txt = "hiremeinmongodb";
        String sub = "mdb";

        SearchSubSequence2 search = new SearchSubSequence2();
        boolean result = search.isSubSequence(sub, txt);
        Assertions.assertTrue(result);
    }

    @Test
    public void testSearchSubSequence2False() {
        String txt = "hiremeinmongodb";
        String sub = "adb";

        SearchSubSequence2 search = new SearchSubSequence2();
        boolean result = search.isSubSequence(sub, txt);
        Assertions.assertFalse(result);
    }

    @Test
    public void testSearchSubSequence2False2() {
        //"aaaaaa"
        //"bbaaaa"
        String txt = "bbaaaa";
        String sub = "aaaaaa";

        SearchSubSequence2 search = new SearchSubSequence2();
        boolean result = search.isSubSequence(sub, txt);
        Assertions.assertFalse(result);
    }

    @Test
    public void testSearchSubSequence2False3() {
        String txt = "";
        String sub = "";

        SearchSubSequence2 search = new SearchSubSequence2();
        boolean result = search.isSubSequence(sub, txt);
        Assertions.assertTrue(result);
    }

    @Test
    public void testSearchSubSequence2Sucess2() {
        String txt = "a";
        String sub = "a";

        SearchSubSequence2 search = new SearchSubSequence2();
        boolean result = search.isSubSequence(sub, txt);
        Assertions.assertTrue(result);
    }

    @Test
    public void testSearchSubSequence2Sucess3() {
        String txt = "a";
        String sub = "";

        SearchSubSequence2 search = new SearchSubSequence2();
        boolean result = search.isSubSequence(sub, txt);
        Assertions.assertTrue(result);
    }
}
