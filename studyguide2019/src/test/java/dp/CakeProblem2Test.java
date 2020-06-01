package dp;

import dp.CakeProblem2.CakeType2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CakeProblem2Test {

    @Test
    public void testCakeProblem() {
        CakeType2 c1 = new CakeType2(7, 160);
        CakeType2 c2 = new CakeType2(3, 90);
        CakeType2 c3 = new CakeType2(2, 15);

        CakeType2[] cakeTypes = {c1, c2, c3};

        long maxValue = CakeProblem2.maxDuffelBagValue(cakeTypes, 20);
        Assertions.assertEquals(555, maxValue);
    }
}
