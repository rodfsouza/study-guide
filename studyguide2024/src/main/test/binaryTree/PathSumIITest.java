package binaryTree;

import binarytree.PathSumII;
import binarytree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PathSumIITest {

    @Test
    public void testPathSumIISuccess() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        PathSumII ps = new PathSumII();
        List< List<Integer>> results = ps.pathSum(root, 22);
        assertEquals(2, results.size());

        int[] expected1 = {5, 4, 11, 2};
        int[] expected2 = {5, 8, 4, 5};
        assertArrayEquals(expected1, results.get(0).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(expected2, results.get(1).stream().mapToInt(i -> i).toArray());
    }
}
