/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 *
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 *
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 *
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Version 1: using Queue to do level order scan
    // O(max level node) space complexity
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode sibling = null;
            while (size-- > 0) {
                TreeLinkNode node = queue.poll();
                node.next = sibling;
                sibling = node;

                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
    }

    // Version 2: using previous non empty node to memo(recommanded).
    // O(1) space complexity
    public void connect(TreeLinkNode root) {
        while (root != null) {
            root = linkNextLevel(root);
        }
    }

    private TreeLinkNode linkNextLevel(TreeLinkNode cur) {
        TreeLinkNode next = null;
        TreeLinkNode node = null;
        while (cur != null) {
            if (cur.left != null) {
                if (node == null) {
                    node = cur.left;
                    next = node;
                } else {
                    node.next = cur.left;
                    node = node.next;
                }
            }

            if (cur.right != null) {
                if (node == null) {
                    node = cur.right;
                    next = node;
                } else {
                    node.next = cur.right;
                    node = node.next;
                }
            }

            cur = cur.next;
        }
        return next;
    }
}
