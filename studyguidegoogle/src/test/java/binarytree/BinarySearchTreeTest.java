package binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> bTree;

    @BeforeEach
    public void setup() {
        bTree = new BinarySearchTree<>(314);
        bTree.add(6);
        bTree.add(315);
        bTree.add(401);
        bTree.add(561);
        bTree.add(271);
        bTree.add(28);
        bTree.add(0);
        bTree.add(641);
        bTree.add(357);
    }

    @Test
    public void testBinarySearchTreeInOrder() {
        System.out.print("{");
        for (BinaryTreeNode<Integer> node : bTree.inOrder()) {
            System.out.print(node.data + ", ");
        }
        System.out.print("}");
    }

    @Test
    public void testBinarySearchTreePreOrder() {
        System.out.print("{");
        for (BinaryTreeNode<Integer> node : bTree.preOrder()) {
            System.out.print(node.data + ", ");
        }
        System.out.print("}");
    }

    @Test
    public void testBinarySearchTreePostOrder() {
        System.out.print("{");
        for (BinaryTreeNode<Integer> node : bTree.postOrder()) {
            System.out.print(node.data + ", ");
        }
        System.out.print("}");
    }

    @Test
    public void testBinarySearchTreeFind() {
        BinaryTreeNode<Integer> node = bTree.find(314);
        System.out.print(node == null ? "null" : node.data);
    }
}
