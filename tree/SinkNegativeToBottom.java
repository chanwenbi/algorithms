/**
 * http://www.careercup.com/question?id=5344154741637120
 */
public class Solution {

	public void sinkZero(Node root) {
		if (root == null) {
			return;
		}

		sinkZero(root.left);
		sinkZero(root.right);

		if (root.data < 0) {
			siftDown(root);
		}
	}

	private void siftDown(Node root) {
		if(root == null){
			return;
		}

		if (root.left == null && root.right == null) {
			return;
		}

		if (root.left != null && root.left.data >= 0) {
            swap(root, root.left);
			siftDown(root.left);
		} else if (root.right != null && root.right.data >= 0) {
            swap(root, root.right);
			siftDown(root.right);
		}
	}

    private void swap(Node n1, Node n2) {
        if (n1 == n2 || n1.val == n2.val) {
            return;
        }

        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}
