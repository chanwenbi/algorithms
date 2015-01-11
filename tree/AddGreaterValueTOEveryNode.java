/**
 * http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
 *
 *            50
 *          /    \
 *         30     70
 *       /    \  /   \
 *      20    40 60  80
 *
 * to:
 *
 *            260
 *          /     \
 *         330     150
 *       /    \    /  \
 *      350   300 210  80
 *
 * Test cases:
 * Empty tree
 * One node tree
 * Two node tree
 */

public class Solution {

    // O(n) time complexity
    public void add(TreeNode root) {
        if (root == null) {
            return;
        }

        add(root, new IntegerRef(0));
    }

	public void add(TreeNode root, IntegerRef accumulatedSum){

		if(root == null){
			return;
		}

		add(root.right, accumulatedSum);
		root.data += accumulatedSum.value;
		accumulatedSum.value = root.data;
		add(root.left, accumulatedSum);
	}

    static class IntegerRef {
    	int value;
        public IntegerRef(int value) {
            this.value = value;
        }
    }
}

