/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * For example,
 *
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = 12 + 13 = 25.
 *
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int sum(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }

        val = val*10 + node.val;
        if (node.left == null && node.right == null) {
            return val;
        }

        // divide and conquer
        return sum(node.left, val) + sum(node.right, val);
    }

    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
}
