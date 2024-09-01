package binarytree;

public class KthSmallestElementBST {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    //InOrder: left -> root -> right
    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, k);

        if (++count == k) {
            result = node.val;
            return;
        }

        inOrderTraversal(node.right, k);
    }
}
