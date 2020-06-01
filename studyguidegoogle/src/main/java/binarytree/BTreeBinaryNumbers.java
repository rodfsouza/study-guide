package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BTreeBinaryNumbers<T extends Comparable<T>> {

    private List<List<T>> binaryGroups = new ArrayList<>();

    public List<List<T>> buildBinaryNumbers(BinaryTreeNode<T> node) {
        Deque<T> nodesData = new LinkedList<>();
        preOrder(node.left, node, nodesData);
        preOrder(node.right, node, nodesData);
        return Collections.unmodifiableList(binaryGroups);
    }

    private BinaryTreeNode<T> preOrder(BinaryTreeNode<T> node, BinaryTreeNode<T> root, Deque<T> nodes) {
        if (node == null) {
            return null;
        }

        nodes.add(node.data);
        node.left = preOrder(node.left, root,nodes);
        node.right = preOrder(node.right, root,nodes);

        nodes.addFirst(root.data);
        binaryGroups.add(new ArrayList<>(nodes));

        nodes.removeFirst();
        nodes.removeLast();

        return node;
    }

}
