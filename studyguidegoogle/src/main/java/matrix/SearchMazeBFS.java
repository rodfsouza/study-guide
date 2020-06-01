package matrix;

import java.util.ArrayDeque;
import java.util.Queue;

public class SearchMazeBFS {

    private int ROW;
    private int COL;

    private int[][] maze;

    // These arrays are used to get row and column
    // numbers of 4 neighbors of a given cell
    private int[] rowNum = new int[] { -1, 0, 0, 1 };
    private int[] colNum = new int[] { 0, -1, 1, 0 };

    public SearchMazeBFS(final int[][] maze) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            throw new IllegalArgumentException();
        }

        ROW = maze.length;
        COL = maze[0].length;
        this.maze = maze;
    }

    public static class Point {
        int row;
        int col;

        Point(final int row, final int col) {
            this.row = row;
            this.col = col;
        }
    }

    private class Vertex {
        Point point;
        int distance;

        Vertex(Point p, int distance) {
            this.point = p;
            this.distance = distance;
        }
    }

    private boolean isValidMove(int row, int col) {
        return (row >= 0 && row < ROW) && (col >= 0 && col < COL);
    }

    public int calculateDistance(final Point source, final Point destination) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException();
        }

        boolean[][] visited = new boolean[ROW][COL];
        visited[source.row][source.col] = true;

        Queue<Vertex> q = new ArrayDeque<Vertex>();
        Vertex initial = new Vertex(source, 0);
        q.offer(initial);

        while (!q.isEmpty()) {
            Vertex current = q.poll();
            Point p = current.point;

            if (p.row == destination.row && p.col == destination.col) {
                return current.distance;
            }

            for(int i = 0; i < rowNum.length; i++) {
                int nextRow = p.row + rowNum[i];
                int nextCol = p.col + colNum[i];

                if (isValidMove(nextRow, nextCol) && maze[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    Vertex edge = new Vertex(new Point(nextRow, nextCol), current.distance + 1);
                    q.offer(edge);
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
