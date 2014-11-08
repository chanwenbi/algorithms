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

    // version 1: divide and conquer
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) {
            return null;
        }

        return buildBST(num, 0, num.length - 1);
    }

    private TreeNode buildBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = buildBST(num, start, mid - 1);
        node.right = buildBST(num, mid + 1, end);

        return node;
    }

    // version 2: leverage the inorder visit order
    // could also be used in list
    private int i = 0;

    private TreeNode sortedWithLength(int[] num, int length) {
        if (length <= 0) {
            return null;
        }

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
