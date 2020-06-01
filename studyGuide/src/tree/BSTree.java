package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rodsou on 11/9/16.
 */
public class BSTree<T extends Comparable<T>> implements Tree<T> {
  BTreeNode<T> root;

  public BSTree(T t) {
    root = new BTreeNode<>(t);
  }

  @Override
  public void add(T t) {
    add(t, root);
  }

  private BTreeNode add(T t, BTreeNode node) {
    if (node == null) {
      node = new BTreeNode(t);
    } else {
      if (node.value.compareTo(t) > 0) {
        node.left = add(t, node.left);
      } else {
        node.right = add(t, node.right);
      }
    }
    return node;
  }

  @Override
  public boolean find(T t) {
    return find(t, root);
  }

  private boolean find(T t, BTreeNode node) {
    boolean found = false;
    while (node != null && !found) {
      if (node.value.compareTo(t) > 0) {
        node = node.left;
      } else if (node.value.compareTo(t) < 0) {
        node = node.right;
      } else {
        found = true;
        break;
      }
      find(t, node);
    }
    return found;
  }

  @Override
  public boolean isEmpty() {
    return root == null;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public void inOrder(BTreeNode root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    print(root.value);
    inOrder(root.right);
  }

  @Override
  public void preOrder(BTreeNode root) {
    if (root == null) {
      return;
    }
    print(root.value);
    preOrder(root.left);
    preOrder(root.right);
  }

  @Override
  public void postOrder(BTreeNode root) {
    if (root == null) {
      return;
    }
    postOrder(root.left);
    postOrder(root.right);
    print(root.value);
  }

  private void print(Comparable t) {
    System.out.print(t.toString() + ",");
  }

  public List<BTreeNode> findDuplicateSubtrees(BTreeNode root) {
    Map<Integer, BTreeNode> roots = new HashMap<>();
    List<BTreeNode> subtrees = new ArrayList<>();

    findSubtrees(roots, root);

    for (Map.Entry<Integer, BTreeNode> node : roots.entrySet()) {
      subtrees.add(node.getValue());
    }
    return subtrees;
  }

  private List<BTreeNode> findSubtrees(Map<Integer, BTreeNode> roots, List<BTreeNode> subtrees, BTreeNode node) {
    if (node == null) {
      return null;
    }

    findSubtrees(roots, subtrees, node.left);
    findSubtrees(roots, subtrees, node.right);

    if (roots.containsKey(node.value)) {
      subtrees.add(roots.get(node.value));
    }
    roots.putIfAbsent((Integer) node.value, node);
    return subtrees;
  }

  private Map<Integer, BTreeNode> findSubtrees(Map<Integer, BTreeNode> roots, BTreeNode node) {
    if (node == null) {
      return null;
    }

    findSubtrees(roots, node.left);
    findSubtrees(roots, node.right);

    roots.putIfAbsent((Integer) node.value, node);
    return roots;
  }

  public boolean isBst(BTreeNode root) {
    return isBst(root, Integer.MIN_VALUE);
  }

  private boolean isBst(BTreeNode root, int previous) {
    if (root == null) {
      return true;
    }

    if (isBst(root.left, previous)) {
      if (root.value.compareTo(previous) > 0) {
        previous = (Integer) root.value;
        return isBst(root.right, previous);
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

}
