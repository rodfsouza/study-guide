package binaryTree;

import binarytree.KthSmallestElementBST;
import binarytree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthSmallestElementBSTTest {

    @Test
    public void testKthSmallestElementBST() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallestElementBST kse = new KthSmallestElementBST();
        int result = kse.kthSmallest(root, 1);

        assertEquals(1, result);
    }
}
