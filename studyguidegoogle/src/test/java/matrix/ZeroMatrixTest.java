package matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZeroMatrixTest {

    private ZeroMatrix obj;

    @BeforeEach
    public void setup() {
        obj = new ZeroMatrix();
    }

    @Test
    public void testToZero() {
        final int[][] array =
            {{3,3,3},
            {3,0,3},
            {3,3,3}};

        obj.toZero(array);

        final int[][] expected =
            {{3,0,3},
            {0,0,0},
            {3,0,3}};

        Assertions.assertEquals(expected, array);
    }
}
