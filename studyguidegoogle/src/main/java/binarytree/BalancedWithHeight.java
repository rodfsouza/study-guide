package binarytree;

public class BalancedWithHeight<T> {

    public boolean balanced;
    public int height;

    public BalancedWithHeight(boolean balanced, int height) {
        this.balanced = balanced;
        this.height = height;
    }

    public BalancedWithHeight() {

    }

    public boolean isBalanced(BinaryTreeNode<T> node) {
        return checkBalanced(node).balanced;
    }

    public int getHeight(BinaryTreeNode<T> node) {
        return checkBalanced(node).height;
    }

    public BalancedWithHeight<T> checkBalanced(BinaryTreeNode<T> node) {
        if (node == null) {
            return new BalancedWithHeight<>(true, -1);
        }

        BalancedWithHeight<T> leftResult = checkBalanced(node.left);
        if (!leftResult.balanced) {
            return leftResult;
        }

        BalancedWithHeight<T> rightResult = checkBalanced(node.right);
        if (!rightResult.balanced) {
            return rightResult;
        }

        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;

        return new BalancedWithHeight<>(isBalanced, height);
    }
}
