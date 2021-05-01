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
    ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9)));
    ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
    new AddToNumbers().addTwoNumbers(l1, l2);
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
    ListNode node1 = l1;
    ListNode node2 = l2;

    ListNode first = null;
    ListNode last = null;

    int round = 0;

    while (node1 != null || node2 != null) {
      int val1 = node1 == null ? 0 : node1.val;
      int val2 = node2 == null ? 0 : node2.val;

      int sum = val1 + val2 + round;

      if (sum / 10 > 0) {
        sum = sum % 10;
        round = 1;
      } else {
        round = 0;
      }

      ListNode l = last;
      ListNode newNode = new ListNode(sum);
      last = newNode;

      if (l == null) {
        first = newNode;
      } else {
        l.next = newNode;
      }

      if (node1 != null) {
        node1 = node1.next;
      }

      if (node2 != null) {
        node2 = node2.next;
      }
    }

    if (round == 1) {
      ListNode l = last;
      ListNode newNode = new ListNode(round);
      l.next = newNode;
      last = newNode;
    }

    System.out.println(debug(first));

    return first;
  }
}
