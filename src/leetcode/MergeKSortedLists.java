package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MergeKSortedLists {
  private static final class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
    ListNode[] nodes = new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6))};

    System.out.println(new MergeKSortedLists().mergeKLists(nodes));
    System.out.println(new MergeKSortedLists().mergeKLists(new ListNode[]{}));
    System.out.println(new MergeKSortedLists().mergeKLists(new ListNode[]{null, new ListNode(1)}));
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length < 1) {
      return null;
    }

    List<Integer> result = new LinkedList<>();

    for (ListNode node : lists) {
      while (node != null) {
        result.add(node.val);
        node = node.next;
      }
    }

    if (result.isEmpty()) {
      return null;
    }

    Collections.sort(result);

    ListNode head = new ListNode();
    ListNode curr = head;

    for (Integer integer : result) {
      curr.next = new ListNode(integer);
      curr = curr.next;
    }

    return head.next;
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
