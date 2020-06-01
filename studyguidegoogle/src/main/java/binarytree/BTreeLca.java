package binarytree;

import java.util.HashSet;
import java.util.Set;

public class BTreeLca<T extends Comparable<T>> {

    private static class Status<T extends Comparable<T>> {
        int numTargetNodes;
        BinaryTreeNode<T> ancestor;

        public Status(int numTargetNodes, BinaryTreeNode<T> node) {
            this.numTargetNodes = numTargetNodes;
            this.ancestor = node;
        }
    }

    public BinaryTreeNode<T> getAncestor(BinaryTreeNode<T> tree, BinaryTreeNode<T> node1, BinaryTreeNode<T> node2) {
        return LcaHelper(tree, node1, node2).ancestor;
    }

    private Status<T> LcaHelper(BinaryTreeNode<T> tree, BinaryTreeNode<T> node1, BinaryTreeNode<T> node2) {
        if (tree == null) {
            return new Status<>(0, null);
        }

        Status left = LcaHelper(tree.left, node1, node2);
        if (left.numTargetNodes == 2) {
            return left;
        }

        Status right = LcaHelper(tree.right, node1, node2);
        if (right.numTargetNodes == 2) {
            return right;
        }

        int numTargetNodes = left.numTargetNodes + right.numTargetNodes + (tree == node1 ? 1 : 0) + (tree == node2 ? 1 : 0);
        return new Status(numTargetNodes, numTargetNodes == 2 ? tree : null);
    }

    public BinaryTreeNode<T> lca(BinaryTreeNode<T> tree, BinaryTreeNode<T> node1, BinaryTreeNode<T> node2) {
        if (tree == null) {
            return null;
        }

        if (tree == node1 || tree == node2) {
            return tree;
        }

        BinaryTreeNode<T> left = lca(tree.left, node1, node2);
        BinaryTreeNode<T> right = lca(tree.right, node1, node2);

        if (left != null && right != null) {
            return tree;
        }

        return (left != null ? left : right);
    }

    @Deprecated
    public BinaryTreeNode<T> lcaBst(BinaryTreeNode<T> tree, BinaryTreeNode<T> node1, BinaryTreeNode<T> node2) {
        if (tree == null) {
            return null;
        }

        if (tree.data.compareTo(node1.data) > 0 && tree.data.compareTo(node2.data) > 0) {
            return lcaBst(tree.left, node1, node2);
        }

        if (tree.data.compareTo(node1.data) < 0 && tree.data.compareTo(node2.data) < 0) {
           return lcaBst(tree.right, node1, node2);
        }

        return tree;
    }

    public BinaryTreeNode<T> lcaWithParent(BinaryTreeNode<T> node1, BinaryTreeNode<T> node2) {
        if (node1 == null || node2 == null) {
            return null;
        }
        return lcaWithParent(node1, node2, new HashSet<>());
    }

    private BinaryTreeNode<T> lcaWithParent(BinaryTreeNode<T> node1, BinaryTreeNode<T> node2,
                                           Set<BinaryTreeNode<T>> searchPath) {

        while (node1.parent != null) {
            node1 = node1.parent;
            searchPath.add(node1);
        }

        BinaryTreeNode<T> lca = node2;
        while (lca.parent != null) {
            if (searchPath.contains(lca)) {
                break;
            }
            lca = lca.parent;
        }

        return lca;
    }
}
