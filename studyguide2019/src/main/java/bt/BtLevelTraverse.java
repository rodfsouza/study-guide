package bt;

import bt.BinaryTree.Node;

import java.util.*;

public class BtLevelTraverse {

    public static class NodeLevel {
        Node node;
        int level;

        public NodeLevel(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelTraverse(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<NodeLevel> level = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        level.offer(new NodeLevel(root, 0));

        while (!level.isEmpty()) {
            NodeLevel curr = level.poll();

            if (result.get(curr.level) == null) {
                List<Integer> oneLevel = new ArrayList<>();
                oneLevel.add(curr.node.value);
                result.add(oneLevel);
            } else {
                List<Integer> atLevel = result.get(curr.level);
                atLevel.add(curr.node.value);
                result.add(curr.level, atLevel);
            }

            if (curr.node.left != null) {
                level.offer(new NodeLevel(curr.node.left, curr.level + 1));
            }

            if (curr.node.right != null) {
                level.offer(new NodeLevel(curr.node.left, curr.level + 1));
            }
        }
        return result;
    }

    public List<List<Integer>> levelTraverse2(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<Node> level = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        level.offer(root);

        int currentLevel = level.size();
        List<Integer> oneLevel = new ArrayList<>();

        while (!level.isEmpty()) {
            Node curr = level.poll();
            --currentLevel;

            oneLevel.add(curr.value);

            if (curr.left != null) {
                level.offer(curr.left);
            }

            if (curr.right != null) {
                level.offer(curr.right);
            }

            if (currentLevel == 0) {
                currentLevel = level.size();
                if (!oneLevel.isEmpty()) {
                    result.add(new ArrayList<>(oneLevel));
                    oneLevel.clear();
                }
            }
        }
        return result;
    }

    public List<List<Integer>> recursiveLevelTraverse(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        recursiveLevelTraverse(root, 0, result);
        return result;
    }

    private void recursiveLevelTraverse(Node node, int level, List<List<Integer>> output) {
        if (node == null) {
            return;
        }

        List<Integer> oneLevel = output.get(level) != null ? output.get(level) : new ArrayList<>();
        oneLevel.add(node.value);
        output.add(level, oneLevel);

        recursiveLevelTraverse(node.left, level + 1, output);
        recursiveLevelTraverse(node.right, level + 1, output);
    }
}
