package tree;

public class BinaryTreeNode<T> {

    public T data;
    public BinaryTreeNode<T> left, right;
    public BinaryTreeNode<T> pointer;

    public BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}
