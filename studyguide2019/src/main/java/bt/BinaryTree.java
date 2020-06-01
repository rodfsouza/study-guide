package bt;

public class BinaryTree {

    public static class Node {
        int value;
        Node left;
        Node right;
        int depth;

        public Node(int data) {
            this.value = data;
        }

        public Node insertLeft(int nodeValue) {
            this.left = new Node(nodeValue);
            return this.left;
        }

        public Node insertRight(int nodeValue) {
            this.right = new Node(nodeValue);
            return this.right;
        }
    }

    private static class BalancedWithHeight {
        boolean balanced;
        int height;

        public BalancedWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    public boolean checkBalanced(Node root) {
        return chkBalanced(root).balanced;
    }

    private BalancedWithHeight chkBalanced(Node node) {

        if (node == null) {
            return new BalancedWithHeight(true, -1);
        }

        BalancedWithHeight left = chkBalanced(node.left);
        if (!left.balanced) {
            return left;
        }

        BalancedWithHeight right = chkBalanced(node.right);
        if (!right.balanced) {
            return right;
        }

        boolean isBalanced = Math.abs(left.height - right.height) <= 1;
        int height = 1+ Math.max(left.height, right.height);
        return new BalancedWithHeight(isBalanced, height);
    }

    public boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        if (Math.abs(lHeight - rHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.right), height(node.left));
    }


}
