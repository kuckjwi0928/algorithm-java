package leetcode;

public class PartitionList {
    private static final class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        var results = new PartitionList().partition(
                new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))),
                3);
        while (results != null) {
            System.out.println(results.val);
            results = results.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode leftTail = left;
        ListNode rightTail = right;

        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }

            head = head.next;
        }

        leftTail.next = right.next;
        rightTail.next = null;
        return left.next;
    }
}
