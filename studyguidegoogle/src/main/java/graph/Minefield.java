package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Minefield {

    enum Color {BLACK, WHITE}

    private static int[][] DIRS = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static void flipColorBfs(List<List<Color>> minefield, int x, int y) {
        if (minefield == null || minefield.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (x < 0 || y < 0 || x > minefield.size() ||y > minefield.get(x).size()) {
            throw new IllegalArgumentException();
        }

        Point initial = new Point(x, y);
        minefield.get(x).set(y, flip(minefield.get(x).get(y)));

        Queue<Point> visiting = new LinkedList<>();
        visiting.offer(initial);

        while (!visiting.isEmpty()) {
            Point cur = visiting.poll();

            for (int[] dir : DIRS) {
                Point next = new Point(cur.x + dir[0], cur.y + dir[1]);
                if (isFeasibleToWalk(minefield, next, minefield.get(cur.x).get(cur.y))) {
                    minefield.get(next.x).set(next.y, flip(minefield.get(next.x).get(next.y)));
                    visiting.offer(next);
                }
            }
            visiting.remove();
        }
    }


    public static void flipColor(List<List<Color>> minefield, int x, int y) {
        if (minefield == null || minefield.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Point initial = new Point(x, y);
        flipColor(minefield, initial);
    }


    private static void flipColor(List<List<Color>> minefield, Point next) {

        Color initialColor = minefield.get(next.x).get(next.y);
        minefield.get(next.x).set(next.y, flip(initialColor));

        for (int[] dir : DIRS) {
            Point p = new Point(next.x + dir[0], next.y + dir[1]);
            if (isFeasibleToWalk(minefield, p, minefield.get(p.x).get(p.y))) {
                flipColor(minefield, p);
            }
        }
    }


    private static Color flip(Color color) {
        if (color == Color.BLACK) {
            return Color.WHITE;
        }
        return Color.BLACK;
    }

    private static boolean isFeasibleToWalk(List<List<Color>> minefield, Point point, Color currentColor) {
        return point.x >= 0 && point.y >= 0 && point.x <= minefield.size() && point.y <= minefield.get(point.x).size()
            && minefield.get(point.x).get(point.y) == currentColor;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
