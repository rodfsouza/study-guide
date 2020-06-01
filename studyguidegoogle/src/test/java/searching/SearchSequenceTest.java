package searching;

import javafx.util.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSequenceTest {

    private List<Pair<String, String>> input;

    @BeforeEach
    public void setup() {
        input = new ArrayList<>();
        input.add(new Pair<>("popular", "famous"));
        input.add(new Pair<>("manager", "boss"));
        input.add(new Pair<>("work", "job"));
    }

    @Test
    public void testIsSequenceValid() {
        List<String> s1 = Arrays.asList("famous", "manager", "work");
        List<String> s2 = Arrays.asList("popular", "boss", "job");

        SearchSequence sequence = new SearchSequence();
        boolean isValid = sequence.isValidSequence(input, s1, s2);
        Assertions.assertTrue(isValid);
    }

    @Test
    public void testIsSequenceInvalid() {
        List<String> s1 = Arrays.asList("manager", "famous", "work");
        List<String> s2 = Arrays.asList("popular", "boss", "job");

        SearchSequence sequence = new SearchSequence();
        boolean isValid = sequence.isValidSequence(input, s1, s2);
        Assertions.assertFalse(isValid);
    }
}
