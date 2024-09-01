package array;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {

    private int minutes = 0;

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int freshOranges = 0;
        int minutes = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[] { row, col });
                } else if (grid[row][col] == 1) {
                    freshOranges++;
                }
            }
        }

        while (!queue.isEmpty() && freshOranges > 0) {
            int currSize = queue.size();
            minutes++;

            for (int i = 0; i < currSize; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : DIRECTIONS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (isValid(grid, newRow, newCol) && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[] { newRow, newCol });
                        freshOranges--;
                    }
                }
            }
        }

        return freshOranges != 0 ? -1 : minutes;
    }

    public int orangesRotting2(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (!visited[row][col] && grid[row][col] == 2) {
                    rot(grid, row, col, visited);
                }
            }
        }

        return minutes;
    }

    private void rot(int[][] grid, int row, int col, boolean[][] visited) {
        if (!isValid(grid, row, col) || visited[row][col] || grid [row][col] == 0) {
            return;
        }

        visited[row][col] = true;
        if (grid[row][col] == 1) {
            grid[row][col] = 2;
            minutes++;
        }

        rot(grid, row, col + 1, visited);
        rot(grid, row, col - 1, visited);
        rot(grid, row + 1, col, visited);
        rot(grid, row - 1, col, visited);
    }

    private boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
    }
}
