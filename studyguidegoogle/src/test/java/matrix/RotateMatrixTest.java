package matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RotateMatrixTest {

    @Test
    public void testRotateSquareMatrix() {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

        RotateMatrix rotation = new RotateMatrix();
        rotation.rotate(matrix);
        Assertions.assertTrue(matrix.length == 4 && matrix[0].length == 4);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
