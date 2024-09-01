package binaryTree;

import binarytree.MaxPathSum;
import binarytree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxPathSumTest {

    @Test
    public void testMaxPathSum() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        MaxPathSum mps = new MaxPathSum();
        int result = mps.maxPathSum(root);

        assertEquals(6, result);
    }

    @Test
    public void testMaxPathSum2() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxPathSum mps = new MaxPathSum();
        int result = mps.maxPathSum(root);

        assertEquals(42, result);
    }
}
