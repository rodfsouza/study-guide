package binarytree;

import java.util.List;

public class RedBlackTree<T extends Comparable<T>, K extends Comparable<K>> implements BTree<T> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private RedBlackTreeNode<T,K> root;

    public RedBlackTree() {

    }

    private boolean isRed(RedBlackTreeNode<T, K> node) {
        if (node == null) return false;
        return node.getColor() == RED;
    }

    private int size(RedBlackTreeNode<T, K> node) {
        if (node == null) return 0;
        return node.getSize();
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public T get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return get(root, key);
    }

    private T get(RedBlackTreeNode<T, K> node, K key) {
        while (node != null) {
            if (key.compareTo(node.getKey()) < 0) {
                node = node.left;
            } else if (key.compareTo(node.getKey()) > 0) {
                node = node.right;
            } else {
                return node.data;
            }
        }
        return null;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public void put(K key, T data) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        if (data == null) {
            //delete(key);
            return;
        }

        root = put(root, key, data);
        root.setColor(BLACK);
    }

    private RedBlackTreeNode<T, K> put(RedBlackTreeNode<T,K> node, K key, T value) {
        if (node == null) {
            return new RedBlackTreeNode<>(key, value, RED, 1);
        }

        int compare = key.compareTo(root.getKey());
        if (compare < 0) {
            node.left = put(root.left, key, value);
        } else if (compare > 0) {
            node.right = put(root.right, key, value);
        } else {
            node.data = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        node.setSize(size(node.left) + size(node.right) + 1);

        return node;
    }

    private RedBlackTreeNode<T, K> rotateLeft(RedBlackTreeNode<T, K> node) {
        RedBlackTreeNode<T, K> leftRotate = node.right;
        node.right = leftRotate.left;
        leftRotate = node;
        leftRotate.setColor(leftRotate.left.getColor());
        leftRotate.left.setColor(RED);
        leftRotate.setSize(node.getSize());
        node.setSize(size(node.left) + size(node.right) + 1);

        return leftRotate;
    }


    private RedBlackTreeNode<T, K> rotateRight(RedBlackTreeNode<T, K> node) {
        RedBlackTreeNode<T, K> rightRotate = node.left;
        node.left = rightRotate.right;
        rightRotate = node;
        rightRotate.setColor(rightRotate.right.getColor());
        rightRotate.right.setColor(RED);
        rightRotate.setSize(node.getSize());
        node.setSize(size(node.left) + size(node.right) + 1);

        return rightRotate;
    }

    private void flipColors(RedBlackTreeNode<T, K> node) {
        node.setColor(!node.getColor());
        node.left.setColor(!node.left.getColor());
        node.right.setColor(!node.right.getColor());
    }

    @Override
    public void add(T data) {

    }

    @Override
    public void delete(T data) {

    }

    @Override
    public BinaryTreeNode<T> find(T data) {
        return null;
    }

    @Override
    public List<BinaryTreeNode<T>> inOrder() {
        return null;
    }

    @Override
    public List<BinaryTreeNode<T>> preOrder() {
        return null;
    }

    @Override
    public List<BinaryTreeNode<T>> postOrder() {
        return null;
    }
}
