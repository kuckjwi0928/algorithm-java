package leetcode;

public class MergeTwoSortedLists {
   private static final class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

  public static void main(String[] args) {
    new MergeTwoSortedLists().mergeTwoLists(
      new ListNode(1, new ListNode(2, new ListNode(4))),
      new ListNode(1, new ListNode(3, new ListNode(4)))
    );
    new MergeTwoSortedLists().mergeTwoLists(
      new ListNode(0),
      null
    );
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     if (l1 == null && l2 == null) {
       return null;
     }

     ListNode head = new ListNode();
     ListNode curr = head;

     while (l1 != null || l2 != null) {
       if (l1 == null) {
         curr.next = new ListNode(l2.val);
         curr = curr.next;
         l2 = l2.next;
         continue;
       }

       if (l2 == null) {
         curr.next = new ListNode(l1.val);
         curr = curr.next;
         l1 = l1.next;
         continue;
       }

       int val1 = l1.val;
       int val2 = l2.val;

       if (val1 < val2) {
         curr.next = new ListNode(val1);
         curr = curr.next;
         l1 = l1.next;
       } else {
         curr.next = new ListNode(val2);
         curr = curr.next;
         l2 = l2.next;
       }
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
