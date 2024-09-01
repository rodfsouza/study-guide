package array;

import org.junit.jupiter.api.Test;

public class FindElementWithHighestFrequencyTest {

    @Test
    public void ShouldReturnNumberWithHighestFrequency() {
        FindElementWithHighestFrequency findElementWithHighestFrequency = new FindElementWithHighestFrequency();
        assert findElementWithHighestFrequency.find(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 1, 1, 1, 1, 1, 1, 1}) == 1;
        assert findElementWithHighestFrequency.find(new int[] {1, 2, 2, 3, 4, 4, 4, 4, 4, 5, 5, 5}) == 4;
        assert findElementWithHighestFrequency.find(new int[] {1, 2, 2, 2, 3, 3, 3, 4, 5}) == 2;
        assert findElementWithHighestFrequency.find(new int[] {1, 1, 1, 1, 1}) == 1;
        assert findElementWithHighestFrequency.find(new int[] {1}) == 1;
    }
}
