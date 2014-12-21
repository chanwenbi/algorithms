/**
 * Given a binary tree, a target node in the binary tree,
 * and an integer value k, print all the nodes that are at
 * distance k from the given target node. No parent pointers
 * are available.
 *
 * There are two types of nodes to be considered.
 * 1) Nodes in the subtree rooted with target node. For example if the target node is 8 and k is 2, then such nodes are 10 and 14.
 * 2) Other nodes, may be an ancestor of target, or a node in some other subtree. For target node 8 and k is 2, the node 22 comes in this category.
 */
public class Solution {

    public List<TreeNode> getKDistanceNode(TreeNode root, TreeNode node, int k) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if (root == null || node == null || k < 0) {
            return nodes;
        }

        findNode(nodes, root, node, k);
        return nodes;
    }

    public int findNode(List<TreeNode> nodes, TreeNode root, TreeNode node, int k) {
        if (root == null) {
            return -1;
        }

        if (root == node) {
            addKDistanceChildren(nodes, root, k);
            return 0;
        }

        int leftDistance = findNode(nodes, root.left, node, k);
        if (leftDistance != -1) {
            if (leftDistance + 1 == k) {
                nodes.add(root);
            } else {
                addKDistanceChildren(nodes, root.right, k - leftDistance - 2);
            }
            return leftDistance + 1;
        }

        int rightDistance = findNode(nodes, root.right, node, k);
        if (rightDistance != -1) {
            if (rightDistance + 1 == k) {
                nodes.add(root);
            } else {
                addDistanceChildren(nodes, root.left, k - rightDistance - 2);
            }
            return rightDistance + 1;
        }

        return -1;
    }

    private void addDistanceChildren(List<TreeNode> nodes, TreeNode root, int k) {
        if (root == null || k < 0) {
            return;
        }

        if (k == 0) {
            nodes.add(root);
            return;
        }

        addDistanceChildren(nodes, root.left, k - 1);
        addDistanceChildren(nodes, root.right, k - 1);
    }
}
