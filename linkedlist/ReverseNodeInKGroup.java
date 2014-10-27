/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the
 * end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
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

    private void reverseRange(ListNode head, ListNode tail) {
        if (head == tail) {
            return;
        }

        ListNode flag = tail.next;
        ListNode pre = tail.next;
        ListNode current = head;

        while (current != flag) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preHead = dummy;
        ListNode current = preHead;

        while (preHead != null) {
            int pos = 0;
            while (pos < k && current != null) {
                current = current.next;
                pos++;
            }
            if (pos < k || current == null) {
                break;
            }
            ListNode temp = preHead.next;
            reverseRange(preHead.next, current);
            preHead.next = current;
            preHead = temp;
            current = preHead;
        }
        return dummy.next;
    }
}
