package dp;

import dp.CakeProblem.CakeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DynamicProgrammingTests {

    @Test
    public void testCoinProblem() {
        int[] denominations = {1, 2, 3};
        int result = CoinProblem.changePossibilitiesBottomUp(4, denominations);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void testCointProblem2() {
        int[] denominations = {1, 3, 5};
        int result = CoinProblem.changePossibilitiesBottomUp(5, denominations);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void testCointProblem3() {
        int[] denominations = {1, 5, 10, 25};
        int result = CoinProblem.changePossibilitiesBottomUp(100, denominations);
        Assertions.assertEquals(242, result);
    }

    @Test
    public void testCakeProblem() {
        CakeType c1 = new CakeType(7, 160);
        CakeType c2 = new CakeType(3, 90);
        CakeType c3 = new CakeType(2, 15);

        CakeType[] cakeTypes = {c1, c2, c3};

        long maxValue = CakeProblem.maxDuffelBagValue(cakeTypes, 20);
        Assertions.assertEquals(555, maxValue);
    }
}
