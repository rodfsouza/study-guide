package dynamic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DPProblems {

    public static void main(String[] args) {
        List<Integer> playScores = Arrays.asList(2,3,7);
        System.out.println(getSubsets(playScores, 0));
        //System.out.println(scoreCombinations(playScores, 12));
    }

    static int fibonacci(final int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int fibonacci(final int n, int[] memo) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (memo[n] == 0) {
            memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        }
        return memo[n];
    }

    static int fib(final int n) {
        if (n == 0) {
            return 0;
        }

        int a = 0;
        int b = 1;

        for (int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }

    static int stairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return stairs(n, memo);
    }

    static int stairs(final int n, int[] memo) {
       if ( n < 0) {
           return 0;
       } else if (n == 0) {
           return 1;
       } else {
           memo[n] = stairs(n - 1, memo) + stairs(n - 2, memo) + stairs(n - 3, memo);
           return memo[n];
       }
    }

    static int stairs2(int n) {
        int a = 0;
        int b = 1;

        for (int i = 1; i <= n; i++) {
            int c = a + b;
            a += (a + b) - a;
            b = c;
        }
        return a;
    }

    static List<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }

        List<Point> paths = new ArrayList<>();
        if (getPath(maze, maze.length -1, maze[0].length -1, paths)) {
            return paths;
        }
        return null;
    }

    static boolean getPath(boolean[][] maze, int row, int col, List<Point> path) {
        if (row < 0 || col < 0 || !maze[row][col]) {
            return false;
        }

        boolean isAtOrigin = (row == 0 && col == 0);

        if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
            path.add(new Point(row, col));
            return true;
        }
        return false;
    }

    static List<Point> getPath2(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }

        List<Point> paths = new ArrayList<>();
        Set<Point> visited = new HashSet<>();
        if (getPath(maze, maze.length -1, maze[0].length -1, paths, visited)) {
            return paths;
        }
        return null;
    }

    static boolean getPath(boolean[][] maze, int row, int col, List<Point> path, Set<Point> visited) {
        if (row < 0 || col < 0 || !maze[row][col]) {
            return false;
        }

        Point p = new Point(row, col);
        if (visited.contains(p)) {
            return false;
        }

        boolean isAtOrigin = (row == 0 && col == 0);

        if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
            path.add(p);
            return true;
        }

        visited.add(p);
        return false;
    }

    static List<Point> pathBFS(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return new ArrayList<>();
        }

        Queue<Point> vertexes = new ArrayDeque<>();
        List<Point> paths = new ArrayList<>();
        boolean[][] visited = new boolean[maze.length - 1][maze[0].length - 1];

        Point p = new Point(0, 0);
        visited[0][0] = true;
        vertexes.offer(p);

        int[][] dir = { {0,1}, {1,0} };

        int numberOfRows = maze.length - 1;
        int numberOfCols = maze[0].length - 1;

        while (!vertexes.isEmpty()) {
            Point current = vertexes.poll();

            for (int[] pos :  dir) {
                int newRow = current.row + pos[0];
                int newcol = current.col + pos[1];
                if (newRow <= numberOfRows && newcol <= numberOfCols
                    && !visited[newRow][newcol]) {
                    vertexes.add(new Point(current.row + pos[0], current.col + pos[1]));
                    visited[newRow][newcol] = true;
                }
            }
            paths.add(current);
        }
        return paths;
    }

    static int scoreCombinations(final List<Integer> playScores, final int finalScore) {
        int[][] combinations = new int[playScores.size()][finalScore + 1];

        for(int i = 0; i < playScores.size(); i++) {
            combinations[i][0] = 1;

            for (int j = 1; j <= finalScore; j++) {
                int withoutPlay = i - 1 >= 0 ? combinations[i - 1][j] : 0;
                int withPlay = j >= playScores.get(i) ? combinations[i][j - playScores.get(i)] : 0;
                combinations[i][j] = withoutPlay + withPlay;
            }
        }
        return combinations[playScores.size() - 1][finalScore];
    }

    static List<List<Integer>> scoresWay(List<Integer> scores, int finalScore) {
        List<Integer> combinations = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            for (int j = 1; j < finalScore; j++) {
                int diff = finalScore - scores.get(i);
                if (diff < finalScore) {
                    combinations.add(scores.get(i));
                    scoresWay(scores, diff);
                }
            }
            result.add(combinations);
        }
        return result;
    }

    static List<List<Integer>> getSubsets(List<Integer> set, int index) {
        List<List<Integer>> subsets;
        if (set.size() == index) {
            subsets = new ArrayList<>();
            subsets.add(new ArrayList<>());
        } else {
            subsets = getSubsets(set, index + 1);
            int item = set.get(index);
            List<List<Integer>> moreSubsets = new ArrayList<>();

            for (List<Integer> subset : subsets) {
                List<Integer>  newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            subsets.addAll(moreSubsets);
        }

        return subsets;
    }

    static class Point {
        private int row;
        private int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
