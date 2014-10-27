/**
 * Given a binary tree
 *
 *     struct TreeLinkNode {
 *       TreeLinkNode *left;
 *       TreeLinkNode *right;
 *       TreeLinkNode *next;
 *     }
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the
 * same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {

    // Version 1: non-recursive version(recommanded)
    // using queue to do level order visit
    // as we only need to remember the previous level's first node to
    // chain the next level, so we could reduce the Space complexity to
    // O(1)
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode currentLevelStartNode = root;
        TreeLinkNode nextLevelStartNode = currentLevelStartNode.left;

        while (nextLevelStartNode != null) {
            TreeLinkNode node = currentLevelStartNode;
            while (node != null) {
                node.left.next = node.right;
                node.right.next = node.next == null ? null : node.next.left;
                node = node.next;
            }

            currentLevelStartNode = nextLevelStartNode;
            nextLevelStartNode = currentLevelStartNode.left;
        }
    }

    // Version 2: recursive
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            root.left.next = root.right;
            connect(root.left);
        }

        if (root.right != null) {
            root.right.next = root.next == null ? null : root.next.left;
            connect(root.right);
        }
    }

}
