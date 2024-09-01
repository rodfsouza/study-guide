package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockSpannerTest {

    @Test
    public void TestStockSpannerSuccess() {
        StockSpanner sp = new StockSpanner();
        int result = sp.next(100);
        assertEquals(1, result);

        result = sp.next(80);
        assertEquals(1, result);

        result = sp.next(60);
        assertEquals(1, result);

        result = sp.next(70);
        assertEquals(2, result);

        result = sp.next(60);
        assertEquals(1, result);

        result = sp.next(75);
        assertEquals(4, result);

        result = sp.next(85);
        assertEquals(6, result);
    }
}
