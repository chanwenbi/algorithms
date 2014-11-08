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
 * s = x + a + kr; // x means head to cycle start steps, a means cycle start to meet point steps
 *                 // k means slow pointer kicked cycle
 * x = (n - k - 1)r + r - a;
 * which means head and meet point go together, they will meet at the cycle
 * start point
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

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
        while (node != slow) {
            node = node.next;
            slow = slow.next;
        }

        return node;
    }
}
