package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixColorTest {

    @Test
    public void testMatrixColorSuccess() {
        boolean[][] matrix = {{false, false, true, false},
                            {true, false, false, true},
                            {false, true, true, false},
                            {true, false,false, false}};

        MatrixColor m = new MatrixColor();
        m.flipColor(matrix, 1,1);
        Assertions.assertTrue(matrix[2][1]);
    }

    @Test
    public void testMatrixColorDfsSuccess() {
        boolean[][] matrix = {{false, false, true, false},
                {true, false, false, true},
                {false, true, true, false},
                {true, false,false, false}};

        MatrixColor m = new MatrixColor();
        m.flipColorDfs(matrix, 1,1);
        Assertions.assertTrue(matrix[2][1]);
    }
}
