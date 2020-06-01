package bt;

public class BinarySearchTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node (int data) {
            this.data = data;
        }

        public void insert(int value) {
            if (value <= data) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.insert(value);
                }
            }
        }

        public boolean contains(int value) {
            if (value == data) {
                return true;
            }

            if (value < data) {
                if (left == null) {
                    return false;
                } else
                    return left.contains(value);
            } else {
                if (right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }
            }
        }

        public void inOrder() {
            if (left != null) {
                left.inOrder();
            }

            System.out.println(data);

            if (right != null) {
                right.inOrder();
            }
        }

        public void preOrder() {
            System.out.println(data);

            if (left != null) {
                left.preOrder();
            }

            if (right != null) {
                right.preOrder();
            }
        }

        public void postOrder() {
            if (left != null) {
                left.postOrder();
            }

            if (right != null) {
                right.postOrder();
            }

            System.out.println(data);
        }
    }
}
