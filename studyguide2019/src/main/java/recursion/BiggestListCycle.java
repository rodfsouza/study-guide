package recursion;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Runtime: O (n) - Where n is the size of the LinkedList
 * Why? Because we touch a node only one at the time.
 */
public class BiggestListCycle {

    public static class Node {
        int data;
        Node parent;
        Node next;
        Node down;
    }

    class Biggest {
        int numNodes;
    }

    public int largestCycle(Node node) {
        Node current = node;
        Set<Node> visited = new HashSet<>();
        PriorityQueue<Integer> largest = new PriorityQueue<>(Comparator.reverseOrder());

        while (current != null) {
            Biggest big = new Biggest();
            if (current.down != null && !visited.contains(current)) {
                hasCycle(current, visited, big);
                largest.add(big.numNodes);
            }
            current = current.next;
        }
        return largest.peek();
    }

    private void hasCycle(Node node, Set<Node> visited, Biggest numNodes) {
        if (node == null || visited.contains(node)) {
            return;
        }

        visited.add(node);
        hasCycle(node.down, visited, numNodes);
        numNodes.numNodes++;
        hasCycle(node.parent, visited, numNodes);
    }
}
