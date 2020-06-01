package recursion;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {

    class Point {
        int row;
        int col;

        public Point(int r, int c) {
            row = c;
            col = c;
        }
    }

    public int countIslands(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        Set<Point> visited = new HashSet<>();
        int numberOfIslands = 0;

        for (int row = 0; row < matrix.length; ++row) {
            for(int col = 0; col < matrix[0].length; ++col) {

                if (matrix[row][col] == 1 && !visited.contains(new Point(row, col))) {
                    explore(matrix, row, col, visited);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    private void explore(int[][] matrix, int row, int col, Set<Point> visited) {
        if (!isValid(matrix, row, col) || visited.contains(new Point(row, col))) {
            return;
        }

        Point current = new Point(row, col);
        visited.add(current);

        explore(matrix, row, col + 1, visited);
        explore(matrix, row + 1, col, visited);
        explore(matrix, row, col - 1, visited);
        explore(matrix, row - 1, col, visited);
    }

    private boolean isValid(int[][] matrix, int row, int col) {
        return row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length;
    }
}
