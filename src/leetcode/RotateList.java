package leetcode;

import java.util.Objects;

public class RotateList {
  public static class ListNode {
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
    System.out.println(new RotateList().rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
  }

  public ListNode rotateRight(ListNode head, int k) {
    if (Objects.isNull(head)) {
      return null;
    }
    ListNode lastNode = head;
    int size = 1;
    while (Objects.nonNull(lastNode.next)) {
      lastNode = lastNode.next;
      size++;
    }
    lastNode.next = head;
    ListNode newLast = head;
    for (int i = 0; i < size - (k % size) - 1; i++) {
      newLast = newLast.next;
    }
    head = newLast.next;
    newLast.next = null;
    return head;
  }
}
