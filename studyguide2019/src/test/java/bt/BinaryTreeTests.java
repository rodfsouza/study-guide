package bt;

import org.junit.jupiter.api.Test;

import static bt.BinaryTree.Node;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTests {

    @Test
    public void fullTreeTest() {
        Node root = new Node(5);
        Node a = root.insertLeft(8);
        Node b = root.insertRight(6);

        a.insertLeft(1);
        a.insertRight(2);
        b.insertLeft(3);
        b.insertRight(4);

        BinaryTree bt = new BinaryTree();
        final boolean result = bt.checkBalanced(root);
        assertTrue(result);
    }

    @Test
    public void bothLeavesAtTheSameDepthTest() {
        final Node root = new Node(3);
        root.insertLeft(4).insertLeft(1);
        root.insertRight(2).insertRight(9);
        BinaryTree bt = new BinaryTree();
        final boolean result = bt.checkBalanced(root);
        assertTrue(result);
    }

    @Test
    public void leafHeightsDifferByTwoTest() {
        final Node root = new Node(6);
        root.insertLeft(1);
        root.insertRight(0).insertRight(7).insertRight(8);
        BinaryTree bt = new BinaryTree();
        final boolean result = bt.checkBalanced(root);
        assertFalse(result);
    }
}
