package matrix;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by rodsou on 7/11/17.
 */
public class SearchMazeBFS {
    private int ROW;
    private int COL;

    // These arrays are used to get row and column
    // numbers of 4 neighbors of a given cell
    private int[] rowNum = new int[] { -1, 0, 0, 1 };
    private int[] colNum = new int[] { 0, -1, 1, 0 };

    public SearchMazeBFS(int[][] maze) {
        this.ROW = maze.length;
        this.COL = maze[0].length;
    }

    public static class Point {
        private int x;
        private int y;

        public Point(int row, int col) {
            this.x = row;
            this.y = col;
        }
    }

    public class Node {
        Point source;
        int distance;

        public Node(final Point source, int distance) {
            this.source = source;
            this.distance = distance;
        }
    }

    public boolean isValid(int row, int col) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
    }

    int BFS(int[][] maze, final Point source, final Point destination) {
        if (maze[source.x][source.y] == 0 || maze[destination.x][destination.y] == 0) {
            return Integer.MAX_VALUE;
        }

        boolean[][] visited = new boolean[ROW][COL];
        visited[source.x][source.y] = true;

        Queue<Node> queue = new ArrayDeque<>();
        Node src = new Node(source, 0);
        queue.add(src);

        while (!queue.isEmpty()) {
            Node curr = queue.peek();
            Point point = curr.source;

            if (point.x == destination.x && point.y == destination.y) {
                return curr.distance;
            }

            queue.poll();

            for (int i = 0; i < 4; i++) {
                int row = point.x + rowNum[i];
                int col = point.y + colNum[i];

                if (isValid(row, col) && maze[row][col] == 1 && !visited[row][col]) {
                    visited[row][col] = true;
                    Node adjCell = new Node(new Point(row, col), curr.distance + 1);
                    queue.add(adjCell);
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}