package linkedlist;

/**
 * Created by rodsou on 7/6/17.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "linkedlist.ListNode{" +
            "val=" + val +
            ", next=" + next +
            '}';
    }
}
