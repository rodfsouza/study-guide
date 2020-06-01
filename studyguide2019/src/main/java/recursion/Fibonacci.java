package recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fibMemo(int n) {
        return fibMemo(n, new HashMap<>());
    }

    private int fibMemo(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        memo.put(n, result);

        return result;
    }

    public int fibNoRecursion(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        int prevPrev = 0;
        int prev = 1;
        int current = 0;

        for (int i = 1; i < n; ++i) {
            current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }
        return current;
    }
}
