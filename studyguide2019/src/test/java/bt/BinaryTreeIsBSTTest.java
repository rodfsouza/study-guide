package bt;

import bt.BinarySearchTree.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeIsBSTTest {

    @Test
    public void test1() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        BinaryTreeIsBST treeIsBST = new BinaryTreeIsBST();
        boolean isBst = treeIsBST.isBst(root);
        Assertions.assertTrue(isBst);
    }

    @Test
    public void test2() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.right = new Node(5);

        root.right = new Node(5);
        root.right.right = new Node(6);

        BinaryTreeIsBST treeIsBST = new BinaryTreeIsBST();
        boolean isBst = treeIsBST.isBst(root);
        Assertions.assertFalse(isBst);
    }

    @Test
    public void test3() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        BinaryTreeIsBST treeIsBST = new BinaryTreeIsBST();
        boolean isBst = treeIsBST.isBst2(root);
        Assertions.assertTrue(isBst);
    }

    @Test
    public void test4() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.right = new Node(5);

        root.right = new Node(5);
        root.right.right = new Node(6);

        BinaryTreeIsBST treeIsBST = new BinaryTreeIsBST();
        boolean isBst = treeIsBST.isBst2(root);
        Assertions.assertFalse(isBst);
    }

}
