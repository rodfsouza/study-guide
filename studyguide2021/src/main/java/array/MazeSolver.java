package array;

public class MazeSolver {

  public boolean solve(int[][] maze) {
    if (maze == null || maze.length == 0) {
      return true;
    }

    boolean[][] visited = new boolean[maze.length][maze[0].length];
    for (int row = 0; row < maze.length; ++row) {

      for (int col = 0; col < maze[0].length; ++col) {
        if (!visited[row][col] && traverse(maze, visited, row, col)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean traverse(int[][] maze, boolean[][] visited, int row, int col) {
    if (isInValid(maze, row, col) || visited[row][col]) {
      return false;
    }

    visited[row][col] = true;

    return traverse(maze, visited, row + 1, col)
        && traverse(maze, visited, row, col + 1)
        && traverse(maze, visited, row - 1, col)
        && traverse(maze, visited, row, col -1);
  }

  private boolean isInValid(int[][] maze, int row, int col) {
    return row < 0 || col < 0 || row >= maze.length || col >= maze[0].length;
  }
}
