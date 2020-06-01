package linkedlist;

public class SinglyNode<T> {

    public T data;
    public SinglyNode<T> next;
    public SinglyNode<T> jump;

    public SinglyNode() {

    }

    public SinglyNode(T data) {
        this.data = data;
    }

    public SinglyNode hasCycle(SinglyNode head) {
        if (head == null) {
            return null;
        }

        SinglyNode<T> slow = head;
        SinglyNode<T> fast = head;

        while (slow != null || fast != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
