/**
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
 *
 * Test cases:
 * A node with only right child
 * A node with only left child
 * A node with both left and right child
 */
public class Solution {

    // O(n)
	public boolean isComplete(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		boolean flag = false;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

            if (node.left != null) {
                if (flag) {
                    return false;
                }
                queue.offer(node.left);
            } else {
                flag = true;
            }

            if (node.right != null) {
                if (flag) {
                    return false;
                }
                queue.offer(node.right);
            } else {
                flag = true;
            }
		}

		return true;
	}
}
