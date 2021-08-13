package leetcode;

import java.util.Objects;

public class RemoveNthNodeFromEndOfList {
  private static final class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
    new RemoveNthNodeFromEndOfList()
            .removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode l = head;
    ListNode r = head;

    while (n-- > 0) {
      r = r.next;
    }

    if (Objects.isNull(r)) {
      return head.next;
    }

    while (Objects.nonNull(r.next)) {
      l = l.next;
      r = r.next;
    }

    l.next = l.next.next;

    return head;
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
}
