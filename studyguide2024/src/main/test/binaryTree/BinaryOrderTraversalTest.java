package binaryTree;

import binarytree.BinaryTreeOrderTraversal;
import binarytree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryOrderTraversalTest {

    @Test
    public void testBinaryOrderTraversal() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeOrderTraversal bot = new BinaryTreeOrderTraversal();
        List<List<Integer>> result = bot.levelOrder(root);

        List<Integer>[] expected = new List[3];
        expected[0] = Arrays.asList(3);
        expected[1] = Arrays.asList(9, 20);
        expected[2] = Arrays.asList(15, 7);

        for (int i = 0; i < 3; i++) {
            assertEquals(expected[i], result.get(i));
        }
    }
}
