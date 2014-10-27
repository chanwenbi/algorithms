/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    private ListNode current;

    private int getListSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size = getListSize(head);
        current = head;
        return sortListToBSTWithSize(size);
    }

    private TreeNode sortListToBSTWithSize(int size) {
        if (size <= 0) {
            return null;
        }
        // here we could not use divide/conquer, as list could not
        // use random access
        TreeNode left = sortListToBSTWithSize(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortListToBSTWithSize(size - size / 2 - 1);
        root.left = left;
        root.right = right;

        return root;
    }
}
