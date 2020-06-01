package binarytree;

public class RedBlackTreeNode<T, K extends Comparable<K>> extends BinaryTreeNode<T> {

    private K key; //key
    private boolean color; //color of parent link
    private int size; //subtree count
    RedBlackTreeNode<T, K> left;
    RedBlackTreeNode<T, K> right;

    public RedBlackTreeNode(K key, T value, boolean color, int size) {
        this.key = key;
        this.data = value;
        this.color = color;
        this.size = size;
    }

    public K getKey() {
        return key;
    }

    public boolean getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
