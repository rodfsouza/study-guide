package tree;

/**
 * Created by rodsou on 11/9/16.
 */
public class BTreeNode<T extends Comparable<T>> {
  BTreeNode<T> right;
  BTreeNode<T> left;
  T value;

  public BTreeNode(T value) {
    this.value = value;
  }
}
