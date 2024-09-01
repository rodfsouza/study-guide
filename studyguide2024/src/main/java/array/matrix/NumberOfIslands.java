package array.matrix;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numberOfIslands = 0;

        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[0].length; ++col) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    dfs(grid, row, col, visited);
                    numberOfIslands++;
                }
            }
        }

        return numberOfIslands;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if (!isValid(grid, row, col) || visited[row][col] || grid[row][col] == '0') {
            return;
        }

        visited[row][col] = true;

        dfs(grid, row, col + 1, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row - 1, col, visited);
    }

    private boolean isValid(char[][] grid, int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
    }
}
