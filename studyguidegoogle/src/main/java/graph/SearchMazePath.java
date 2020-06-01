package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchMazePath {

    public enum Color {BLACK, WHITE}

    public List<Coordinate> containsPath(List<List<Color>> maze, Coordinate initial, Coordinate end) {
        if (maze == null || maze.isEmpty()) {
            return null;
        }

        List<Coordinate> paths = new ArrayList<>();
        maze.get(initial.x).set(initial.y, Color.BLACK);
        paths.add(initial);

        if (!hasPath(maze, initial, end, paths)) {
            paths.remove(paths.size() - 1 );
        }

        return paths;
    }

    private boolean hasPath(List<List<Color>> maze, Coordinate cur, Coordinate e, List<Coordinate> paths) {
        if (cur.equals(e)) {
            return true;
        }

        final int[][] SHIFT = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        for (int[] s: SHIFT) {
            Coordinate next = new Coordinate(cur.x + s[0], cur.y + s[1]);

            if (isFeasibleToWalk(maze, next)) {
                maze.get(next.x).set(cur.y, Color.BLACK);
                paths.add(next);

                if (hasPath(maze, next, e, paths)) {
                    return true;
                }
                paths.remove(paths.size() - 1);
            }
        }
        return false;
    }

    private boolean isFeasibleToWalk(List<List<Color>> maze, Coordinate nextPosition) {
        return nextPosition.x <= maze.size() && nextPosition.y <= maze.get(0).size() &&
            maze.get(nextPosition.x).get(nextPosition.y) == Color.WHITE;
    }

    public class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
