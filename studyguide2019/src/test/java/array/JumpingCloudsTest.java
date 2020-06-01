package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JumpingCloudsTest {

    @Test
    public void testSimpleTest() {
        int[] arr = {0, 0, 1, 0, 0, 1, 0};
        JumpingClouds jc = new JumpingClouds();
        int numberOfJumps = jc.jumpingOnClouds(arr);
        Assertions.assertEquals(4, numberOfJumps);
    }

    @Test
    public void testSimpleTest2() {
        int[] arr = {0, 0, 0, 0, 1, 0};
        JumpingClouds jc = new JumpingClouds();
        int numberOfJumps = jc.jumpingOnClouds(arr);
        Assertions.assertEquals(3, numberOfJumps);
    }

    @Test
    public void testSimpleTest3() {
        int[] arr = {0, 0, 1, 0, 0, 0, 0, 1, 0, 0};
        JumpingClouds jc = new JumpingClouds();
        int numberOfJumps = jc.jumpingOnClouds(arr);
        Assertions.assertEquals(6, numberOfJumps);
    }

}
