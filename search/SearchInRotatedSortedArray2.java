/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 * O(n) time complexity.
 * Because when equal, we could not reduce the problem by half.
 *
 * Write a function to determine if a given target is in the array.
 *
 * 1, 2, 1, 1, 1
 *
 * Unlike SearchInRotatedSortedArray, here we can not judge whether A[l] == A[m] case.
 *
 */
public class Solution {
    public boolean search(int[] A, int target) {
        // left close, right open
        int l = 0;
        int h = A.length;

        while (l < h) {
            int m = l + (h - l) / 2;
            if (target == A[m]) {
                return true;
            }
            if (A[l] < A[m]) {
                if (A[l] <= target && target < A[m]) {
                    h = m;
                } else {
                    l = m + 1;
                }
            } else if (A[l] > A[m]) {
                if (A[m] < target && target <= A[h - 1]) {
                    l = m + 1;
                } else {
                    h = m;
                }
            } else {
                l = l + 1;
            }
        }

        return false;
    }
}
