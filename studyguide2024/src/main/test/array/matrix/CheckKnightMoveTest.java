package array.matrix;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckKnightMoveTest {

    @Test
    public void testNextPossibleMoves() {
        CheckKnightMove checkKnightMove = new CheckKnightMove();
        int[][] board = new int[8][8];
        List<int[]> positions = checkKnightMove.nextPossibleMoves(board, 0, 0);
        assertEquals(2, positions.size());
        assertArrayEquals(new int[]{2, 1}, positions.get(0));
        assertArrayEquals(new int[]{1, 2}, positions.get(1));
    }
}
