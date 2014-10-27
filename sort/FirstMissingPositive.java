/**
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 *
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class Solution {

    // before implement, need to confirm with interviewer:
    // Can I change the original array?
    // No  --> use version 1, O(n), O(n)
    // Yes --> use version 2, O(n), O(1)

    // Version 1: using hashmap to memo the existing num.
    public int firstMissingPositive(int[] A) {
        Map<Integer, Boolean> exist = new HashMap<Integer, Boolean>();
        for (int a : A) {
            exist.put(a, true);
        }
        for (int i = 1; i <= A.length + 1; i++) {
            if (!exist.containsKey(i)) {
                return i;
            }
        }
        return 1;
    }

    // Version 2: put the value to the pos it should be
    // then use a loop to scan through the array, find the min missing value
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }

        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1]) {
                int tmp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return A.length + 1;
    }
}
