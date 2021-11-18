package btree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InOrderIteratorIterativeTest {

    @Test
    public void testInOrderTraversalSimpleTree() {
        TreeNode<Integer> tree = new TreeNode<>(7);
        tree.left = new TreeNode<>(3);
        tree.right = new TreeNode<>(15);
        tree.right.left = new TreeNode<>(9);
        tree.right.right = new TreeNode<>(20);

        InOrderIteratorIterative<Integer> iterator = new InOrderIteratorIterative<>(tree);

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(3, iterator.next());
    }
}
