package bt;

import java.util.*;

public class BTreeNode<T> {
    T value;
    BTreeNode<T> left;
    BTreeNode<T> right;
    BTreeNode<T> next;

    public BTreeNode(T data) {
        this.value = data;
    }

    public BTreeNode<T> levelTraverseUpdatingNextPointer(BTreeNode<T> root) {

        if (root == null) {
            throw new IllegalArgumentException();
        }

        Queue<BTreeNode<T>> queue = new ArrayDeque<>();
        queue.offer(root);
        int size = 0;

        while (!queue.isEmpty()) {

            size = queue.size();
            BTreeNode<T> lastSeenNode = null;

            for (int i = 0; i < size; ++i) {
                BTreeNode<T> current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }

                if (lastSeenNode == null) {
                    lastSeenNode = current;
                } else {
                    lastSeenNode.next = current;
                    lastSeenNode = lastSeenNode.next;
                }
            }
        }

        return root;
    }

    public List<List<BTreeNode<T>>> levelOrderBottom(BTreeNode<T> root) {
        if (root == null) {
            return new LinkedList<>();
        }

        LinkedList<List<BTreeNode<T>>> results = new LinkedList<>(); //Stack
        Queue<BTreeNode<T>> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<BTreeNode<T>> levelNodes = new LinkedList<>(); //Queue

            for (int i = 0; i < size; ++i) {
                BTreeNode<T> current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }

                levelNodes.addLast(current); //Queue
            }

            results.addFirst(levelNodes); //Stack
        }

        return results;
    }

    public List<T> preOrderTraversal(BTreeNode<T> root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<T> results = new LinkedList<>();
        preOrderLevelOrder(root, results, 1);

        return results;
    }

    private void preOrderLevelOrder(BTreeNode<T> node, List<T> values, int currentLevel) {
        if (node == null) {
            return;
        }

        if (currentLevel > values.size()) {
            values.add(node.value);
        }

        preOrderLevelOrder(node.right, values, currentLevel + 1);
        preOrderLevelOrder(node.left, values, currentLevel + 1);
    }
}
