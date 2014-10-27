/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length || inorder.length == 0) {
            return null;
        }

        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0,
                postorder.length - 1);
    }

    // divide and conquer
    private TreeNode buildTreeHelper(int[] in, int inS, int inE, int[] post,
            int postS, int postE) {
        if (inS > inE) {
            return null;
        }

        int val = post[postE];

        int pos = findIndex(in, inS, inE, val);
        if (pos == -1) {
            return null;
        }

        TreeNode node = new TreeNode(val);
        node.left = buildTreeHelper(in, inS, pos - 1, post, postS,
                        pos - inS - 1 + postS);
        node.right = buildTreeHelper(in, pos + 1, inE, post, postE - inE + pos,
                        postE - 1);

        return node;
    }

    private int findIndex(int[] in, int start, int end, int value) {
        while (start <= end && in[start] != value) {
            start++;
        }

        return start > end ? -1 : start;
    }
}
