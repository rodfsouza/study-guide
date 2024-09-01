package binarytree;

public class MaxPathSum {

    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{ Integer.MIN_VALUE };
        postOrderTraversal(root, max);
        return max[0];
    }

    //PostOrder: left -> right -> root
    private int postOrderTraversal(TreeNode node , int[] max) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, postOrderTraversal(node.left, max));
        int right = Math.max(0, postOrderTraversal(node.right, max));

        max[0] = Math.max(max[0], left + right + node.val);

        return Math.max(left, right) + node.val;
    }
}
