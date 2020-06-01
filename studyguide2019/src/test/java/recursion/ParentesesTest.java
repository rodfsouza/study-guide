package recursion;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ParentesesTest {

    @Test
    public void test1() {
        Parenteses p = new Parenteses();
        List<String> res = p.parents(2);
        print(res);
    }

    @Test
    public void test2() {
        Parenteses p = new Parenteses();
        List<String> res = p.parents(3);
        print(res);
    }

    private void print(List<String> parents) {
        parents.stream().forEach(s -> System.out.println(s));
    }
}
