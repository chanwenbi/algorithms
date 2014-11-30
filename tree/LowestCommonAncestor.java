
public class Solution {

    // Confirm:
    // 1. is it a binary search tree
    // 2. is it a binary tree
    // 3. does each node has parent pointer
    public Node LCA(Node root, Node a, Node b) {

        if (root == null) {
            return null;
        }

        if (root == a || root == b) {
            return root;
        }

        Node l = LCA(root.left, a, b);
        Node r = LCA(root.right, a, b);

        if (l != null && r != null) {
            return root;
        }

        return l != null ? l : r;
    }

}
