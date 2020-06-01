package tree;

/**
 * Created by rodsou on 11/9/16.
 */
public interface Tree<T extends Comparable<T>> {
  void add(T t);
  boolean find(T t);
  boolean isEmpty();
  int size();
  void inOrder(BTreeNode node);
  void preOrder(BTreeNode node);
  void postOrder(BTreeNode node);
}
