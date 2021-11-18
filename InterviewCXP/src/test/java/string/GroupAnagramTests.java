package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagramTests {

    //Array of words: [cat, study, elbow, stress, act, elvis, debitcard, below, dusty, listen, badcredit, rodrigo]
//All the word are anagram
//Output: {[cat, act], [study, dusty], [elbow, below], [debitcard, badcredit]}

    @Test
    public void test1() {
        List<String> input = Arrays.asList("cat", "act", "study", "dusty", "elbow", "stress", "elvis", "debitcard",
                "below", "listen", "badcredit", "rodrigo");

        List<List<String>> expected = new ArrayList<>();

        List<String> a = Arrays.asList("cat", "act");
        List<String> c = Arrays.asList("elbow", "below");
        List<String> d = Arrays.asList("debitcard", "badcredit");
        List<String> b = Arrays.asList("study", "dusty");
        expected.add(a);
        expected.add(b);
        expected.add(c);
        expected.add(d);

        GroupAnagram s = new GroupAnagram();
        List<List<String>> result = s.groupBy(input);
        Assertions.assertIterableEquals(expected, result);
    }
}
