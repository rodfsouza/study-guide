package linkedlist;

public class ReverseLinkedListBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        int pos = 1;

        while (curr != null) {
            if (pos == left) {
                break;
            }
            pos++;
            prev = curr;
            curr = curr.next;
        }

        ListNode leftNode = curr;
        ListNode leftPrev = prev;

        prev = null;
        curr = head;
        pos = 1;

        while (curr != null) {
            if (pos == right) {
                break;
            }
            pos++;
            prev = curr;
            curr = curr.next;
        }

        if (pos == 1) {
            return head;
        }

        leftPrev.next = curr;
        ListNode currNext = curr.next;
        curr.next = leftNode.next;
        leftNode.next = currNext;
        prev.next = leftNode;

        return leftPrev;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode prevLeft = null;
        ListNode leftNode = null;
        ListNode prevRight = null;
        ListNode rightNode = null;
        ListNode curr = head;
        int pos = 1;

        while (curr != null) {
            if (pos == left) {
                leftNode = curr;
            } else if (pos == right) {
                rightNode = curr;
            }

            if (curr.next != null && pos == left) {
                prevLeft = curr;
            } else if (pos == right) {
                prevRight = curr;
            }
            pos++;
            curr = curr.next;
        }

        if (leftNode != null && rightNode == null) {
            return leftNode;
        } else if (leftNode == null && rightNode != null) {
            return rightNode;
        } else if (leftNode == null && rightNode == null) {
            return head;
        }

        ListNode nextRight = rightNode.next;
        prevLeft.next = rightNode;
        rightNode.next = leftNode.next;
        leftNode.next = nextRight;
        prevRight.next = leftNode;

        return prevLeft;
    }

    public ListNode reverseBetween3(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to simplify the boundary conditions
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevLeft = dummy;

        // Move `prev` to the node just before the reversing segment
        for (int i = 1; i < left; i++) {
            prevLeft = prevLeft.next;
        }

        // Start reversing from `start` node
        ListNode leftNode = prevLeft.next;
        ListNode nextOfLeft = leftNode.next;

        // Reverse the segment between `left` and `right`
        for (int i = 0; i < right - left; i++) {
            leftNode.next = nextOfLeft.next;
            nextOfLeft.next = prevLeft.next;
            prevLeft.next = nextOfLeft;
            nextOfLeft = leftNode.next;
        }

        return dummy.next;
    }
}
