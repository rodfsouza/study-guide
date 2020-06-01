package search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortedMatrixSearchTest {

    @Test
    public void test1() {
        int[][] matrix = new int[5][4];

        int i = 0;
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[0].length; ++col) {
                matrix[row][col] = ++i;
            }
        }

        int toFind = 7;
        SortedMatrixSearch sm = new SortedMatrixSearch();
        boolean res = sm.find(matrix, toFind);
        Assertions.assertTrue(res);
    }

    @Test
    public void test2() {
        int[][] matrix = new int[5][4];

        int i = 0;
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[0].length; ++col) {
                matrix[row][col] = ++i;
            }
        }

        int toFind = 21;
        SortedMatrixSearch sm = new SortedMatrixSearch();
        boolean res = sm.find(matrix, toFind);
        Assertions.assertFalse(res);
    }
}
