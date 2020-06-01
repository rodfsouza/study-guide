package graph;

import heap.BinaryMinHeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimMinimumSpanningTree {

    public List<Node> primMST(Node graph) {
        //Binary heap + map data structure
        BinaryMinHeap<Node> minHeap = new BinaryMinHeap<>();

        //map of vertex to edge which gave minimum weight to this vertex.
        Map<Node, Edge<Node>> vertexToEdge = new HashMap<>();

        //final result
        List<Edge<Node>> result = new ArrayList<>();

        //insert all vertices with infinite value initially.
        for (Node child : graph.childs) {
            minHeap.add(child, Integer.MAX_VALUE);
        }

        //starts from any vertex
        Node startVertex = graph.childs.iterator().next();

        //for the start vertex decrease the value to in heap + map to 0;
        minHeap.decrease(startVertex, 0);

        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll(); //extract min
        }
        return null;
    }

    private class Edge<T> {
        private T vertex1;
        private T vertex2;
        private int weight;

        Edge(T vertex1, T vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }
    }
}
