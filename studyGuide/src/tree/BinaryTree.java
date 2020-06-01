package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {

    public BinaryTreeNode<Integer> root;

    public BinaryTree(int value) {
        root = new BinaryTreeNode<>(value);
    }

    public void setPointer(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int nodeLevel = q.size();
            if (q.size() == 0) {
                return;
            }

            while (nodeLevel > 0) {
                BinaryTreeNode<Integer> curr = q.poll();
                if (curr.left != null) {
                    if (curr.right != null) {
                        curr.left.pointer = curr.right;
                    }
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
                nodeLevel--;
            }
        }
    }

    public boolean isSymmetric(BinaryTreeNode<Integer> tree) {
        return tree == null || isSymmetric(tree.left, tree.right);
    }

    public BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> node0, BinaryTreeNode<Integer> node1) {
        return lcaHelper(tree, node0, node1).ancestor;
    }

    private Status lcaHelper(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> node0, BinaryTreeNode<Integer> node1) {
        if (tree == null) {
            return new Status(0, null);
        }

        Status left = lcaHelper(tree.left, node0, node1);
        if (left.numTargetNodes == 2) {
            return left;
        }

        Status right = lcaHelper(tree.right, node0, node1);
        if (right.numTargetNodes == 2) {
            return right;
        }

        int numTargetNodes = left.numTargetNodes + right.numTargetNodes + (tree.equals(node0) ? 1 : 0) + (tree.equals(node1) ? 1 : 0);

        return new Status(numTargetNodes, numTargetNodes == 2 ? tree : null);
    }

    private boolean isSymmetric(BinaryTreeNode<Integer> leftTree, BinaryTreeNode<Integer> rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        } else if (leftTree != null && rightTree != null) {
            return leftTree.data == rightTree.data
                && isSymmetric(leftTree.left, rightTree.right)
                && isSymmetric(rightTree.right, leftTree.left);
        }
        return false;
    }

    private static class Status {
        private int numTargetNodes;
        private BinaryTreeNode<Integer> ancestor;

        public Status(int numTargetNodes, BinaryTreeNode<Integer> node) {
            this.numTargetNodes = numTargetNodes;
            this.ancestor = node;
        }
    }

    private static class BalanceStatusWithHeight {
        public boolean balanced;
        public int height;

        public BalanceStatusWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }

        public boolean isBalanced(BinaryTreeNode<Integer> tree) {
            return checkBalanced(tree).balanced;
        }

        public static BalanceStatusWithHeight checkBalanced(BinaryTreeNode<Integer> tree) {
            if (tree == null) {
                return new BalanceStatusWithHeight(true, -1);
            }

            BalanceStatusWithHeight left = checkBalanced(tree.left);
            if (!left.balanced) {
                return left;
            }

            BalanceStatusWithHeight right = checkBalanced(tree.right);
            if (!right.balanced) {
                return right;
            }

            boolean isBalanced = Math.abs(left.height - right.height) <= 1;
            int height = Math.max(left.height, right.height) + 1;

            return new BalanceStatusWithHeight(isBalanced, height);
        }
    }
}
