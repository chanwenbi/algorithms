/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {

    /**
     *
     * @param baseValue start value
     * @param n numbers of node
     * @return
     */
    public List<TreeNode> generateTreesHelper(int baseValue, int n) {

        List<TreeNode> trees = new ArrayList<TreeNode>();

        if (n == 0) {
            trees.add(null);
            return trees;
        }

        // for each possible left/right nodes number
        for (int i = 1; i <= n; i++) {
            List<TreeNode> left = generateTreesHelper(baseValue, i - 1);
            List<TreeNode> right = generateTreesHelper(baseValue + i, n - i);

            // for each kind of left and right sub trees
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    // construct the current node
                    TreeNode node = new TreeNode(baseValue + i);
                    node.left = l;
                    node.right = r;
                    trees.add(node);
                }
            }
        }

        return trees;
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTreesHelper(0, n);
    }
}
