package backtrack;

import java.util.*;

public class SubsetsNoDup {

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(num);
        }

        List<List<Integer>> results = new ArrayList<>();
        //calcSubset(numbers, results, new ArrayList<>(), 0);
        backTrack(results, new ArrayList<>(), numbers, 0);
        return results;
    }

    private void backTrack(List<List<Integer>> results, List<Integer> subset, List<Integer> nums, int index) {
        results.add(new ArrayList<>(subset));

        for (int i = index; i < nums.size(); i++) {
            subset.add(nums.get(i));
            backTrack(results, subset, nums,i + 1);
            subset.remove(subset.size() - 1);
        }
    }


    public List<List<Integer>> subsets2(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        return subsetsHelper(numsList);
    }

    public List<List<Integer>> subsetsHelper(List<Integer> nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        calcSubset(nums, res, subset, 0);
        return res;
    }

    public void calcSubset(List<Integer> nums,
                           List<List<Integer>> res,
                           List<Integer> subset,
                           int index) {
        res.add(new ArrayList<>(subset));

        for (int i = index; i < nums.size(); i++) {
            subset.add(nums.get(i));
            calcSubset(nums, res, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
