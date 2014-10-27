/**
 * Given the root of a binary search tree and 2 numbers min and max,
 * trim the tree such that all the numbers in the new tree are between min and max (inclusive).
 * The resulting tree should still be a valid binary search tree.
 *
 * See more at: http://www.ardendertat.com/2012/01/17/programming-interview-questions-26-trim-binary-search-tree/
 */
public class Solution {

    public TreeNode trimBST(TreeNode root, int min, int max) {
        if (root == null) {
            return null;
        }

        if (root.val < min) {
            return trimBST(root.right, min, max);
        } else if (root.val > max) {
            return trimBST(root.left, min, max);
        } else {
            root.left = trimBST(root.left, min, max);
            root.right = trimBST(root.right, min, max);
        }

        return root;
    }
}
