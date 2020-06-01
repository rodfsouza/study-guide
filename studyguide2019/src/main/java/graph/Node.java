package graph;

import java.util.LinkedList;
import java.util.List;

public class Node {

    int data;
    List<Node> childs;

    public Node(int data) {
        this.data = data;
        childs = new LinkedList<>();
    }
}
