package dp;

/**
 *  * Time complexity is O(m*n)
 *  * Space complexity is O(m*n)
 */
public class MinimumEditDistance {

    public int minDistance(char[] str1, char[] str2) {
        int[][] counters = new int[str1.length + 1][str2.length + 1];

        for (int i = 0; i < counters[0].length; ++i) {
            counters[0][i] = i;
        }

        for (int i = 0; i < counters.length; ++i) {
            counters[i][0] = i;
        }

        for (int i = 1; i <= str1.length; ++i) {
            for (int j = 1; j <= str2.length; ++j) {
                if (str1[i - 1] == str2[j - 1]) {
                    counters[i][j] = counters[i - 1][j - 1];
                } else {
                    counters[i][j] = 1 + min(counters[i - 1][j], counters[i][j - 1], counters[i - 1][j - 1]);
                }
            }
        }
        print(counters);
        return counters[str1.length][str2.length];
    }

    private int min(int x, int y, int z) {
        int a = Math.min(x, y);
        return Math.min(a, z);
    }

    private void print(int[][] matrix) {
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[0].length; ++col) {
                System.out.print(String.format("%d,", matrix[row][col]));
            }
            System.out.println();
        }
    }
}
