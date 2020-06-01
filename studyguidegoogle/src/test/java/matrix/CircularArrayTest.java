package matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CircularArrayTest {


    @Test
    public void testCircularArrayFalse() {
        int[] a = {-2,2, 1};
        CircularArrayCycle circular = new CircularArrayCycle();
        Assertions.assertFalse(circular.hasCycle(a));
    }

    @Test
    public void testCircularArrayTrue() {
        int[] a = {-1, 2, 1};
        CircularArrayCycle circularArrayCycle = new CircularArrayCycle();
        Assertions.assertTrue(circularArrayCycle.hasCycle(a));
    }
}
