package tree;

public class TreeMain {
    public static void main(String[] args) {
//        BTreeNode root = new BTreeNode(2);
//        root.left = new BTreeNode(1);
//        //root.left.left = new BTreeNode(3);
//
//        root.right = new BTreeNode(1);
//        //root.right.right = new BTreeNode(3);
//
//        BSTree tree = new BSTree(2);
//        List<BTreeNode> duplicated = tree.findDuplicateSubtrees(root);
//        for (BTreeNode node : duplicated) {
//            System.out.println(node.value);
//            System.out.println(node.left != null ? node.left.value : "null");
//            System.out.println(node.right != null ? node.right.value : "null");
//        }

        BinaryTree btree = new BinaryTree(5);
        btree.root.left = new BinaryTreeNode<>(4);
        btree.root.right = new BinaryTreeNode<>(6);
        btree.root.left.left = new BinaryTreeNode<>(2);
        btree.root.left.left.right = new BinaryTreeNode<>(3);
        btree.root.right.left = new BinaryTreeNode<>(5);
        btree.root.right.right = new BinaryTreeNode<>(7);
        btree.root.right.left.left = new BinaryTreeNode<>(6);
        btree.setPointer(btree.root);
        System.out.println();
    }
}
