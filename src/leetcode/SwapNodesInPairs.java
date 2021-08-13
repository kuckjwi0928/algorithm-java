package leetcode;

public class SwapNodesInPairs {
  private static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
    new SwapNodesInPairs().swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
  }

  public ListNode swapPairs(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode curr = head;

    while (curr != null && curr.next != null) {
      int temp = curr.val;
      curr.val = curr.next.val;
      curr.next.val = temp;
      curr = curr.next.next;
    }

    return head;
  }

  private String debug(ListNode l) {
    StringBuilder builder = new StringBuilder();
    ListNode node = l;
    while (node != null) {
      builder.append(node.val);
      node = node.next;
    }
    return builder.toString();
  }
}
