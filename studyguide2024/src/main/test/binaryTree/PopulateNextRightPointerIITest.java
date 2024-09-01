package binaryTree;

import binarytree.Node;
import binarytree.PopulateNextRightPointerII;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PopulateNextRightPointerIITest {

    @Test
    public void testConnect() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.right = new Node(7);

        PopulateNextRightPointerII pnr = new PopulateNextRightPointerII();
        Node result = pnr.connect(root);
        assertNotNull(result);
    }
}
