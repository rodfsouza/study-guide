package binarytree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeTest {

    private BinaryTreeNode<Integer> root;

    @BeforeEach
    public void setup() {
        //Depth 0
        root = new BinaryTreeNode<>(314);

        //Depht 1
        root.left = new BinaryTreeNode<>(6);
        root.right = new BinaryTreeNode<>(6);

        //Depth 2
        root.left.left = new BinaryTreeNode<>(271);
        root.left.right = new BinaryTreeNode<>(561);
        root.right.left = new BinaryTreeNode<>(2);
        root.right.right = new BinaryTreeNode<>(271);

        //Depth 3
        root.left.left.left = new BinaryTreeNode<>(28);
        root.left.left.right = new BinaryTreeNode<>(0);
        root.left.right.right = new BinaryTreeNode<>(3);
        root.right.left.right = new BinaryTreeNode<>(1);
        root.right.right.right = new BinaryTreeNode<>(28);

        //Depth 4
        root.left.right.right.left = new BinaryTreeNode<>(17);
        root.right.left.right.left = new BinaryTreeNode<>(401);
        root.right.left.right.right = new BinaryTreeNode<>(257);

        //Depth 5
        root.right.left.right.left.right = new BinaryTreeNode<>(641);
    }

    @Test
    public void testPreOrderTraversal() {
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();
        preOrder(root, result);

        System.out.print("{");
        for (BinaryTreeNode<Integer> node : result) {
            System.out.print(node.data + ", ");
        }
        System.out.print("}");
    }

    private List<BinaryTreeNode<Integer>> preOrder(BinaryTreeNode<Integer> node, List<BinaryTreeNode<Integer>> list) {
        if (node != null) {
            list.add(node);
            preOrder(node.left, list);
            preOrder(node.right, list);
        }
        return list;
    }

    @Test
    public void testInOrderTraversal() {
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();
        inOrder(root, result);

        System.out.print("{");
        for (BinaryTreeNode<Integer> node : result) {
            System.out.print(node.data + ", ");
        }
        System.out.print("}");
    }

    private List<BinaryTreeNode<Integer>> inOrder(BinaryTreeNode<Integer> node, List<BinaryTreeNode<Integer>> list) {
        if (node != null) {
            preOrder(node.left, list);
            list.add(node);
            preOrder(node.right, list);
        }
        return list;
    }

    @Test
    public void testPostOrderTraversal() {
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();
        postOrder(root, result);

        System.out.print("{");
        for (BinaryTreeNode<Integer> node : result) {
            System.out.print(node.data + ", ");
        }
        System.out.print("}");
    }

    private List<BinaryTreeNode<Integer>> postOrder(BinaryTreeNode<Integer> node, List<BinaryTreeNode<Integer>> list) {
        if (node != null) {
            preOrder(node.left, list);
            preOrder(node.right, list);
            list.add(node);
        }
        return list;
    }

    @Test
    public void testBTreeHeight() {
        int height = bTreeHeight(root);
        System.out.print(height);
    }

    private int bTreeHeight(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return -1;
        }
        return Math.max(bTreeHeight(node.left), bTreeHeight(node.right)) + 1;
    }


    @Test
    public void testBTreeInOrderIterative() {
        List<BinaryTreeNode<Integer>> result = inOrderIterative(root);

        Assertions.assertNotNull(result);

        System.out.print("{");
        for (BinaryTreeNode<Integer> node : result) {
            System.out.print(node.data + ", ");
        }
        System.out.print("}");
    }

    private List<BinaryTreeNode<Integer>> inOrderIterative(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return new ArrayList<>();
        }

        List<BinaryTreeNode<Integer>> result = new ArrayList<>();

        Deque<BinaryTreeNode<Integer>> nodesBeingProcessed = new LinkedList<>();
        BinaryTreeNode<Integer> current = node;

        while (current != null) {
            nodesBeingProcessed.push(current);
            current = current.left;
        }

        while (!nodesBeingProcessed.isEmpty()) {
            current = nodesBeingProcessed.pop();
            result.add(current);

            if (current != null) {
                current = current.right;
            }

            while (current != null) {
                nodesBeingProcessed.push(current);
                current = current.left;
            }
        }

        return result;
    }

    @Test
    public void testBTreePreOrderIterative() {
        List<BinaryTreeNode<Integer>> result = preOrderIterative(root);

        Assertions.assertNotNull(result);

        System.out.print("{");
        for (BinaryTreeNode<Integer> node : result) {
            System.out.print(node.data + ", ");
        }
        System.out.print("}");
    }


    private List<BinaryTreeNode<Integer>> preOrderIterative(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return new ArrayList<>();
        }

        List<BinaryTreeNode<Integer>> result = new ArrayList<>();

        Deque<BinaryTreeNode<Integer>> nodesBeingProcessed = new LinkedList<>();
        nodesBeingProcessed.push(node);

        while (!nodesBeingProcessed.isEmpty()) {
            BinaryTreeNode<Integer> current = nodesBeingProcessed.pop();
            result.add(current);

            if (current.right != null) {
                nodesBeingProcessed.push(current.right);
            }

           if (current.left != null) {
                nodesBeingProcessed.push(current.left);
           }
        }

        return result;
    }

    @Test
    public void testBTreePostOrderIterative() {
        List<BinaryTreeNode<Integer>> result = postOrderIterative(root);

        Assertions.assertNotNull(result);

        System.out.print("{");
        for (BinaryTreeNode<Integer> node : result) {
            System.out.print(node.data + ", ");
        }
        System.out.print("}");
    }



    private List<BinaryTreeNode<Integer>> postOrderIterative(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return new ArrayList<>();
        }

        List<BinaryTreeNode<Integer>> result = new ArrayList<>();

        Deque<BinaryTreeNode<Integer>> s1 = new LinkedList<>();
        Deque<BinaryTreeNode<Integer>> s2 = new LinkedList<>();
        s1.push(node);

        while (!s1.isEmpty()) {
            BinaryTreeNode<Integer> current = s1.pop();
            s2.push(current);

            if (current.left != null) {
                s1.push(current.left);
            }

            if (current.right != null) {
                s1.push(current.right);
            }
        }

        while (!s2.isEmpty()) {
            result.add(s2.pop());
        }

        return result;
    }

    private List<BinaryTreeNode<Integer>> postOrderIterativeSingleStack(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return new ArrayList<>();
        }

        List<BinaryTreeNode<Integer>> res = new ArrayList<>();

        Deque<BinaryTreeNode<Integer>> nodesBeingProcessed = new LinkedList<>();
        BinaryTreeNode<Integer> current = node;

        if (current.right != null) {
            nodesBeingProcessed.push(current.right);
            nodesBeingProcessed.push(current);
        }

        current = current.left;
        BinaryTreeNode<Integer> prev = null;

        while (!nodesBeingProcessed.isEmpty()) {
            current  = nodesBeingProcessed.peek();

            if (current.right != null && nodesBeingProcessed.peek().equals(current.right)) {
                BinaryTreeNode<Integer> tmp = nodesBeingProcessed.pop();
                nodesBeingProcessed.push(current);
                current = tmp;
            } else {
                res.add(current);
                current = null;
            }

        }

        return res;
    }


    @Test
    public void testIfIsHeightBalanced() {
        BalancedWithHeight<Integer> checkTree = new BalancedWithHeight<>();
        BalancedWithHeight<Integer> result = checkTree.checkBalanced(root);
        Assertions.assertFalse(result.balanced);
    }

    @Test
    public void testIfIsSymmetric() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(314);
        root.left = new BinaryTreeNode<>(6);
        root.right = new BinaryTreeNode<>(6);

        root.left.right = new BinaryTreeNode<>(2);
        root.right.left = new BinaryTreeNode<>(2);

        root.left.right.right = new BinaryTreeNode<>(3);
        root.right.left.left = new BinaryTreeNode<>(3);

        Assertions.assertTrue(isSymmetric(root.left, root.right));
    }

    private boolean isSymmetric(BinaryTreeNode<Integer> subTree1, BinaryTreeNode<Integer> subTree2) {
        if (subTree1 == null && subTree2 == null) {
            return true;
        } else if (subTree1 != null && subTree2 != null) {

            return subTree1.data.equals(subTree2.data) &&
                isSymmetric(subTree1.left, subTree2.right) &&
                isSymmetric(subTree1.right, subTree2.left);
        }

        //One subtree is empty the other one is not.
        return false;
    }

    @Test
    public void testSerializeBSTree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(314);
        root.left = new BinaryTreeNode<>(271);
        root.right = new BinaryTreeNode<>(451);

        root.left.left = new BinaryTreeNode<>(28);
        root.right.left = new BinaryTreeNode<>(350);

        root.left.left.right = new BinaryTreeNode<>(184);
        root.right.left.right = new BinaryTreeNode<>(371);

        BTreeSerializer<Integer> serializer = new BTreeSerializer<>();
        serializer.serialize(root);
    }

    @Test
    public void testSerializeBTree() {
        BTreeSerializer<Integer> serializer = new BTreeSerializer<>();
        serializer.serialize(root);
    }

    @Test
    public void testDeserializeBTree() {
        BTreeSerializer<Integer> serializer = new BTreeSerializer<>();
        BinaryTreeNode<Integer> bTree = serializer.deserialize(BTreeSerializer.SERIALIZED_FILE_PATH, ",");
        Assertions.assertNotNull(bTree);
    }

    @Test
    public void testBTreeAdd() {
        BinarySearchTree<Integer> bTree = new BinarySearchTree<>(314);
        bTree.add(271);
        bTree.add(451);
        bTree.add(28);
        bTree.add(350);
        bTree.add(184);
        bTree.add(371);

        Assertions.assertNotNull(bTree);
    }

    @Test
    public void testLca() {
        BTreeLca<Integer> lca = new BTreeLca<>();
        BinaryTreeNode<Integer> ancestor = lca.getAncestor(root, root.left.left, root.left.right);
        Assertions.assertNotNull(ancestor);
        Assertions.assertTrue(ancestor.data == 6);
    }

    @Test
    public void testLcaNull() {
        BTreeLca<Integer> lca = new BTreeLca<>();
        BinaryTreeNode<Integer> ancestor = lca.getAncestor(null, root.left.left, root.right.left);
        Assertions.assertNull(ancestor);
    }

    @Test
    public void testLca2() {
        BTreeLca<Integer> lca = new BTreeLca<>();
        BinaryTreeNode<Integer> ancestor = lca.lca(root, root.left.left, root.left.right);
        Assertions.assertNotNull(ancestor);
        Assertions.assertTrue(ancestor.data == 6);
    }

    public void testLcaBst() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(314);
        root.left = new BinaryTreeNode<>(271);
        root.right = new BinaryTreeNode<>(451);

        root.left.left = new BinaryTreeNode<>(28);
        root.right.left = new BinaryTreeNode<>(350);

        root.left.left.right = new BinaryTreeNode<>(184);
        root.right.left.right = new BinaryTreeNode<>(371);

        BTreeLca<Integer> bTreeLca = new BTreeLca<>();
        BinaryTreeNode<Integer> lca = bTreeLca.getAncestor(root, root.right.right, root.right.left.right);

        Assertions.assertNotNull(lca);
        Assertions.assertTrue(lca.data == 451);
    }

    @Test
    public void testLcaWithParent() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(314);

        root.left = new BinaryTreeNode<>(271);
        root.left.parent = root;
        root.right = new BinaryTreeNode<>(451);
        root.right.parent = root;

        root.left.left = new BinaryTreeNode<>(28);
        root.left.left.parent = root.left;
        root.right.left = new BinaryTreeNode<>(350);
        root.right.left.parent = root.right;

        root.left.left.right = new BinaryTreeNode<>(184);
        root.left.left.right.parent = root.left.left;
        root.right.left.right = new BinaryTreeNode<>(371);
        root.right.left.right.parent = root.right.left;

        BTreeLca<Integer> bTreeLca = new BTreeLca<>();
        BinaryTreeNode<Integer> lca = bTreeLca.lcaWithParent(root.right.left, root.right.left.right);

        Assertions.assertNotNull(lca);
    }

    @Test
    public void testBuildBinaryNumbers() {
        //Depth 0
        BinaryTreeNode<Byte> root = new BinaryTreeNode<>(Byte.decode("1"));

        //Depth 1
        root.left = new BinaryTreeNode<>(Byte.decode("0"));
        root.right = new BinaryTreeNode<>(Byte.decode("1"));

        //Depth 2
        root.left.left = new BinaryTreeNode<>(Byte.decode("0"));
        root.left.right = new BinaryTreeNode<>(Byte.decode("1"));

        root.right.right = new BinaryTreeNode<>(Byte.decode("0"));
        root.right.left = new BinaryTreeNode<>(Byte.decode("0"));

        //Depth 3
        root.left.left.left = new BinaryTreeNode<>(Byte.decode("0"));
        root.left.left.right = new BinaryTreeNode<>(Byte.decode("1"));
        root.left.right.right = new BinaryTreeNode<>(Byte.decode("1"));

        root.right.left.right = new BinaryTreeNode<>(Byte.decode("0"));
        root.right.right.right = new BinaryTreeNode<>(Byte.decode("0"));

        //Depth 4
        root.left.right.right.left = new BinaryTreeNode<>(Byte.decode("0"));

        root.right.left.right.left = new BinaryTreeNode<>(Byte.decode("1"));
        root.right.left.right.right = new BinaryTreeNode<>(Byte.decode("0"));

        //Depth 5
        root.right.left.right.left.right = new BinaryTreeNode<>(Byte.decode("1"));

        BTreeBinaryNumbers<Byte> binary = new BTreeBinaryNumbers<>();
        List<List<Byte>> numbers = binary.buildBinaryNumbers(root);
        Assertions.assertNotNull(numbers);
    }

    @Test
    public void printLeaves() {
        List<BinaryTreeNode<Integer>> leaves = new ArrayList<>();

        walkLeaves(root, leaves);

        for (BinaryTreeNode<Integer> b : leaves) {
            System.out.print(b.data + ", ");
        }
    }

    private List<BinaryTreeNode<Integer>> walkLeaves(BinaryTreeNode<Integer> node, List<BinaryTreeNode<Integer>> list) {
        if (node == null)
            return null;

        if (node.left == null && node.right == null) {
            list.add(node);
        }

        walkLeaves(node.left, list);
        walkLeaves(node.right, list);

        return list;
    }

    @Test
    public void testRootToLeaftPath() {
        boolean contains = containsLeaf(591, root, 0);
        Assertions.assertTrue(contains);
    }

    private boolean containsLeaf(int toFind, BinaryTreeNode<Integer> tree, int pathWeight) {
        if (tree == null) {
            return false;
        }

        pathWeight += tree.data;
        if (tree.right == null && tree.left == null && pathWeight == toFind) {
            return true;
        }

        return containsLeaf(toFind, tree.left, pathWeight) || containsLeaf(toFind, tree.right, pathWeight);
    }


    @Test
    public void testPathToLeaves() {
        List<Integer> paths = new ArrayList<>();

        Deque<Integer> first = new LinkedList<>();
        first.add(root.data);
        paths.addAll(pathToLeaves(619, root.left, first, 0));

        Deque<Integer> second = new LinkedList<>();
        second.add(root.data);
        paths.addAll(pathToLeaves(619, root.right, second, 0));

        Assertions.assertTrue(!paths.isEmpty());
    }

    private Deque<Integer> pathToLeaves(int toFind, BinaryTreeNode<Integer> tree, Deque<Integer> nodes,
                                             int pathWeight) {

        if (tree == null) {
            return null;
        }

        pathWeight += tree.data;
        if (pathWeight <= toFind) {
            nodes.add(tree.data);
        }

        pathToLeaves(toFind, tree.left, nodes, pathWeight);
        pathToLeaves(toFind, tree.right, nodes, pathWeight);

        return nodes;
    }

    @Test
    public void testInOrderTraversalIterative() {
        List<Integer> inOrder = inOrderTraversalIterative(root);
        Assertions.assertTrue(!inOrder.isEmpty());
    }


    private List<Integer> inOrderTraversalIterative(BinaryTreeNode<Integer> tree) {
        if (tree == null) {
            return null;
        }

        Deque<BinaryTreeNode<Integer>> stack = new LinkedList<>();

        while (tree != null) {
            stack.push(tree);
            tree = tree.left;
        }

        List<Integer> inOrderData = new ArrayList<>();

        while (!stack.isEmpty()) {
            BinaryTreeNode<Integer> current = stack.pop();
            inOrderData.add(current.data);

            if (current != null) {
                current = current.right;
            }

            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        return inOrderData;
    }

    @Test
    public void testInOrderTraversalI() {
        List<Integer> inOrder = inOrderTraversal(root);
        Assertions.assertTrue(!inOrder.isEmpty());

        System.out.print("{");
        for(Integer i : inOrder) {
            System.out.print(i + ",");
        }
        System.out.print("}");
    }

    private List<Integer> inOrderTraversal(BinaryTreeNode<Integer> tree) {
        if (tree == null) {
            return null;
        }

        BinaryTreeNode<Integer> current = tree;
        Deque<BinaryTreeNode<Integer>> stack = new LinkedList<>();
        List<Integer> nodesData = new ArrayList<>();

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                nodesData.add(current.data);
                current = current.right;
            }
        }
        return nodesData;
    }

    @Test
    public void testIfIsSubtree() {
        BinaryTreeNode root = new BinaryTreeNode("h");
        root.left = new BinaryTreeNode<>("a");
        root.right = new BinaryTreeNode<>("b");

        root.left.left = new BinaryTreeNode<>("5");
        root.right.right = new BinaryTreeNode<>("8");
        root.left.right = new BinaryTreeNode<>("6");
        root.right.left = new BinaryTreeNode<>("7");

        //Comparison Tree
        BinaryTreeNode first = new BinaryTreeNode<>("a");
        first.left = new BinaryTreeNode<>("5");
        first.right = new BinaryTreeNode<>("6");

        Assertions.assertTrue(isSubtree(first, root));
    }

    private static boolean isSubtree(BinaryTreeNode<String> first, BinaryTreeNode<String> tree) {
        if (tree == null) {
            return true;
        }

        if (first.data.equals(tree.data)) {
            return hasSameSubtree(first, tree);
        }

        return isSubtree(first, tree.left) && isSubtree(first, tree.right);
    }

    private static  boolean hasSameSubtree(BinaryTreeNode<String> first, BinaryTreeNode<String> second) {
        if (first == null && second == null) {
            return true;
        }

        if (first == null || second == null) {
            return false;
        }

        return first.data.equals(second.data) && hasSameSubtree(first.left, second.left) &&
            hasSameSubtree(first.right, second.right);
    }
}
