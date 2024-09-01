package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuteIntArray {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backTrack(results, new ArrayList<>(), new HashSet<>(), nums);
        return results;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> temp, Set<Integer> seen, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int num : nums) {
            if (seen.contains(num)) {
                continue;
            }

            temp.add(num);
            seen.add(num);

            backTrack(result, temp, seen, nums);
            int last = temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
            seen.remove(last);
        }
    }
}
