package binaryTree;

import binarytree.BinaryTreeVerticalTraversal;
import binarytree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BinaryTreeVerticalTraversalTest {

    @Test
    public void testVerticalTraversal() {
        BinaryTreeVerticalTraversal binaryTreeVerticalTraversal = new BinaryTreeVerticalTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> results = binaryTreeVerticalTraversal.traversal(root);
        System.out.println(results);
    }
}
