package bt;

import bt.BinarySearchTree.Node;

public class BinaryTreeIsBST {

    private Integer lastSeen = null;

    public boolean isBst(Node root) {
        return chkBst(root);
    }

    private boolean chkBst(Node node) {
        if (node == null) {
            return true;
        }

        if (!chkBst(node.left)) {
            return false;
        }

        if (lastSeen != null && node.data <= lastSeen) {
            return false;
        }
        lastSeen = node.data;

        if (!chkBst(node.right)) {
            return false;
        }
        return true;
    }

    public boolean isBst2(Node root) {
        return chkBst(root, null, null);
    }

    private boolean chkBst(Node node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if (min != null && node.data <= min || max != null && node.data > max) {
            return false;
        }
        if (!chkBst(node.left, min, node.data) || !chkBst(node.right, node.data, max)) {
            return false;
        }
        return true;
    }
}
