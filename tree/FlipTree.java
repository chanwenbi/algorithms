public class Solution {
    public TreeNode flip(TreeNode head) {
        if (head == null || head.left == null) {
            return head;
        }

        TreeNode newHead = flip(head.left);
        TreeNode p = head.left;
        p.left = head.right;
        p.right = head;
        head.left = null;
        head.right = null;

        return newHead;
    }
}
