package bt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class BTreeNodeTests {

    @Test
    public void completeBTreeTraversalTest() {

        BTreeNode<Integer> root = new BTreeNode<>(1);
        root.left = new BTreeNode<>(2);
        root.left.left = new BTreeNode<>(4);
        root.left.right = new BTreeNode<>(5);

        root.right = new BTreeNode<>(3);
        root.right.left = new BTreeNode<>(6);
        root.right.right = new BTreeNode<>(7);

        BTreeNode<Integer> newRoot = root.levelTraverseUpdatingNextPointer(root);
        Assertions.assertTrue(newRoot != null);
    }

    @Test
    public void NonCompleteBTreeTraversalTest() {

        BTreeNode<Integer> root = new BTreeNode<>(1);
        root.left = new BTreeNode<>(2);
        root.left.left = new BTreeNode<>(4);
        root.left.right = new BTreeNode<>(5);

        root.right = new BTreeNode<>(3);
        //root.right.left = new BTreeNode<>(6);
        root.right.right = new BTreeNode<>(7);

        BTreeNode<Integer> newRoot = root.levelTraverseUpdatingNextPointer(root);
        Assertions.assertTrue(newRoot != null);
    }

    @Test
    public void bTreeRightSideTest1() {

        BTreeNode<Integer> root = new BTreeNode<>(1);
        root.left = new BTreeNode<>(2);
        root.left.right = new BTreeNode<>(5);

        root.right = new BTreeNode<>(3);
        root.right.right = new BTreeNode<>(4);

        List<Integer> results = root.preOrderTraversal(root);
        Assertions.assertTrue(!results.isEmpty());
    }

    @Test
    public void bTreeRightSideTest2() {

        BTreeNode<Integer> root = new BTreeNode<>(1);
        root.right = new BTreeNode<>(3);

        List<Integer> results = root.preOrderTraversal(root);
        Assertions.assertTrue(!results.isEmpty());
    }

    @Test
    public void bTreeRightSideTest3() {

        BTreeNode<Integer> root = new BTreeNode<>(1);
        root.left = new BTreeNode<>(2);

        List<Integer> results = root.preOrderTraversal(root);
        Assertions.assertTrue(!results.isEmpty());
    }

    @Test
    public void testLevelBottomTraverse1() {

        BTreeNode<Integer> root = new BTreeNode<>(3);
        root.left = new BTreeNode<>(9);
        //root.left.left = new BTreeNode<>(4);
        //root.left.right = new BTreeNode<>(5);

        root.right = new BTreeNode<>(20);
        root.right.left = new BTreeNode<>(15);
        root.right.right = new BTreeNode<>(7);

        List<List<BTreeNode<Integer>>> results = root.levelOrderBottom(root);
        Assertions.assertTrue(results != null);
    }

    @Test
    public void testLevelBottomTraverse2() {
        BTreeNode<Integer> root = new BTreeNode<>(1);
        List<List<BTreeNode<Integer>>> results = root.levelOrderBottom(root);
        Assertions.assertTrue(results != null);
    }

    @Test
    public void testLevelBottomTraverse3() {
        BTreeNode<Integer> root = new BTreeNode<>(null);
        List<List<BTreeNode<Integer>>> results = root.levelOrderBottom(root);
        Assertions.assertTrue(results != null);
    }
}
