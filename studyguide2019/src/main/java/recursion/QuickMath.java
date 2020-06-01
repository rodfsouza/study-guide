package recursion;

public class QuickMath {

    public int func (int n) {
        if (n == 4) {
            return 2;
        } else {
            return 2 * func(n + 1);
        }
    }
}
