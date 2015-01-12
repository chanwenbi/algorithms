/**
 * Write a function to detect if two trees are isomorphic.
 * Two trees are called isomorphic if one of them can be obtained from
 * other by a series of flips, i.e. by swapping left and right children
 * of a number of nodes. Any number of nodes at any level can have their
 * children swapped. Two empty trees are isomorphic.
 *
 * check following link for vivid graph:
 * http://www.geeksforgeeks.org/tree-isomorphism-problem/
 *
 * Test cases:
 * Same tree
 * Exact mirror
 * Some nodes flipped
 */
public class Solution {

	public boolean isIsomorphic(Node n1, Node n2) {
		if (n1 == null && n2 == null) {
			return true;
		}

		if(n1 == null || n2 == null){
			return false;
		}

		return n1.data == n2.data &&
                  ((isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right)) ||
                   (isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left)));
	}

}
