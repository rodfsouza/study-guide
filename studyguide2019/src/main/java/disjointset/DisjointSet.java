package disjointset;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    public static class Node {
        long data;
        Node parent;
        int rank;
    }

    private final Map<Long, Node> map = new HashMap<>();

    public void makeSet(long data) {
        Node node = new Node();
        node.data = data;
        node.rank = 0;
        node.parent = node;
        map.put(data, node);
    }

    public boolean union(long data1, int data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        if (parent1.data == parent2.data) {
            return false;
        }

        if (parent1.rank >= parent2.rank) {
            parent1.rank = (parent1.rank == parent2.rank ? parent1.rank++ : parent1.rank);
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
    }

    public Node find(long data) {
        return map.get(data);
    }

    private Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }

        node.parent = findSet(node.parent);
        return node.parent;
    }
}
