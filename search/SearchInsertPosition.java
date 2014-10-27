/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class Solution {
    public int searchInsert(int[] A, int target) {
        // left close, right open
        int l = 0, h = A.length;
        while (l < h) {
            int m = (l + h) / 2;
            if (A[m] == target) {
                return m;
            } else if (A[m] < target) {
                if (m+1 >= A.length || A[m+1] > target) {
                    return m + 1;
                } else {
                    l = m + 1;
                }
            } else {
                h = m;
            }
        }
        return 0;
    }
}
