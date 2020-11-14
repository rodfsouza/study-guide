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

        public Node find(int value) {
            if (this.data == value) {
                return this;
            }

            if (value < this.data) {
                if (this.left == null) {
                    return null;
                } else {
                    return this.left.find(value);
                }
            } else {
                if (this.right == null) {
                    return null;
                } else {
                    return this.right.find(value);
                }
            }
        }

        public int getSuccessor(Node root, int value) {
            Node current = find(value);
            if (current == null) {
                return -1;
            }

            if (current.right != null) { //Case 1: Node has right subtree
                return findMin(current);
            } else { //Case 2: Node has no right subtree
                Node successor = null;
                Node ancestor = root;
                while (ancestor != current) {
                    if (current.data < ancestor.data) {
                        successor = ancestor;
                        ancestor = ancestor.left;
                    } else {
                        ancestor = ancestor.right;
                    }
                }
                if (successor != null) {
                    return successor.data;
                } else {
                    return -1;
                }
            }
        }

        private int findMin(Node node) {
            Node temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp != null ? temp.data : -1;
        }
    }
}
