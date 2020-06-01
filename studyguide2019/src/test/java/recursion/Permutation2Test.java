package recursion;

import org.junit.jupiter.api.Test;

import java.util.List;

public class Permutation2Test {

    @Test
    public void test1() {
        String input = "abc";
        Permutation2 p = new Permutation2();
        List<String> res = p.permute(input);
        System.out.println(String.format("Output size: %d", res.size()));
        res.stream().forEach(s -> System.out.println(s));
    }

    @Test
    public void test2() {
        String input = "abcd";
        Permutation2 p = new Permutation2();
        List<String> res = p.permute(input);
        System.out.println(String.format("Output size: %d", res.size()));
        res.stream().forEach(s -> System.out.println(s));
    }
}
