/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 *
 * By change dupAllowed, we could use this code solve different kind of dedup
 * problems.
 */
public class Solution {
    // O(n) O(1)
    // testcases:
    // null, {}, {1}, {1, 1, 2, 2}, {1, 1, 1, 2, 2, 3, 3, 3, 3, 5}
    public int removeDuplicates(int[] A) {
        int dupAllowed = 2;

        if (A.length <= dupAllowed) {
            return A.length;
        }

        int pos = dupAllowed;

        for (int i = dupAllowed; i < A.length; i++) {
            if (A[i] != A[pos - dupAllowed]) {
                A[pos++] = A[i];
            }
        }
        return pos;
    }
}
