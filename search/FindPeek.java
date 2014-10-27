/**
 * There is an array which we can assume the numbers in adjcent positions are different.
 * and A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 *
 * We consider a position P is a peek if A[P] > A[P-1] && A[P] > A[P+1].
 *
 * Find a peek in this array.
 *
 * http://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
 */
public class Solution {

    public int FindPeek(int[] nums) {
        // left close, right open
        int l = 0;
        int h = nums.length;

        while (l < h) {
            int m = l + (h - l) / 2;

            if (m == 0 || m == nums.length - 1) {
                break;
            }

            if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) {
                return m;
            } else if (nums[m] > nums[m - 1] && nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                h = m;
            }
        }

        return -1;
    }

}
