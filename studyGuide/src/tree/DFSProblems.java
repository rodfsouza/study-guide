package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rodsou on 7/26/17.
 */
public class DFSProblems {

    private static List<List<Integer>> result = new ArrayList<>();

    public static void main (String[] args) {
        BTreeNode<Integer> root = new BTreeNode<>(5);
        root.left = new BTreeNode<>(4);
        root.right = new BTreeNode<>(8);

        //Left
        root.left.left = new BTreeNode<>(11);
        root.left.left.left = new BTreeNode<>(7);
        root.left.left.right = new BTreeNode<>(2);

        //right
        root.right.left = new BTreeNode<>(13);
        root.right.right = new BTreeNode<>(4);
        root.right.right.left = new BTreeNode<>(5);
        root.right.right.right = new BTreeNode<>(1);

        List<List<Integer>> paths = pathSum(root, 22);
    }

    public static List<List<Integer>> pathSum(BTreeNode<Integer> root, int sum) {
        if (root == null) {
            return result;
        }

        Stack<Integer> stack = new Stack<>();
        pathSum(root, sum, stack);

        return result;
    }

    static void pathSum(BTreeNode<Integer> node, int sum, Stack<Integer> path) {
        path.push(node.value);

        if (node.left == null && node.right == null) {
            if (node.value == sum) {
                result.add(new ArrayList<>(path));
            }
        }

        if (node.left != null) {
            System.out.println("Left: "+ (sum-node.value));
            pathSum(node.left, sum-node.value, path);
        }

        if (node.right != null) {
            System.out.println("Right: "+ (sum-node.value));
            pathSum(node.right, sum-node.value, path);
        }
        path.pop();
    }
}
