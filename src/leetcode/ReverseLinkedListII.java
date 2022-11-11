package leetcode;

public class ReverseLinkedListII {
  private static class ListNode {
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

    @Override
    public String toString() {
      return "ListNode{" +
              "val=" + val +
              ", next=" + next +
              '}';
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    System.out.println(new ReverseLinkedListII().reverseBetween(head, 2, 4));
  }

  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;
    for (int i = 0; i < left - 1; i++) {
      prev = prev.next;
    }

    ListNode curr = prev.next;
    for (int i = 0; i < right - left; i++) {
      ListNode temp = curr.next;
      curr.next = temp.next;
      temp.next = prev.next;
      prev.next = temp;
    }

    return dummy.next;
  }
}
