package linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SinglyLinkedListNode {

    private int value;
    private SinglyLinkedListNode next;

    public SinglyLinkedListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(SinglyLinkedListNode next) {
        this.next = next;
    }

    public void deleteNode (SinglyLinkedListNode nodeToDelete) {
        if (nodeToDelete == null) {
            return;
        }

        SinglyLinkedListNode prev = nodeToDelete;

        if (prev.value == nodeToDelete.next.value) {
            nodeToDelete.setValue(nodeToDelete.next.value);
            nodeToDelete.setNext(nodeToDelete.next.next);
            return;
        }

        while (prev.next != null) {
            if (prev.value == nodeToDelete.value) {
                prev.next = prev.next.next;
            }
            prev = prev.next;
        }
    }

    public SinglyLinkedListNode deleteNodes(int data, SinglyLinkedListNode head) {
        if (head == null) {
            return null;
        }

        SinglyLinkedListNode curr = head;

        while(curr != null) {
            SinglyLinkedListNode runner = curr;
            while (runner.next != null) {
                if (runner.next.value == data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
                curr = curr.next;
            }
        }
        return head;
    }

    public SinglyLinkedListNode deleteDuplicates(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        SinglyLinkedListNode dummy = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode slow = dummy;
        slow.next = head;

        SinglyLinkedListNode fast = head.next;
        while (fast != null) {
            boolean isDuplicated = false;

            while (fast != null && fast.value == slow.next.value) {
                isDuplicated = true;
                fast = fast.next;
            }

            if (isDuplicated) {
                slow.next = fast;
            } else {
                slow = slow.next;
            }

            if (fast != null) {
                fast = fast.next;
            }
        }

        return dummy.next;
    }

    public SinglyLinkedListNode mergeSorted(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        } else if (l2 == null && l1 != null) {
            return l1;
        } else if (l1 == null || l2 == null) {
            throw new IllegalArgumentException();
        }

        SinglyLinkedListNode newHead = null;
        SinglyLinkedListNode temp = newHead;
        SinglyLinkedListNode left = l1;
        SinglyLinkedListNode right = l2;

        while (left != null && right != null) {

            if (left.value <= right.value) {
                if (newHead == null) {
                    newHead = new SinglyLinkedListNode(left.value);
                    temp = newHead;
                } else {
                    temp.next = new SinglyLinkedListNode(left.value);
                    temp = temp.next;
                }
                left = left.next;
            } else {
                if (newHead == null) {
                    newHead = new SinglyLinkedListNode(right.value);
                    temp = newHead;
                } else {
                    temp.next = new SinglyLinkedListNode(right.value);
                    temp = temp.next;
                }
                right = right.next;
            }
        }

        while (left != null) {
            temp.next = new SinglyLinkedListNode(left.value);
            temp = temp.next;
            left = left.next;
        }

        while (right != null) {
            temp.next = new SinglyLinkedListNode(right.value);
            temp = temp.next;
            right = right.next;
        }

        return newHead;
    }

    public SinglyLinkedListNode insertOnSorted(SinglyLinkedListNode head, SinglyLinkedListNode node) {
        if (head == null) {
            return node;
        }

        if (node == null) {
            return head;
        }

        SinglyLinkedListNode current = head;
        SinglyLinkedListNode previous = null;

        do {
            if (node.value <= current.value) { //Incoming node is less than head
                if (previous == null) {
                    node.next = current;
                    head = node;
                    break;
                }

                //If the node is to be inserted on the middle of the list
                previous.next = node;
                node.next = current;
                break;
            }

            previous = current;
            current = current.next;

            if (current == null && previous.value <= node.value) { //If the incoming node is a tail node
                previous.next = node;
            }

        } while (current != null);

        return head;
    }

    public SinglyLinkedListNode swapPairs(SinglyLinkedListNode head) {
        if (head != null && head.next == null) {
            return null;
        }

        SinglyLinkedListNode output = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode current = output;

        while (head != null && head.next != null) {

            SinglyLinkedListNode prev = head;
            SinglyLinkedListNode after = head.next;
            SinglyLinkedListNode afterNext = after.next;

            current.next = after;
            current = current.next;
            current.next = prev;
            current = current.next;
            current.next = null;

            head = afterNext;
        }

        if (head != null)
        {
            current.next = head;
        }

        return output.next;
    }

//    public SinglyLinkedListNode rotateRight(SinglyLinkedListNode head, int k) {
//
//        if (head == null) {
//            return null;
//        }
//
//        SinglyLinkedListNode curr = head;
//        SinglyLinkedListNode previous = null;
//        SinglyLinkedListNode tail = null;
//        int length = 0;
//
//        while (curr != null) {
//
//            if (curr.next == null) {
//                tail = curr;
//            }
//
//            curr = curr.next;
//            length++;
//        }
//
//        int realK = length - (k % length);
//        if (realK == 1 || length == realK) {
//            return head;
//        }
//
//        curr = head;
//        while (realK > 0) {
//            previous = curr;
//            curr = curr.next;
//            realK--;
//        }
//
//        curr = previous.next;
//        previous.next = null;
//        tail.next = head;
//
//        return curr;
//    }

    public SinglyLinkedListNode rotateRight2(SinglyLinkedListNode head, int k) {
        if (head == null) {
            return null;
        }

        SinglyLinkedListNode curr = head;
        SinglyLinkedListNode previous = null;
        Map<SinglyLinkedListNode, SinglyLinkedListNode> fromToPrevious = new HashMap<>();

        while (curr != null) {
            fromToPrevious.put(curr, previous);
            previous = curr;
            curr = curr.next;
        }

        int start = 0;
        curr = head;
        SinglyLinkedListNode tail = previous;

        while (start < k) {
            //Insert tail into front of the list
            SinglyLinkedListNode beforeTail = fromToPrevious.get(tail);
            tail.next = curr;
            curr = tail;

            //Update tail to previous of it
            tail = beforeTail;
            //tail.next = head;

            start++;
        }

        tail.next = null;
        return curr;
    }

    public SinglyLinkedListNode rotateRight(SinglyLinkedListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        if (k == 0) {
            return head;
        }

        SinglyLinkedListNode curr = head;
        int length = 0;

        while (curr != null) {
            curr = curr.next;
            length++;
        }

        if (length == 1) {
            return head;
        }

        SinglyLinkedListNode tail = null;
        SinglyLinkedListNode lastTail = null;

        while (k > 0) {

            curr = head;
            while (curr != null ) {
                lastTail = tail;
                tail = curr;
                curr = curr.next;
            }

            tail.next = head;
            head = tail;
            lastTail.next = null;

            k--;
        }

        return head;
    }

    public SinglyLinkedListNode rotate(SinglyLinkedListNode head, int k) {
        if (k == 0)
            return null;

        SinglyLinkedListNode current = head;
        int length = 1;

        while (length < k && current != null) {
            current = current.next;
            length++;
        }

        //If k is greater or equal to length of the list
        if (current == null) {
            return null;
        }

        SinglyLinkedListNode kthNode = current;

        while (current != null) {
            current = current.next;
        }

        current.next = head;
        head = kthNode.next;
        kthNode.next = null;

        return head;
    }
}
