/**
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    // before implement, need to confirm with interviewer about
    // the n value, will it larger than list length?
    // if no, then we could use one pass version 2 solution

    // version 1: check n with list length to avoid NPE
    // O(2n) O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        int len = lenOfList(head);

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        n = n % len == 0 ? len : n % len;
        int preNIndex = len - n;
        while (preNIndex-- > 0) {
            current = current.next;
        }

        current.next = current.next.next;

        return dummy.next;
    }

    // Version 2: one-pass
    // without checking n and list length
    // O(n) O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;

        for (int i = 0; i <= n; i++) {
            node = node.next;
        }

        ListNode preNth = dummy;
        while (node != null) {
            node = node.next;
            preNth = preNth.next;
        }

        preNth.next = preNth.next.next;

        return dummy.next;
    }

    private int lenOfList(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
