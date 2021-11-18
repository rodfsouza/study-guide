package array;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixColor {

    private int[][] DIRS = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public void flipColorDfs(boolean[][] matrix, int row, int col) {

        boolean color = matrix[row][col];
        matrix[row][col] = !color;

        for (int[] dir : DIRS) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if (isFeasible(matrix, nextRow, nextCol) && matrix[nextRow][nextCol] == color) {
                flipColorDfs(matrix, nextRow, nextCol);
            }
        }
    }

    public void flipColor(boolean[][] matrix, int row, int col) {

        boolean currColor = matrix[row][col];
        Queue<Point> queue = new LinkedList<>();
        matrix[row][col] = !currColor;
        queue.offer(new Point(row, col));

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            for (int[] dir : DIRS) {
                Point next = new Point(curr.row + dir[0], curr.col + dir[1]);
                if (isFeasible(matrix, next.row, next.col) && matrix[next.row][next.col] == currColor) {

                    matrix[next.row][next.col] = !currColor;
                    queue.offer(next);
                }
            }

            queue.remove();
        }
    }

    private boolean isFeasible(boolean[][] matrix, int row, int col) {
        return row >=0 && row < matrix.length
                && col >= 0 && col < matrix[0].length;
    }

    private static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
