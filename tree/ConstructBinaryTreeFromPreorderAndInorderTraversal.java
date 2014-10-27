/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[ps]);
        int index = indexOf(inorder, is, ie, preorder[ps]);
        if (index == -1) {
            return null;
        }

        node.left = build(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
        node.right = build(preorder, ps + 1 + index - is, pe, inorder, index + 1, ie);

        return node;
    }

    private int indexOf(int[] inorder, int is, int ie, int target) {
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
