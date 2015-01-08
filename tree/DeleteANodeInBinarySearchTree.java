public class Solution {

    /**
     * My solutions (more clear than the code):
     * 1. leaf node, just remove it
     * 2. has only one child, replace the node with that child
     * 3. has two children, find the minimum node in right subtree
     * 4. delete it from right subtree and replace the node with this one
     */
    private void myDeleteNode(TreeNode parent, TreeNode node) {
        if (node.left == null) {
            if (parent.right == node) {
                parent.right = node.right;
            } else {
                parent.left = node.right;
            }
        } else {
            TreeNode maxNodeParent = node;
            TreeNode maxNode = node.left;

            // find the maximum node in the left sub tree
            while (maxNode.right != null) {
                maxNodeParent = maxNode;
                maxNode = maxNode.right;
            }

            if (maxNodeParent.left == maxNode) {
                maxNodeParent.left = maxNode.left;
            } else {
                maxNodeParent.right = maxNode.left;
            }

            // move replacedNode to node
            maxNode.left = node.left;
            maxNode.right = node.right;
            if (parent.left == node) {
                parent.left = maxNode;
            } else {
                parent.right = maxNode;
            }
        }
    }

    private void findAndDelete(TreeNode parent, TreeNode node, int val) {
        if (node == null) {
            return;
        }
        if (node.val == val) {
            myDeleteNode(parent, node);
        } else if (node.val < val) {
            findAndDelete(node, node.right, val);
        } else {
            findAndDelete(node, node.left, val);
        }
    }

    public TreeNode deleteNode(TreeNode root, int val) {
        // using dummy node to smooth the process
        TreeNode dummyNode = new TreeNode();
        dummyNode.left = root;
        findAndDelete(dummyNode, root, val);
        return dummyNode.left;
    }
}
