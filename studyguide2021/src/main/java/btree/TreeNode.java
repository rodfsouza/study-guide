package btree;

public class TreeNode<T> {

    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T value) {
        this.data = value;
    }
}
