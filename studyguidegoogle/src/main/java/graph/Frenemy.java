package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Frenemy {

    private static final int[][] validMoves = {{0,1}, {1,0}, {0, -1}, {-1,0}};

    public static int isFrenemy(int n, String[] frenemy, int x, int y, String relation) {

        Point initial = new Point(x, y);
        Queue<Point> q = new LinkedList<>();
        q.offer(initial);

        Set<Point> visited = new HashSet<>();
        visited.add(initial);

        char[] relations = relation.toCharArray();

        while (!q.isEmpty()) {
            Point curr = q.poll();

            for (int[] m : validMoves) {
                Point next = new Point(curr.x + m[0], curr.y + m[1]);

                if (isValidToMove(next, frenemy) && !visited.contains(next)) {
                    visited.add(next);
                    q.offer(next);

                    for (Character c : relations) {
                        if (frenemy[next.x].charAt(next.y) == c) {

                        }
                    }
                }

            }
        }

        return -1;
    }

    private static boolean isValidToMove(Point p, String[] matrix) {
        return p.x >= 0 || p.x < matrix.length || p.y >= 0 || p.y < matrix[0].length();
    }

    public static class Point {
        int x;
        int y;

        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
