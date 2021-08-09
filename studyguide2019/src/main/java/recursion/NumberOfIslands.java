package recursion;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {

    public int countIslands(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int numberOfIslands = 0;

        for (int row = 0; row < matrix.length; ++row) {
            for(int col = 0; col < matrix[0].length; ++col) {

                if (matrix[row][col] == 1 && !visited[row][col]) {
                    explore(matrix, row, col, visited);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    private void explore(int[][] matrix, int row, int col, boolean[][] visited) {
        if (isInValid(matrix, row, col) || visited[row][col] || matrix[row][col] == 0) {
            return;
        }

        visited[row][col] = true;

        explore(matrix, row, col + 1, visited);
        explore(matrix, row + 1, col, visited);
        explore(matrix, row, col - 1, visited);
        explore(matrix, row - 1, col, visited);
    }

    private boolean isInValid(int[][] matrix, int row, int col) {
        return row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length;
    }
}
