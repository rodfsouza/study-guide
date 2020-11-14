package bt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BinarySearchTreeTests {

    private static BinarySearchTree.Node root = new BinarySearchTree.Node(50);
    private static Set<Integer> onTheTree = new HashSet<>();

    @BeforeAll
    public static void setup() throws InterruptedException {

        Random rd = new Random();
        for (int i = 0; i < 100; ++i) {
            int value = rd.nextInt(100);
            if (!onTheTree.contains(value)) {
                onTheTree.add(value);
                root.insert(value);
            }
            Thread.sleep(20);
        }
    }

    @Test
    public void testBst() {
        BinarySearchTree.Node root = new BinarySearchTree.Node(10);
        root.left = new BinarySearchTree.Node(7);
        root.left.left = new BinarySearchTree.Node(4);
        root.left.right = new BinarySearchTree.Node(9);

        root.right = new BinarySearchTree.Node(15);
        root.right.left = new BinarySearchTree.Node(12);
        root.right.right = new BinarySearchTree.Node(16);

        int nextBigger = root.getSuccessor(root, 9);
        Assertions.assertEquals(7, nextBigger);
    }
}
