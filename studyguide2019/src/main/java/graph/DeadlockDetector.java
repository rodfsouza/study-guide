package graph;

import java.util.List;

public class DeadlockDetector {

    public static boolean isDeadlocked(List<Node> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return false;
        }

        for (Node node : nodes) {
            if (node.color == Node.Color.WHITE && hasCycle(node, null)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(Node curr, Node pre) {
        //Visiting a gray vertex means a cycle
        if (curr.color == Node.Color.GRAY) {
            return true;
        }

        curr.color = Node.Color.GRAY; //visits the node

        for (Node node : curr.childs) {
            if (node != pre && node.color != Node.Color.BLACK) {
                if (hasCycle(node, curr)) {
                    return true;
                }
            }
        }

        curr.color = Node.Color.BLACK;
        return false;
    }
}
