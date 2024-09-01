package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateParenthesesTest {

    @Test
    public void TestCases() {
        GenerateParentheses gp = new GenerateParentheses();
        //assertEquals("", gp.generate(0));
        assertEquals("()", gp.generate(1));
        assertEquals("()()", gp.generate(2));
        assertEquals("()()()", gp.generate(3));
        assertEquals("()()()()()", gp.generate(4));
    }
}
