package btree;

import java.util.Iterator;
import java.util.LinkedList;

public class InOrderIterator<T> implements Iterator {

    private final LinkedList<T> inOrderList;

    public InOrderIterator(TreeNode<T> root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }

        inOrderList = new LinkedList<>();
        inOrderTraversal(root);
    }


    @Override
    public boolean hasNext() {
        return !inOrderList.isEmpty();
    }

    @Override
    public Object next() {
        return inOrderList.poll();
    }

    private void inOrderTraversal(TreeNode<T> node) {

        if (node.left != null) {
            inOrderTraversal(node.left);
        }

        inOrderList.addLast(node.data);

        if (node.right != null) {
            inOrderTraversal(node.right);
        }
    }
}
