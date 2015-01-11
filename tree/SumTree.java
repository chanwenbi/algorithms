/**
 * A SumTree is a Binary Tree where the value of a node is equal to sum
 * of the nodes present in its left subtree and right subtree.
 * An empty tree is SumTree and sum of an empty tree can be considered as 0.
 * A leaf node is also considered as SumTree.
 *
 * Following is an example of SumTree.
 *
 *           26
 *         /   \
 *       10     3
 *     /    \     \
 *   4      6      3
 *
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 */
public class SumTree {

	public boolean isSumTree(Node root){
        if (root == null || isLeaf(root)) {
            return true;
        }

        if (!isSumTree(root.left) || !isSumTree(root.right)) {
            return false;
        }

        return getValue(node.left) + getValue(root.right) == root.val;
	}

    private int getValue(Node node) {
        if (node == null) {
            return 0;
        }

        return isLeaf(node) ? node.val : node.val * 2;
    }

    private boolean isLeaf(Node node) {
        if (node == null) {
            return false;
        }

        return node.left == null && node.right == null;
    }

}
