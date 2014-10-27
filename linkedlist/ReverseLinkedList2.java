/**
 * Reverse a linked list from position m to n.
 * Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m < 0 || n < 0) {
            // invalid input
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preM = dummy;

        for (int i = 0; i < m - 1; i++) {
            if (preM == null) {
                // invalid m which is larger than m;
                return head;
            }
            preM = preM.next;
        }

        ListNode atM = preM.next;
        ListNode preNode = null;
        ListNode cur = atM;
        for (int i = m; i <= n; i++) {
            if (cur == null) {
                // invalid n
                return head;
            }

            ListNode temp = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = temp;
        }

        ListNode atN = preNode;
        ListNode afterN = cur;

        preM.next = atN;
        atM.next = cur;

        return dummy.next;
    }
}
