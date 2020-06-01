package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerMostWaterTests {

    @Test
    public void test1() {
        int[] input = {1,8,6,2,5,4,8,3,7};
        int expected = 49;
        ContainerMostWater mw = new ContainerMostWater();
        int res = mw.maxArea(input);
        assertEquals(expected, res);
    }
}
