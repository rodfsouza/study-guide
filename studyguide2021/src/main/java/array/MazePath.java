package array;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static array.MazePath.Color.*;

public class MazePath {

    public enum Color {BLACK, WHITE};

    private int[][] DIRS = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public List<Coordinate> containsPath(Color[][] maze, Coordinate start, Coordinate exit) {

        LinkedList<Coordinate> path = new LinkedList<>();
        maze[start.row][start.col] = BLACK;
        path.addLast(start);

        if (!dfsHelper(maze, start, exit, path)) {
            path.removeLast();
        }

        return path;
    }

    private boolean dfsHelper(Color[][] maze, Coordinate cur, Coordinate exit, LinkedList<Coordinate> path) {

        if (cur.equals(exit)) {
            return true;
        }

        for(int[] dir : DIRS) {
            Coordinate next = new Coordinate(cur.row + dir[0], cur.col + dir[1]);

            if (isFeasible(maze, next.row, next.col) && maze[next.row][next.col] == WHITE) {
                maze[next.row][next.col] = BLACK;
                path.addLast(next);

                if (dfsHelper(maze, next, exit, path)) {
                    return true;
                }

                path.removeLast();
            }
        }
        return false;
    }

    private boolean isFeasible(Color[][] maze, int row, int col) {
        return row >= 0 && row < maze.length
                && col >= 0 && col < maze[0].length;
    }

    public static class Coordinate {
        int row;
        int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Coordinate that = (Coordinate) o;
            return row == that.row && col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
