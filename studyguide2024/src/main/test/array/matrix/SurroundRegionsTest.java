package array.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SurroundRegionsTest {

    @Test
    public void testSurroundRegions() {
        char[][] board = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        SurroundRegions sr = new SurroundRegions();
        sr.solve(board);

        char[][] expected = new char[][] {{'X','X','X','X'},{'X','X','X','X'},{'X','X','X','X'},{'X','O','X','X'}};
        assertArrayEquals(expected, board);
    }
}
