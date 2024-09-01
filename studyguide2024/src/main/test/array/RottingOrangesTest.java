package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RottingOrangesTest {

    @Test
    public void testOrangesRotting() {
        RottingOranges ro = new RottingOranges();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int result = ro.orangesRotting(grid);
        assertEquals(4, result);
    }
}
