/**
 * Consider lines of slope -1 passing between nodes (dotted lines in below diagram).
 * Diagonal sum in a binary tree is sum of all node’s data lying between these lines.
 * Given a Binary Tree, print all diagonal sums.
 *
 * check the following link for vivid graph:
 * http://www.geeksforgeeks.org/diagonal-sum-binary-tree/
 */
public class Solution {

    static class DiagonalNode {
        TreeNode node;
        int level;

        public DiagonalNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    /**
     * 1. Add root with vertical distance as 0 to the queue.
     * 2. Process the sum of all right child and right of right child and so on.
     * 3. Add left child current node into the queue for later processing.
     * The vertical distance of left child is vertical distance of current node plus 1.
     * 4. Keep doing 2nd, 3rd and 4th step till the queue is empty.
     */
    public Map<Integer, Integer> diagonalSum(TreeNode root) {
        Map<Integer, Integer>  result = new HashMap<Integer, Integer>();

        Queue<DiagonalNode> queue = new LinkedList<DiagonalNode>();
        queue.offer(new DiagonalNode(root, 0));

        while (!queue.isEmpty()) {
            DiagonalNode dn = queue.poll();
            TreeNode node = dn.node;
            while (node != null) {
                int sum = result.containsKey(dn.level) ? result.get(dn.level) : 0;
                result.put(dn.level, sum + node.val);

                if (node.left != null) {
                    queue.offer(new DiagonalNode(node.left, dn.level + 1));
                }

                node = node.right;
            }
        }
    }
}
