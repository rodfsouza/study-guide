package btree;

import java.util.*;

public class Codec {

    private static final String DELIMITER = ",";

    private static final String MARKER = "#";

    public String serialize(TreeNode<Integer> node) {

        if (node == null) {
            return MARKER;
        }

        StringBuilder sb = new StringBuilder();
        preOrderSerialize(node, sb);
        return sb.toString();
    }

    /*
    Pre-order traversal saving into a StringBuilder.
     */
    private void preOrderSerialize(TreeNode<Integer> node, StringBuilder sb) {
        if (node != null){
            sb.append(node.data).append(DELIMITER);
            preOrderSerialize(node.left, sb);
            preOrderSerialize(node.right, sb);
        } else {
            sb.append(MARKER).append(DELIMITER);
        }
    }

    public TreeNode<Integer> deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] nodes = data.split(DELIMITER);
        Queue<String> queue = new LinkedList<>();

        for (String node : nodes) {
            queue.offer(node);
        }

        TreeNode<Integer> tree = buildTree(queue);
        return tree;
    }

    private TreeNode<Integer> buildTree(Queue<String> nodes) {

        String data = nodes.poll();
        if (data.equals(MARKER)) {
            return null;
        }

        TreeNode<Integer> node = new TreeNode<>(Integer.parseInt(data));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);

        return node;
    }


}
