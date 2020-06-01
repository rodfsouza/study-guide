package recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

public class RobotPathTest {

    @Test
    public void test1() {
        int[][] matrix = new int[4][5];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[1][2] = 1;
        matrix[2][2] = 1;
        matrix[3][2] = 1;
        matrix[3][3] = 1;
        matrix[3][4] = 1;

        RobotPath r = new RobotPath();
        List<RobotPath.Point> points = r.findPath(matrix);
        Assertions.assertNotNull(points);
        Assertions.assertFalse(points.isEmpty());
    }
}
