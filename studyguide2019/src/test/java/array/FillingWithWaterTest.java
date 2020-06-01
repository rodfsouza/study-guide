package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingWithWaterTest {

    @Test
    public void testFillingWithWater() {
        int[] elev = {1, 0, 3, 2, 0, 5, 4, 3, 2};
        int water = FillingWithWater.howMuchWater(elev);
        Assertions.assertEquals(4, water);
    }
}
