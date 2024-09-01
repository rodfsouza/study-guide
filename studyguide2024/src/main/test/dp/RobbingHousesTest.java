package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobbingHousesTest {

    @Test
    public void testRobbingHouses() {
        int[] nums = new int[]{1,2,3,1};
        RobbingHouses robbingHouses = new RobbingHouses();
        int result = robbingHouses.rob(nums);
        assertEquals(4, result);
    }

    @Test
    public void testRobbingHouses2() {
        int[] nums = new int[]{2,7,9,3,1};
        RobbingHouses robbingHouses = new RobbingHouses();
        int result = robbingHouses.rob(nums);
        assertEquals(12, result);
    }
}
