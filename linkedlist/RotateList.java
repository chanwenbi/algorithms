/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
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

    private int size(ListNode head) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        int size = size(head);
        int k = n % size;

        if (k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode preN = dummy;
        dummy.next = head;

        // ways to find the last nth element, move a point A to the first nth element.
        // both A and head move a step while A.next != null, finally the head will be
        // at the position of last nth element.
        ListNode tail = dummy;
        for (int i = 0; i < k; i++) {
            tail = tail.next;
        }

        while(tail.next != null) {
            tail = tail.next;
            preN = preN.next;
        }

        ListNode newHead = preN.next;
        preN.next = null;
        tail.next = head;
        return newHead;
    }
}
