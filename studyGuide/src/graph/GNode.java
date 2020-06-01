package graph;

import java.util.LinkedList;

public class GNode<T> {

    private final T data;
    private boolean isVisited;
    private final LinkedList<GNode<T>> child;

    public GNode(T value) {
        data = value;
        child = new LinkedList<>();
    }

    public T getData() {
        return data;
    }

    public LinkedList<GNode<T>> getChild() {
        return child;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
