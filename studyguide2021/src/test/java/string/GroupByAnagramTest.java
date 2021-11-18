package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GroupByAnagramTest {

    @Test
    public void testGroupByAnagram() {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupByAnagrams grp = new GroupByAnagrams();
        List<List<String>> results = grp.groupAnagrams(strs);
        Assertions.assertFalse(results.isEmpty());
    }
}
