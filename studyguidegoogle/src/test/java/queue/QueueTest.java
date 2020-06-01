package queue;

import binarytree.BinaryTreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class QueueTest {

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
    public void testBTreeDepthLevelArray() {
        List<List<Integer>> levelOrderTraverse = levelTraverse(root);
        Assertions.assertNotNull(levelOrderTraverse);
        printSublist(levelOrderTraverse);
    }

    @Test
    public void testReverseBinaryTreeTraversal() {
        List<List<Integer>> reverseBTree = reverseOrderTraverse(root);
        Assertions.assertNotNull(reverseBTree);
        printSublist(reverseBTree);
    }

    @Test
    public void testSpiralTraverse() {
        List<List<Integer>> spiralTraverse = spiralTraverse(root);
        Assertions.assertNotNull(spiralTraverse);
        printSublist(spiralTraverse);
    }

    @Test
    public void testCalculateAvgLevelTraverse() {
        List<String> averageLevelTraverse = calculateAvgPerLevel(root);
        Assertions.assertNotNull(averageLevelTraverse);

        System.out.print("{");
        for (String d : averageLevelTraverse) {
            System.out.print(d + ",");
        }
        System.out.print("}");
    }

    private List<List<Integer>> levelTraverse(BinaryTreeNode<Integer> node) {

        Deque<BinaryTreeNode<Integer>> level = new LinkedList<>();
        level.offer(node);

        int currentLevel = level.size();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneLevel = new ArrayList<>();

        while (!level.isEmpty()) {
            BinaryTreeNode<Integer> current = level.poll();
            --currentLevel;

            if (current != null) {
                oneLevel.add(current.data);

                level.offer(current.left);
                level.offer(current.right);
            }

            if (currentLevel == 0) {
                currentLevel = level.size();
                if (!oneLevel.isEmpty()) {
                    result.add(new ArrayList<>(oneLevel));
                    oneLevel.clear();
                }
            }
        }
        return result;
    }

    private List<List<Integer>> reverseOrderTraverse(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return new ArrayList<>();
        }

        Queue<BinaryTreeNode<Integer>> processingNodes = new LinkedList<>();
        processingNodes.add(node);
        int currentLevel = processingNodes.size();

        Stack<List<Integer>> reverseOrder = new Stack<>();
        List<Integer> oneLevel = new ArrayList<>();

        while (!processingNodes.isEmpty()) {
            BinaryTreeNode<Integer> current = processingNodes.poll();
            --currentLevel;

            if (current != null) {
                oneLevel.add(current.data);

                if (current.right != null) {
                    processingNodes.add(current.right);
                }

                if (current.left != null) {
                    processingNodes.add(current.left);
                }
            }

            if (currentLevel == 0) {
                currentLevel = processingNodes.size();
                if (!oneLevel.isEmpty()) {
                    reverseOrder.push(new ArrayList<>(oneLevel));
                    oneLevel.clear();
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        while (!reverseOrder.empty()) {
            result.add(reverseOrder.pop());
        }
        return result;
    }

    private List<List<Integer>> spiralTraverse(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneLevel = new ArrayList<>();

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();

        queue.add(node);

        while (!queue.isEmpty() || !stack.isEmpty()) {
            while (!queue.isEmpty()) {
                BinaryTreeNode<Integer> current = queue.poll();
                oneLevel.add(current.data);

                if (current.right != null) {
                    stack.push(current.right);
                }

                if (current.left != null) {
                    stack.push(current.left);
                }
            }

            if (!oneLevel.isEmpty()) {
                result.add(new ArrayList<>(oneLevel));
                oneLevel.clear();
            }

            while (!stack.isEmpty()) {
                BinaryTreeNode<Integer> curr = stack.pop();
                oneLevel.add(curr.data);

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            if (!oneLevel.isEmpty()) {
                result.add(new ArrayList<>(oneLevel));
                oneLevel.clear();
            }
        }

        return result;
    }

    private List<String> calculateAvgPerLevel(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return new ArrayList<>();
        }

        Queue<BinaryTreeNode<Integer>> processingNodes = new LinkedList<>();
        processingNodes.add(node);

        int numberOfNodesAtLevel = processingNodes.size();

        List<Integer> oneLevel = new ArrayList<>();
        List<String> result = new ArrayList<>();

        while (!processingNodes.isEmpty()) {
            BinaryTreeNode<Integer> current = processingNodes.poll();
            --numberOfNodesAtLevel;

            if (current != null) {
                oneLevel.add(current.data);

                if (current.left != null) {
                    processingNodes.add(current.left);
                }

                if (current.right != null) {
                    processingNodes.add(current.right);
                }
            }

            if (numberOfNodesAtLevel == 0) {
                numberOfNodesAtLevel = processingNodes.size();

                if (!oneLevel.isEmpty()) {
                    int numberOfNodesAtThisLevel = oneLevel.size();
                    double sum = 0;
                    for (Integer i : oneLevel) {
                        sum += i;
                    }

                    DecimalFormat formatter = new DecimalFormat("#.##");
                    result.add(formatter.format(sum / numberOfNodesAtThisLevel));
                    oneLevel.clear();
                }
            }
        }

        return result;
    }

    private void printList(List<Integer> list) {
        Iterator<Integer> it = list.iterator();

        System.out.print("{");

        while (it.hasNext()) {
            System.out.print(it.next());

            if (it.hasNext()) {
                System.out.print(", ");
            }
        }

        System.out.print("}");
    }

    private void printSublist(List<List<Integer>> list) {
        for (List<Integer> sublist : list) {
            System.out.print("{");
            Iterator<Integer> it = sublist.iterator();
            while (it.hasNext()) {
                Integer i = it.next();
                System.out.print(i);

                if (it.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.print("}, ");
        }
    }
}
