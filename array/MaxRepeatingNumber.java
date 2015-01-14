/**
 * Given an array of size n, the array contains numbers in range from 0 to k-1
 * where k is a positive integer and k <= n. Find the maximum repeating number
 * in this array. For example, let k be 10 the given array be
 * A[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3}, the maximum repeating number
 * would be 2. Expected time complexity is O(n) and extra space allowed is O(1).
 *
 * http://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
 *
 * The different with MajorityNumber is that, this problem haven't told
 * us the how many will the number have at least.
 */
public class Solution {

    public int maxRepeatingNumber(int[] A, int k) {
        for (int i = 0; i < A.length; i++) {
            A[A[i] % A.length] += k;
        }

        int max = 0;
        int result =0;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
                result = i;
            }
        }

        // revert back
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] % k;
        }

        return result;
    }
}
