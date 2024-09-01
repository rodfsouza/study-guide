package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbingStairTest {

    @Test
    public void testClimbingStairs() {
        ClimbingStairs climbinStairs = new ClimbingStairs();
        int result = climbinStairs.climb(3);
        assertEquals(3, result);
    }
}
