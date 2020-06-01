package permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    private static List<String> permutations = new ArrayList<>();

    public static void main(String[] args) {
        permute("abcd");
        System.console();
    }

    public static void permute(final String str) {
        if (str == null) {
            return;
        }
        permutation("", str);
    }

    private static void permutation(final String prefix, final String str) {
        if (str.length() == 0) {
            permutations.add(prefix);
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()));
        }
    }
}
