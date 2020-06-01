package binarytree;

import java.util.List;

public interface BTree<T extends Comparable<T>> {
    void add(T data);
    void delete(T data);
    BinaryTreeNode<T> find(T data);
    List<BinaryTreeNode<T>> inOrder();
    List<BinaryTreeNode<T>> preOrder();
    List<BinaryTreeNode<T>> postOrder();
}
