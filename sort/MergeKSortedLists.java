/**
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
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue(lists.size() + 1,
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode n1, ListNode n2) {
                    return n1.val - n2.val;
                }
            });

        ListNode dummy = new ListNode(0);

        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        ListNode current = dummy;
        ListNode node;
        while ((node = queue.poll()) != null) {
            current.next = node;
            current = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        current.next = null;

        return dummy.next;
    }
}
