package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> spiral = new ArrayList<>();

        int row1 = 0;
        int row2 = matrix.length - 1;
        int col1 = 0;
        int col2 = matrix[0].length - 1;

        while (row1 <= row2 && col1 <= col2) {

            for (int i = col1; i <= col2; ++i) {
                spiral.add(matrix[row1][i]);
            }

            for (int i = row1 + 1; i <= row2; ++i) {
                spiral.add(matrix[i][col2]);
            }

            if (row1 != row2) {
                for (int i = col2 - 1; i >= col1; --i) {
                    spiral.add(matrix[row2][i]);
                }
            }

            if (col1 != col2) {
                for (int i = row2 - 1; i > row1; --i) {
                    spiral.add(matrix[i][col1]);
                }
            }

            row1++;
            row2--;
            col1++;
            col2--;
        }
        return spiral;
    }
}
