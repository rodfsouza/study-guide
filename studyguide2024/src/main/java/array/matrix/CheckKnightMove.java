package array.matrix;

import java.util.ArrayList;
import java.util.List;

public class CheckKnightMove {

    private static final int[][] MOVES = {
        {2, 1}, {1, 2}, {2, -1}, {1, -2},
        {-2, 1}, {-1, 2}, {-2, -1}, {-1, -2}
    };

    public List<int[]> nextPossibleMoves(int[][] board, int x, int y) {
        List<int[]> positions = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        exploreMoves(board, x, y, positions, visited);
        return positions;
    }

    private void exploreMoves(int[][] board, int x, int y, List<int[]> positions, boolean[][] visited) {
        if (!isValid(board, x, y) || visited[x][y] || board[x][y] == 1) {
            return;
        }

        positions.add(new int[]{x, y});
        visited[x][y] = true;

        for (int[] move : MOVES) {
            int nextX = x + move[0];
            int nextY = y + move[1];
            exploreMoves(board, nextX, nextY, positions, visited);
        }
    }

    private boolean isValid(int[][] board, int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }
}
