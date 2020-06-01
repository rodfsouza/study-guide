package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneEditAwayTests {

    @Test
    public void test1() {
        OneEditAway edit = new OneEditAway();
        String s1 = "pale";
        String s2 = "ale";
        boolean res = edit.oneEdit(s1, s2);
        Assertions.assertTrue(res);
    }

    @Test
    public void test2() {
        OneEditAway edit = new OneEditAway();
        String s1 = "pale";
        String s2 = "kale";
        boolean res = edit.oneEdit(s1, s2);
        Assertions.assertTrue(res);
    }

    @Test
    public void test3() {
        OneEditAway edit = new OneEditAway();
        String s1 = "pale";
        String s2 = "kace";
        boolean res = edit.oneEdit(s1, s2);
        Assertions.assertFalse(res);
    }


    @Test
    public void test4() {
        OneEditAway edit = new OneEditAway();
        String s1 = "pale";
        String s2 = "ale";
        boolean res = edit.OneEdit2(s1, s2);
        Assertions.assertTrue(res);
    }

    @Test
    public void test5() {
        OneEditAway edit = new OneEditAway();
        String s1 = "pale";
        String s2 = "kale";
        boolean res = edit.oneEdit(s1, s2);
        Assertions.assertTrue(res);
    }

    @Test
    public void test6() {
        OneEditAway edit = new OneEditAway();
        String s1 = "pale";
        String s2 = "kace";
        boolean res = edit.OneEdit2(s1, s2);
        Assertions.assertFalse(res);
    }
}
