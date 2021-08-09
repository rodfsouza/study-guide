package graph;

import java.util.LinkedList;
import java.util.List;

public class Node {
    public enum Color {
        WHITE, //Starting
        GRAY, //in use
        BLACK //Dead end
    };

    int data;
    public List<Node> childs;
    public Color color;

    public Node(int data) {
        this.data = data;
        childs = new LinkedList<>();
    }
}
