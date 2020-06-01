package matrix;

public class ZeroMatrix {

    public void toZero(final int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException();
        }

        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        final boolean[] row = new boolean[matrix.length];
        final boolean[] col = new boolean[matrix[0].length];


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        for (int j = 0; j < col.length; j++) {
            if (col[j]) {
                nullifyCol(matrix, j);
            }
        }

    }

    private void nullifyRow(int[][] array, int row) {
        for (int i = 0; i < array.length; i++) {
            array[row][i] = 0;
        }
    }

    private void nullifyCol(int[][] array, int col) {
        for (int i = 0; i < array[0].length; i++) {
            array[i][col] = 0;
        }
    }
}
