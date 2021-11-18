package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GroupByAnagrams2Test {

    @Test
    public void testGroupByAnagram() {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupByAnagrams2 grp = new GroupByAnagrams2();
        List<List<String>> results = grp.groupAnagrams(strs);
        Assertions.assertFalse(results.isEmpty());
    }
}
