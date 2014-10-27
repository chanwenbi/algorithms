/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a
 * constant space solution?
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

    // Version 1(recommand): find the wrong node during inorder scan
    // dummy node to simplify the code
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    TreeNode node1;
    TreeNode node2;

    private void visit(TreeNode root) {
        if (root == null) {
            return;
        }

        visit(root.left);
        if (preNode.val > root.val) {
            // find the rule: the wrong elements are:
            // 1. first left node large than right node
            // 2. last right node less than left node

            // first left node large than right node
            if (node1 == null) {
                node1 = preNode;
            }
            // last right node less than left node
            node2 = root;
        }
        preNode = root;
        visit(root.right);
    }

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        visit(root);

        // swap the vals
        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;
    }

    // Version 2: inorder visit the tree, then scan the list to find the
    // out of order elements, cost O(n) space
    private void visit(List<Integer> vals, List<TreeNode> nodes, TreeNode root) {
        if (root == null) {
            return;
        }
        visit(vals, nodes, root.left);
        vals.add(root.val);
        nodes.add(root);
        visit(vals, nodes, root.right);
    }

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> vals = new ArrayList<Integer>();
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        visit(vals, nodes, root);

        int n1 = 0;
        for (int i = vals.size() - 1; i > 0; i--) {
            if (vals.get(i) < vals.get(i - 1)) {
                n1 = i;
                break;
            }
        }
        int n2 = 0;
        for (int i = 0; i < vals.size() - 1; i++) {
            if (vals.get(i) > vals.get(i + 1)) {
                n2 = i;
                break;
            }
        }
        int temp = nodes.get(n2).val;
        nodes.get(n2).val = nodes.get(n1).val;
        nodes.get(n1).val = temp;
    }

}
