package string;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    private List<String> permutations = new ArrayList<>();

    public List<String> permute(String candidate) {
        //TODO: What if it's a very large string?

        if (candidate == null) {
            return permutations;
        }

        permute("", candidate);
        return permutations;
    }

    private void permute(String prefix, String candidate) {
        if (candidate.isEmpty()) {
            permutations.add(prefix);
            return;
        }

        for (int i = 0; i < candidate.length(); ++i) {
            permute(prefix + candidate.charAt(i), candidate.substring(0, i) +
                candidate.substring(i + 1, candidate.length()));
        }
    }
}
