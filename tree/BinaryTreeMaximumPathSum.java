/**
 * Given a binary tree, find the maximum path sum.
 *
 * The path may start and end at any node in the tree.
 *
 * For example:
 * Given the below binary tree,
 *
 *        1
 *       / \
 *      2   3
 *
 * Return 6.
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

    // Version 1(recommend): dfs return the maximum sum of
    // (root and it's the left part, root and it's right part)
    public int maxPathSum(TreeNode root) {
        dfs(root);

        return max;
    }

    int max = Integer.MIN_VALUE;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lp = dfs(root.left);
        int rp = dfs(root.right);

        int sum = root.val;
        if (lp > 0) {
            sum += lp;
        }
        if (rp > 0) {
            sum += rp;
        }

        max = Math.max(max, sum);

        return Math.max(lp, rp) > 0 ? Math.max(lp, rp) + root.val : root.val;
    }

    // Version 2: divide and conquer,
    // max path is all in left, all in right, or through root
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);

        return maxPath;
    }

    private int maxPath = Integer.MIN_VALUE;

    class Result {
        int leafToNodeMaxPath = 0;
        int maxPath = 0;
    }

    private Result maxPathSumHelper(TreeNode node) {
        if (node == null) {
            return new Result();
        }

        Result l = maxPathSumHelper(node.left);
        Result r = maxPathSumHelper(node.right);

        Result nodeResult = new Result();
        int maxLeafPath = Math.max(l.leafToNodeMaxPath, r.leafToNodeMaxPath);
        nodeResult.leafToNodeMaxPath = node.val + (maxLeafPath > 0 ? maxLeafPath : 0);

        nodeResult.maxPath = node.val;

        nodeResult.maxPath = nodeResult.maxPath + (l.leafToNodeMaxPath > 0 ? l.leafToNodeMaxPath : 0);
        nodeResult.maxPath = nodeResult.maxPath + (r.leafToNodeMaxPath > 0 ? r.leafToNodeMaxPath : 0);

        maxPath = Math.max(maxPath, nodeResult.maxPath);

        return nodeResult;
    }
}
