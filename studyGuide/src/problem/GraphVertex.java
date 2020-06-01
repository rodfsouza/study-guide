package problem;

import java.util.List;

//Follow-up: How would you decide which process should be killed?
public class GraphVertex {

    enum Color {
        WHITE, GRAY, BLACK;
    }

    List<GraphVertex> edges;
    Color color;

    public boolean isDeadlocked(GraphVertex graph) {
        if (graph == null) {
            return false;
        }

        for (GraphVertex edge : graph.edges) {
            if (edge.color == Color.WHITE && hasCycle(edge, null)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(GraphVertex current, GraphVertex pre) {
        if (current.color == Color.GRAY) {
            return true;
        }

        for (GraphVertex next : current.edges) {
            if (next != pre && next.color != Color.GRAY) {
                if (hasCycle(next, current)) {
                    return true;
                }
            }
        }

        current.color = Color.BLACK;
        return false;
    }
}
