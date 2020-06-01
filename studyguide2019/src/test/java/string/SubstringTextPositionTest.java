package string;

import org.junit.jupiter.api.Test;
import string.SubstringTextPosition.SubStringPosition;

import java.util.List;

public class SubstringTextPositionTest {

    @Test
    public void testHappyCase() {
        String sub = "abbc";
        String text = "cbabadcbbabbcbabaabccbabc";
        SubstringTextPosition sp = new SubstringTextPosition();
        List<SubStringPosition> result = sp.subPositions(text, sub);

        result.forEach(st -> System.out.println("{" + st.initial + "," + st.end + "}"));
    }
}
