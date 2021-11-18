package btree;

import java.util.Iterator;
import java.util.LinkedList;

public class InOrderIteratorIterative<T> implements Iterator {

    public final LinkedList<T> inOrderList;

    public InOrderIteratorIterative(TreeNode<T> root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }

        this.inOrderList= new LinkedList<>();
        inOrderTraversalIterative(root);
    }


    @Override
    public boolean hasNext() {
        return !inOrderList.isEmpty();
    }

    @Override
    public Object next() {
        return inOrderList.poll();
    }

    private void inOrderTraversalIterative(TreeNode<T> node) {

        LinkedList<TreeNode<T>> stack = new LinkedList<>();
        while (node != null) {
            stack.addFirst(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {
            TreeNode<T> curr = stack.pop();
            inOrderList.addLast(curr.data);

            curr = curr.right;
            while (curr != null) {
                stack.addFirst(curr);
                curr = curr.left;
            }
        }
    }
}
