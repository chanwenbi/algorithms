/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class Solution {

    public int[] searchRange(int[] A, int target) {
        // left close, right open
        int l = 0, h = A.length;
        int left = -1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (A[m] == target) {
                h = m;
                left = m;
            } else if (A[m] > target) {
                h = m;
            } else {
                l = m + 1;
            }
        }

        l = 0;
        h = A.length;
        int right = -1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (A[m] == target) {
                l = m + 1;
                right = m;
            } else if (A[m] > target) {
                h = m;
            } else {
                l = m + 1;
            }
        }

        return new int[] { left, right };
    }
}
