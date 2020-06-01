package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class TopologicalSort {

    public Deque<Node> topSort(Node graph) {
        if (graph == null) {
            return null;
        }

        Deque<Node> stack = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();

        for (Node child : graph.childs) {
            if (visited.contains(child)) {
                continue;
            }
            topSortUtil(child, visited, stack);
        }
        return stack;
    }

    private void topSortUtil(Node node, Set<Node> visited, Deque<Node> stack) {
        if (node == null || visited.contains(node)) {
            return;
        }

        visited.add(node);
        for (Node child : node.childs) {
            if (visited.contains(child)) {
                continue;
            }
            topSortUtil(child, visited, stack);
        }
        stack.offerFirst(node);
    }
}
