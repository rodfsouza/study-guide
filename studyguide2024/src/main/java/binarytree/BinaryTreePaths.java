package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> paths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        preOrderTraversal(root, "", paths);
        return paths;
    }

    //PreOrder: root -> left -> right
    private void preOrderTraversal(TreeNode node, String str, List<String> paths) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            paths.add(str + node.val);
            return;
        }

        preOrderTraversal(node.left, str + node.val + "->", paths);
        preOrderTraversal(node.right, str + node.val + "->", paths);
    }
}
