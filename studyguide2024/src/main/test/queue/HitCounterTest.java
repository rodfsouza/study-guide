package queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HitCounterTest {

    @Test
    public void testHitCounterSuccess() {
        HitCounter counter = new HitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        assertEquals(3, counter.getHits(4));
        counter.hit(300);
        assertEquals(4, counter.getHits(300));
        assertEquals(3, counter.getHits(301));
    }

    @Test
    public void testHitCounterIISuccess() {
        HitCounterII counter = new HitCounterII();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        assertEquals(3, counter.getHits(4));
        counter.hit(300);
        assertEquals(4, counter.getHits(300));
        assertEquals(3, counter.getHits(301));
    }

    @Test
    public void testHitCounterIISuccess2() {
        HitCounterII counter = new HitCounterII();
        assertEquals(0, counter.getHits(1));
    }

    @Test
    public void testHitCounterIISuccess3() {
        HitCounterII counter = new HitCounterII();
        counter.hit(1);
        counter.hit(1);
        counter.hit(1);
        counter.hit(1);
        assertEquals(4, counter.getHits(4));
        counter.hit(300);
        assertEquals(5, counter.getHits(300));
        assertEquals(1, counter.getHits(301));
    }

    @Test
    public void testHitCounterIISuccess4() {
        HitCounterII counter = new HitCounterII();
        counter.hit(2);
        counter.hit(3);
        counter.hit(4);
        assertEquals(3, counter.getHits(300));
        assertEquals(3, counter.getHits(301));
        assertEquals(2, counter.getHits(302));
        assertEquals(1, counter.getHits(303));
        assertEquals(0, counter.getHits(304));
        counter.hit(501);
        assertEquals(1, counter.getHits(600));
    }

}
