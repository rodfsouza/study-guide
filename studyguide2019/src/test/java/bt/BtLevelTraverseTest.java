package bt;

import org.junit.jupiter.api.Test;

import java.util.List;

public class BtLevelTraverseTest {

    @Test
    public void test1() {
        BinaryTree.Node root = new BinaryTree.Node(5);
        BinaryTree.Node a = root.insertLeft(8);
        BinaryTree.Node b = root.insertRight(6);

        a.insertLeft(1);
        a.insertRight(2);
        b.insertLeft(3);
        b.insertRight(4);

        BtLevelTraverse bt = new BtLevelTraverse();
        List<List<Integer>> res = bt.recursiveLevelTraverse(root);
        print(res);
    }

    private void print(List<List<Integer>> levels) {
        for (List<Integer> level : levels) {
            for (Integer i : level) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
