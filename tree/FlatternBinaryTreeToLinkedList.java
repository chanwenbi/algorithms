/**
 * Given a binary tree, flatten it to a linked list in-place by preorder.
 *
 * For example,
 * Given
 *
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode node = new TreeNode(0);

    // using preorder traversal
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        node.left = null;
        node.right = root;
        node = root;

        // need to keep the right first, as the flatten will change the right node
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}
