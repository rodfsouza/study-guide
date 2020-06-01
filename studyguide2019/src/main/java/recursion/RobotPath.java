package recursion;

import java.util.*;

public class RobotPath {

    public static class Point {
        int row;
        int col;

        public Point(int r, int c) {
            row = r;
            col = c;
        }
    }

    public List<Point> findPath(int[][] matrix) {
        if (matrix == null) {
            return new ArrayList<>();
        }

        List<Point> coordinates = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[0].length; ++col) {
                if (!visited[row][col] && matrix[row][col] == 1) {
                    helper(matrix, row, col, coordinates, visited);
                }
            }
        }
        return coordinates;
    }

    private void helper(int[][] matrix, int r, int c, List<Point> coordinates, boolean[][] visited) {
        if (!isValid(matrix, r, c) || visited[r][c] || matrix[r][c] == 0) {
            return;
        }

        visited[r][c] = true;
        helper(matrix, r + 1, c, coordinates, visited);
        helper(matrix, r, c + 1, coordinates, visited);
        coordinates.add(new Point(r, c));
    }

    boolean isValid(int[][] matrix, int r, int c) {
        return r >= 0 && c >= 0 && r <= matrix.length - 1 && c <= matrix[0].length - 1;
    }

}
