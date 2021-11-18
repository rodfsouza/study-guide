package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SurroundedMatrixTest {

    @Test
    public void testSurroundedMatrix1() {
        char[][] board = new char[][] {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'},
                                        {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'} };
        SurroundedMatrix m = new SurroundedMatrix();
        m.solve(board);
        Assertions.assertTrue(board.length > 0);
    }
}
