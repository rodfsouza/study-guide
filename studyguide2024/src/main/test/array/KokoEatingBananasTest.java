package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KokoEatingBananasTest {

    @Test
    public void testKokoEatingBananasSuccess() {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        assertEquals(4, kokoEatingBananas.minEatingSpeed(piles, h));
    }
}
