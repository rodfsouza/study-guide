package binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum, int sum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        sum += node.val;

        if (node.left == null && node.right == null && sum == targetSum) {
            result.add(new ArrayList<>(path));
        } else {
            dfs(node.left, targetSum, sum, path, result);
            dfs(node.right, targetSum, sum, path, result);
        }

        path.remove(path.size() - 1);
    }
}
