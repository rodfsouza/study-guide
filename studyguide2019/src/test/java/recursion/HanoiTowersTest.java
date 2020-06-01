package recursion;

import org.junit.jupiter.api.Test;
import recursion.HanoiTowers.Tower;

public class HanoiTowersTest {

    @Test
    public void test1() {
        int n = 3;
        Tower[] towers = new Tower[3];
        for (int i = 0; i < n; ++i) {
            towers[i] = new Tower(i);
        }

        for (int i = n - 1; i >= 0; --i) {
            towers[0].add(i);
        }
        towers[0].moveDisk(n, towers[2], towers[1]);
    }
}
