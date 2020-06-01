package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Digraph2<T> {

    private final int vertices;
    private final int[] inDegree;
    private final GNode[] adjacents;

    public Digraph2(final int numberOfVertices) {
        if (numberOfVertices < 0) {
            throw new IllegalArgumentException();
        }

        vertices = numberOfVertices;
        inDegree = new int[vertices];
        adjacents = new GNode[vertices];

        for (int v = 0; v < vertices; v++) {
            adjacents[v] = new GNode(v);
        }
    }

    public void addEdge(int v, int w) {
        adjacents[v].getChild().add(w);
        inDegree[w]++;
    }

    public List<T> topologicalOrder() {

        Deque<GNode> q = new ArrayDeque<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                q.offer(adjacents[i]);
            }
        }

        List<T> topOrder = new ArrayList<>();
        while (!q.isEmpty()) {
            GNode current = q.poll();
            topOrder.add((T) current.getData());

            for (Object o : current.getChild()) {
                Integer i = (Integer) o;
                if (--inDegree[i] == 0) {
                    q.offer(adjacents[i]);
                }
            }
        }
        return topOrder;
    }

    public List<T> topologicalSortDfs() {
        Stack<GNode> stack = new Stack<>();
        for (int i = 0; i < vertices; i++) {
            if (!adjacents[i].isVisited()) {
                dfs(i, stack, adjacents[i]);
            }
        }

        List<T> topOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topOrder.add((T) stack.pop().getData());
        }

        return topOrder;
    }

    private void dfs(int v, Stack<GNode> stack, GNode node) {
        node.setVisited(true);
        for (Object o : adjacents[v].getChild()) {
            Integer i = (Integer) o;
            if (!adjacents[i].isVisited()) {
                dfs(i, stack, adjacents[i]);
            }
        }
        stack.push(adjacents[v]);
    }
}
