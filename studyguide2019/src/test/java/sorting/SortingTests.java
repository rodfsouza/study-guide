package sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class SortingTests {

    @Test
    public void testCountAnagram() {

        List<String> words = new LinkedList<>();
        words.add("tea");
        words.add("ate");
        words.add("key");
        words.add("banana");

        GroupAnagrams anagrams = new GroupAnagrams();
        int grouped = anagrams.groupBy(words);
        int group = anagrams.groupByCount(words);
        Assertions.assertEquals(2, grouped);
        Assertions.assertEquals(2, group);
    }

    @Test
    public void testQuickSortIterative() {
        int arr[] = {4, 3, 5, 2, 1, 3, 2, 3};
        QuickSort quickSort = new QuickSort();
        quickSort.sortIterative(arr, 0, arr.length -1);
    }
}
