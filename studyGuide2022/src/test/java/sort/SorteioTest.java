package sort;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SorteioTest {

    private static Random rnd;

    @BeforeAll
    public static void init() {
        rnd = new Random();
    }

    @Test
    public void sortear() {
        String[] people = {"Lorena Guerrero", "Sarah Slidelt", "Kimberly Kelly", "Keli Mcconville", "Hos Anna",
                "Lindsay Ogaard", "Desirae Gonzales Metoyer", "Krystle Costello"};
        Set<Integer> seenNumber = new HashSet<>();
        for (int i = 0; i < people.length; ++i) {
            int next = rnd.nextInt(people.length);
            while (seenNumber.contains(next)) {
                next = rnd.nextInt(people.length);
            }
            seenNumber.add(next);
            System.out.println(people[next]);
        }
    }
}
