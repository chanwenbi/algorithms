/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each
 * path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private void pathSumHelper(List<List<Integer>> result, List<Integer> path,
            TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        int leftSum = sum - root.val;

        if (leftSum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(path));
        }

        pathSumHelper(result, path, root.left, leftSum);
        pathSumHelper(result, path, root.right, leftSum);

        path.remove(path.size() - 1);
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        pathSumHelper(result, new ArrayList<Integer>(), root, sum);
        return result;
    }
}
