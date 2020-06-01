package recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MagicFastTest {

    @Test
    public void test1() {
        int[] input = {-40,-20,-10,3,5,6,7,8,9};
        MagicIndex m = new MagicIndex();
        int magic = m.magic(input);
        Assertions.assertEquals(3, magic);
    }
}
