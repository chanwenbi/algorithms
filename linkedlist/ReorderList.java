/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
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

    private ListNode findMiddle(ListNode head) {
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

    private ListNode reverse(ListNode head) {
        ListNode current = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = current;
            current = head;
            head = temp;
        }
        return current;
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);

        boolean odd = true;
        ListNode current = dummy;
        while (h1 != null && h2 != null) {
            if (odd) {
                current.next = h1;
                h1 = h1.next;
            } else {
                current.next = h2;
                h2 = h2.next;
            }
            current = current.next;
            odd = !odd;
        }

        if (h1 != null) {
            current.next = h1;
        }

        if (h2 != null) {
            current.next = h2;
        }

        return dummy.next;
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = findMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        ListNode reversedRightList = reverse(right);
        head = merge(left, reversedRightList);
    }
}
