package graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    public Node clone(Node node) {
        if (node == null) {
            return null;
        }

        Queue<Node> queue = new ArrayDeque<>();
        Map<Node, Node> visited = new HashMap<>();

        queue.offer(node);
        visited.put(node, new Node(node.data));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node edge : current.childs) {

                if (!visited.containsKey(edge)) {
                    visited.put(edge, new Node(edge.data));
                    queue.offer(edge);
                }

                visited.get(current).childs.add(visited.get(edge)); //Important
            }
        }

        return visited.get(node);
    }

    public Node cloneTwo(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();
        helper(node, visited);

        return visited.get(node);
    }

    public void helper (Node node, Map<Node, Node> visited) {

        visited.putIfAbsent(node, new Node(node.data));

        for (Node n : node.childs) {

            if (!visited.containsKey(n)) {
                visited.put(n, new Node(n.data));
                helper(n, visited);
            }

            visited.get(node).childs.add(visited.get(n));
        }
    }
}
