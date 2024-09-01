package binarytree;

import java.util.*;

public class BinaryTreeVerticalTraversal {

    public List<List<Integer>> traversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<NodeCol> queue = new LinkedList<>();
        queue.add(new NodeCol(root, 0));

        while (!queue.isEmpty()) {
            NodeCol nodeCol = queue.poll();
            TreeNode node = nodeCol.node;
            int col = nodeCol.col;

            if (!map.containsKey(col)) {
                map.put(col, new LinkedList<>());
            }
            map.get(col).add(node.val);

            if (node.left != null) {
                queue.add(new NodeCol(node.left, col - 1));
            }

            if (node.right != null) {
                queue.add(new NodeCol(node.right, col + 1));
            }
        }

        List<List<Integer>> results = new ArrayList<>();
        for (int col : map.keySet()) {
            results.add(map.get(col));
        }

        return results;
    }

    static class NodeCol {
        TreeNode node;
        int col;

        public NodeCol(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}
