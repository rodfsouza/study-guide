package matrix;

public class RotateMatrix {

    public void rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException();
        }

        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Matrix should be a squared");
        }

        int size = matrix.length - 1;

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp1 = matrix[size - j][i];
                int temp2 = matrix[size -i][size - j];
                int temp3 = matrix[j][size - i];
                int temp4 = matrix[i][j];

                matrix[i][j] = temp1;
                matrix[size - j][i] = temp2;
                matrix[size - i][size - j] = temp3;
                matrix[j][size - i] = temp4;
            }
        }
    }
}
