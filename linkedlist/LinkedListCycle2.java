/**
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * Follow up:
 * Can you solve it without using extra space?
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
 *
 * 2s = s + nr; // s is the slow pointer steps, r is the cycle length;
 *              // n means the fast pointer kicked cycle
 * x + a = s = nr = (n - 1)r + L - x;  // x means head to the cycle start
 * // point, a means the cycle start point to meet point length, L means
 * // the total length (x + r)
 * so x = (n - 1)r + (L - x - a);
 * which means head and meet point go together, they will meet at the cycle
 * start point
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        }

        ListNode node = head;

        // just remember this
        while (node != slow.next) {
            node = node.next;
            slow = slow.next;
        }

        return node;
    }
}
