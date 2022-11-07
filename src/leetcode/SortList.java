package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortList {
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
    ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
    System.out.println(new SortList().sortList(head));
  }

  public ListNode sortList(ListNode head) {
    Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    ListNode node = head;
    while (node != null) {
      queue.offer(node.val);
      node = node.next;
    }
    ListNode newNode = new ListNode();
    ListNode newHead = newNode;
    while (!queue.isEmpty()) {
      newNode.next = new ListNode(queue.poll());
      newNode = newNode.next;
    }
    return newHead.next;
  }
}
