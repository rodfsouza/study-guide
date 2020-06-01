package matrix;

/**
 * Created by rodsou on 7/11/17.
 */
public class MatrixProblems {

    final static int[][] mat = new int[][] {
        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
        { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };

    static final SearchMazeBFS mazeSearch = new SearchMazeBFS(mat);

    public static void main(String[] args) {
        SearchMazeBFS.Point source = new SearchMazeBFS.Point(0,0);
        SearchMazeBFS.Point destination = new SearchMazeBFS.Point(3, 4);

        int distance = mazeSearch.BFS(mat, source, destination);
        System.out.println("Shortest path is: " + distance);

        char[][] matrix = { { 't', 'z', 'x', 'c', 'd' },
            { 'a', 'h', 'n', 'z', 'x' }, { 'h', 'w', 'o', 'i', 'o' },
            { 'o', 'r', 'n', 'r', 'n' }, { 'a', 'b', 'r', 'i', 'n' } };

        patternSearch(matrix, "horizon");
    }

    static boolean search2D(final char[][] grid, final int row, final int col, final String word) {
        if (word == null) {
            return false;
        }

        final int[] x = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
        final int[] y = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};

        if (grid[row][col] != word.charAt(0)) {
            return false;
        }

        for (int i = 0; i < x.length; i++) {
            int k;
            int rd = row + x[i];
            int cd = col + y[i];

            for (k = 1; k < word.length(); k++) {
                if (rd > grid.length || rd < 0 || cd > grid[0].length || cd < 0) {
                    break;
                }
                if (grid[rd][cd] != word.charAt(k)) {
                    break;
                }
                rd += x[i];
                cd += y[i];
            }

            if (k == word.length()) {
                return true;
            }
        }
        return false;
    }

    static void patternSearch(final char grid[][], final String word) {
        if (grid.length == 0 || word == null || word.isEmpty()) {
            return;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (search2D(grid, i, j, word)) {
                    System.out.println(String.format("Pattern found: %s, %s", i, j));
                }
            }
        }
    }

}
