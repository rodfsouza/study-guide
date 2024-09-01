package binaryTree;

import binarytree.BinaryTreePaths;
import binarytree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreePathsTest {

    @Test
    public void testBinaryTreePaths() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        BinaryTreePaths btp = new BinaryTreePaths();
        List<String> paths = btp.paths(root);

        assertEquals(2, paths.size());
        assertEquals("1->2->5", paths.get(0));
        assertEquals("1->3", paths.get(1));
    }
}
