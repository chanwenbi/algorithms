/**
 * Given an array with N elements, N is an even number.
 *
 * Can these N elements be grouped to N/2 pairs, so that
 * each pair's sum could divide K.
 */
public class Solution {

    public boolean check(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return false;
        }

        int[] counts = new int[k];

        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] % k]++;
        }

        if (counts[0] % 2 != 0) {
            return false;
        }

        if (k % 2 == 0 && counts[k / 2] % 2 != 0) {
            return false;
        }

        for (int i = 1; i <= k / 2; i++) {
            if (counts[i] != counts[k - i]) {
                return false;
            }
        }

        return true;
    }
}
