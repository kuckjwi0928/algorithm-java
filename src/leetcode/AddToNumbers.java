package leetcode;

public class AddToNumbers {
  private static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
    // l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
    ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
    new AddToNumbers().addTwoNumbers(l1, l2);
    ListNode l3 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode l4 = new ListNode(5, new ListNode(6, new ListNode(4)));
    new AddToNumbers().addTwoNumbers(l3, l4);
  }

  public String debug(ListNode l) {
    StringBuilder builder = new StringBuilder();
    ListNode node = l;
    while (node != null) {
      builder.append(node.val);
      node = node.next;
    }
    return builder.toString();
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode();
    ListNode curr = head;

    int carry = 0;

    while (l1 != null || l2 != null) {
      int val1 = l1 != null ? l1.val : 0;
      int val2 = l2 != null ? l2.val : 0;

      int sum = val1 + val2 + carry;

      carry = sum / 10;

      curr.next = new ListNode(sum % 10);
      curr = curr.next;

      if (l1 != null) {
        l1 = l1.next;
      }

      if (l2 != null) {
        l2 = l2.next;
      }
    }

    if (carry > 0) {
      curr.next = new ListNode(carry);
    }

    return head.next;
  }
}
