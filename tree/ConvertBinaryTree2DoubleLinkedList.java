public class Solution {
    private TreeNode prev = null;
    private TreeNode newHead = null;

    public TreeNode toDll(TreeNode head) {
        if (head == null) {
            return null;
        }

        inorderConvert(head);
        return newHead;
    }

    private void inorderConvert(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderConvert(node.left);

        if (prev == null) {
            newHead = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;

        inorderConvert(node.right);
    }
}
