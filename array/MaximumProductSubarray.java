/**
 * Given an array that contains both positive and negative integers,
 * find the product of the maximum product subarray.
 *
 * Examples:
 *
 * Input: arr[] = {6, -3, -10, 0, 2}
 * Output:   180  // The subarray is {6, -3, -10}
 *
 * Input: arr[] = {-1, -3, -10, 0, 60}
 * Output:   60  // The subarray is {60}
 *
 * Input: arr[] = {-2, -3, 0, -2, -40}
 * Output:   80  // The subarray is {-2, -40}
 */
public class Solution {

    // O(n), O(1)
    public int maxProduct(int[] A){
        if(A == null || A.length == 0){
            return 0;
        }

        int prod = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            prod *= A[i];
            max = Math.max(max, prod);
            if (A[i] == 0) {
                prod = 1;
            }
        }

        prod = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            prod *= A[i];
            max = Math.max(max, prod);
            if (A[i] == 0) {
                prod = 1;
            }
        }

        return max;
    }
}
