package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

    public Node clone (Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();
        dfs(node, visited);
        return visited.get(node);
    }

    private void dfs(Node node, Map<Node, Node> visited) {
        visited.putIfAbsent(node, new Node(node.val));

        for (Node n : node.neighbors) {
            if (!visited.containsKey(n)) {
                visited.put(n, new Node(n.val));
                dfs(n, visited);
            }

            visited.get(node).neighbors.add(visited.get(n));
        }
    }

    private Node clone2 (Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>();

        queue.offer(node);
        visited.put(node, new Node(node.val));

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node n : current.neighbors) {
                if (!visited.containsKey(n)) {
                    visited.put(n, new Node(n.val));
                    queue.offer(n);
                }

                visited.get(current).neighbors.add(visited.get(n));
            }
        }

        return visited.get(node);
    }
}
