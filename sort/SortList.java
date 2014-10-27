/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midNode = findMiddle(head);
        ListNode rightHead = midNode.next;

        midNode.next = null;
        ListNode leftHead = head;

        ListNode node = mergeList(sortList(leftHead), sortList(rightHead));
        return node;
    }

    public ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeList(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);

        ListNode n1 = h1;
        ListNode n2 = h2;

        ListNode current = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                current.next = n1;
                n1 = n1.next;
            } else {
                current.next = n2;
                n2 = n2.next;
            }
            current = current.next;
        }

        if (n1 != null) {
            current.next = n1;
        }
        if (n2 != null) {
            current.next = n2;
        }

        return dummy.next;
    }
}
