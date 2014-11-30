/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    // Version 1: Non-recursive(Recommand)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        TreeNode lastNodeVisited = null;
        TreeNode node = root;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode peekNode = stack.peek();
                /* if right child exists AND traversing node from left child, move right */
                if (peekNode.right != null && lastNodeVisited != peekNode.right) {
                    node = peekNode.right;
                } else {
                    stack.pop();
                    result.add(peekNode.val);
                    lastNodeVisited = peekNode;
                }
            }
        }

        return result;
    }

    // Version 2: recursive traversal
    public void postorderTraversalHelper(List<Integer> values, TreeNode root) {

        if (root == null) {
            return;
        }

        postorderTraversalHelper(values, root.left);
        postorderTraversalHelper(values, root.right);

        values.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        postorderTraversalHelper(result, root);

        return result;
    }

    // Version 3: divide & conquer
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);

        result.addAll(left);
        result.addAll(right);
        result.add(root.val);

        return result;
    }

}
