package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class OneAwayTest {

    private OneAway obj;

    @BeforeEach
    public void setup() {
        obj = new OneAway();
    }

    @Test
    public void testIsOneAway() {

        List <String> oneAways = Arrays.asList("ple", "bale");
        for(String s : oneAways) {
            Assertions.assertTrue(obj.isOneAway("pale", s));
        }

        Assertions.assertTrue(obj.isOneAway("pales", "pale"));
    }

    @Test
    public void testIsOneAwayFalse() {
        Assertions.assertFalse(obj.isOneAway(null, "pale"));
        Assertions.assertFalse(obj.isOneAway("pale", "bake"));
    }
}
