package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Digraph {

    private int vertices;
    private int[] inDegree;
    private List<Integer> adjacents[];

    public Digraph(final int numberOfVertices) {
        if (numberOfVertices < 0) {
            throw new IllegalArgumentException();
        }

        vertices = numberOfVertices;
        inDegree = new int[vertices];
        adjacents = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacents[i] = new LinkedList<>();
        }
    }

    public void addEdge(final int v, final int u) {
        adjacents[v].add(u);
        inDegree[u]++;
    }

    public Stack<Integer> topologicalSort() {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> topOrder = new Stack<>();
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, topOrder, visited);
            }
        }
        return topOrder;
    }

    private void dfs(int v, Stack<Integer> stack, boolean[] visited) {
        visited[v] = true;
        for (int i : adjacents[v]) {
            if (!visited[i]) {
                dfs(i, stack, visited);
            }
        }
        stack.push(v);
    }

    public List<Integer> kahnTopologicalSort() {
        Queue<Integer> navigation = new ArrayDeque<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                navigation.offer(i);
            }
        }

        int numberOfVertices = 0;
        List<Integer> topOrder = new ArrayList<>();

        while(!navigation.isEmpty()) {
            int item = navigation.poll();
            topOrder.add(item);

            for (int i : adjacents[item]) {
                if (--inDegree[i] == 0) {
                    navigation.offer(i);
                }
            }
            numberOfVertices++;
        }

        if (numberOfVertices != vertices) {
            throw new IllegalStateException("There is at least on cycle on the graph");
        }

        return topOrder;
    }
}
