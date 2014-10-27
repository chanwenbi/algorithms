/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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

    private int i = 0;

    private TreeNode sortedWithLength(int[] num, int length) {
        if (length <= 0) {
            return null;
        }
        // leverage the inorder visit order to construct the tree.
        // could also use devide/conquer to solve, which is more
        // understandable.
        //
        // but this solution could used in list case which doesn't
        // allow random access
        TreeNode left = sortedWithLength(num, length / 2);
        TreeNode root = new TreeNode(num[i++]);
        TreeNode right = sortedWithLength(num, length - length / 2 - 1);
        root.left = left;
        root.right = right;

        return root;
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }

        return sortedWithLength(num, num.length);
    }
}
