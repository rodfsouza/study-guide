package binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulateNextRightPointerII {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currSize = queue.size();
            Node lastSeenNode = null;

            for (int i = 0; i < currSize; ++i) {
                Node curr = queue.poll();

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                if (lastSeenNode == null) {
                    lastSeenNode = curr;
                } else {
                    lastSeenNode.next = curr;
                    lastSeenNode = curr;
                }
            }
        }

        return root;
    }
}
