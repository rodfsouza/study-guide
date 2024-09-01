package set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomizedSetTest {

    @Test
    public void testRandomizedSetSuccess() {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        randomizedSet.insert(3);
        assertEquals(3, randomizedSet.getRandom());
        randomizedSet.remove(2);
        assertEquals(3, randomizedSet.getRandom());
    }

    @Test
    public void testRandomizedSetSuccess2() {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        assertEquals(2, randomizedSet.getRandom());
    }
}
