package binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements BTree<T> {

    BinaryTreeNode<T> root;

    public BinarySearchTree(T data) {
        root = new BinaryTreeNode<>(data);
    }

    @Override
    public void add(T data) {
        addHelper(data, root);
    }

    private BinaryTreeNode<T> addHelper(T data, BinaryTreeNode<T> node) {
        if (node == null) {
            node = new BinaryTreeNode(data);
        } else {
            if (data.compareTo(node.data) <= 0) {
                node.left = addHelper(data, node.left);
            } else {
                node.right = addHelper(data, node.right);
            }
        }
        return node;
    }

    @Override
    public void delete(T data) {

    }

    @Override
    public BinaryTreeNode<T> find(T data) {
        return find(data, root);
    }

    private BinaryTreeNode<T> findHelper(T data, BinaryTreeNode<T> node) {
        boolean found = false;
        while (node != null && !found) {
            if (data.compareTo(node.data) < 0) {
                node = node.left;
            } else if (data.compareTo(node.data) > 0) {
                node = node.right;
            } else {
                found = true;
                break;
            }

            findHelper(data, node);
        }
        return node;
    }

    private BinaryTreeNode<T> find(T data, BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.data) < 0) {
            return find(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            return find(data, node.right);
        } else {
            return node;
        }
    }

    public List<List<T>> levelTraverse() {

        Deque<BinaryTreeNode<T>> level = new LinkedList<>();
        level.offer(root);

        int currentLevel = level.size();
        List<List<T>> result = new ArrayList<>();
        List<T> oneLevel = new ArrayList<>();

        while (!level.isEmpty()) {
            BinaryTreeNode<T> current = level.poll();
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

    @Override
    public List<BinaryTreeNode<T>> inOrder() {
        List<BinaryTreeNode<T>> result = new ArrayList<>();
        return inOrder(root, result);
    }

    private List<BinaryTreeNode<T>> inOrder(BinaryTreeNode<T> node, List<BinaryTreeNode<T>> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node);
            inOrder(node.right, list);
        }
        return list;
    }

    @Override
    public List<BinaryTreeNode<T>> preOrder() {
        List<BinaryTreeNode<T>> result = new ArrayList<>();
        return preOrder(root, result);
    }

    private List<BinaryTreeNode<T>> preOrder(BinaryTreeNode<T> node, List<BinaryTreeNode<T>> list) {
        if (node != null) {
            list.add(node);
            preOrder(node.left, list);
            preOrder(node.right, list);
        }
        return list;
    }

    @Override
    public List<BinaryTreeNode<T>> postOrder() {
        List<BinaryTreeNode<T>> result = new ArrayList<>();
        return postOrder(root, result);
    }

    private List<BinaryTreeNode<T>> postOrder(BinaryTreeNode<T> node, List<BinaryTreeNode<T>> list) {
        if (node != null) {
            postOrder(node.left, list);
            postOrder(node.right, list);
            list.add(node);
        }
        return list;
    }
}
