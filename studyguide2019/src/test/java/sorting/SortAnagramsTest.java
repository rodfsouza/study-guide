package sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortAnagramsTest {

    @Test
    public void test1() {
/*        List<String> input = Arrays.asList("abc", "def", "cab", "fed");
        List<String> expected = Arrays.asList("abc", "cab", "def", "fed");

        SortAnagrams s = new SortAnagrams();
        List<String> result = s.groupBy(input);
        Assertions.assertEquals(expected, result);*/
    }

    @Test
    public void test2() {
/*        List<String> input = Arrays.asList("abc", "def", "cab", "fed", "aabc");
        List<String> expected = Arrays.asList("aabc", "abc", "cab", "def", "fed");

        SortAnagrams s = new SortAnagrams();
        List<String> result = s.groupBy(input);
        Assertions.assertEquals(expected, result);*/
    }

    @Test
    public void test3() {
        List<String> input = Arrays.asList("cat", "act", "study", "dusty");
        List<List<String>> expected = Arrays.asList();

        List<String> a = Arrays.asList("cat", "act");
        List<String> b = Arrays.asList("study", "dusty");
        expected.add(a);
        expected.add(b);

        SortAnagrams s = new SortAnagrams();
        List<List<String>> result = s.groupBy(input);
        Assertions.assertEquals(expected, result);
    }
}
