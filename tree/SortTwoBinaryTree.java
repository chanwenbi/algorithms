/**
 * Given two BST, print the nodes in order.
 */
public class Solution {

    public List<Integer> printTwoBST(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<Integer>();

        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        TreeNode n1 = root1;
        TreeNode n2 = root2;

        while (!s1.isEmpty() || !s2.isEmpty() || n1 != null || n2 != null) {
            if (n1 != null) {
                s1.push(n1);
                n1 = n1.left;
            } else if (n2 != null) {
                s2.push(n2);
                n2 = n2.left;
            } else {
                TreeNode c1 = s1.peek();
                TreeNode c2 = s2.peek();

                if (c1.val < c2.val) {
                    result.add(c1.val);
                    s1.pop();
                    n1 = c1.right();
                } else {
                    result.add(c2.val);
                    s2.pop();
                    n2 = c2.right();
                }
            }
        }

        return result;
    }

}
