package stack;

import java.util.*;

public class StockSpanner {

    private final Deque<StockSpan> prices;

    public StockSpanner() {
        this.prices = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while (!prices.isEmpty() && prices.peek().stockPrice <= price) {
            span += prices.pop().span;
        }
        prices.push(new StockSpan(price, span));
        return span;
    }

    private class StockSpan {
        int span;
        int stockPrice;

        public StockSpan(int price, int numOfDays) {
            this.span = numOfDays;
            this.stockPrice = price;
        }
    }
}
