/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 */
public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        // left close, right open
        int l = 0;
        int h = A.length;

        while (l < h) {
            int m = l + (h - l) / 2;

            if (A[m] == target) {
                return m;
            }

            // don't need to consider equal, as the question mentioned there
            // is no duplicate
            if (A[l] < A[m]) {
                if (target < A[m] && target >= A[l]) {
                    h = m;
                } else {
                    l = m + 1;
                }
            } else {
                if (target > A[m] && target <= A[h - 1]) {
                    l = m + 1;
                } else {
                    h = m;
                }
            }
        }

        return -1;
    }
}
