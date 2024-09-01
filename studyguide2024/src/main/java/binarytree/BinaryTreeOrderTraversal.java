package binarytree;

import java.util.*;

public class BinaryTreeOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> results = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currSize = queue.size();
            List<Integer> atLevel = new LinkedList<>();

            for (int i = 0; i < currSize; ++i) {
                TreeNode curr = queue.poll();

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                atLevel.add(curr.val);
            }

            results.add(atLevel);
        }

        return results;
    }
}
