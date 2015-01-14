/**
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
 *
 * Examples:
 *
 *   Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
 *   Output: 6  (j = 7, i = 1)
 *
 *   Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
 *   Output: 8 ( j = 8, i = 0)
 *
 *   Input:  {1, 2, 3, 4, 5, 6}
 *   Output: 5  (j = 5, i = 0)
 *
 *   Input:  {6, 5, 4, 3, 2, 1}
 *   Output: -1
 *
 * http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 */
public class Solution {

    // version 1: two for loop recursive, O(n^2)
    public int maximumDistance(int[] A) {

    }

    // version 2: after checking the test cases, found the rule that
    // For an element arr[i], we do not need to consider arr[i] for left index
    // if there is an element smaller than arr[i] on left side of arr[i].
    // Similarly, if there is a greater element on right side of arr[j]
    // then we do not need to consider this j for right index.
    public int maximumDistance(int[] A) {
        int maxDistance = Integer.MIN_VALUE;
        int[] lMin = new int[A.length];
        int[] rMax = new int[A.length];

        lMin[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            lMin[i] = Math.min(lMin[i - 1], A[i]);
        }

        rMax[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], A[i]);
        }

        int i = 0;
        int j = 0;
        while (i < A.length && j < A.length) {
            if (lMin[i] < rMax[j]) {
                maxDistance = Math.max(maxDistance, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDistance;
    }
}
