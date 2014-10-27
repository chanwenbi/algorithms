/**
 * Given an array of integers, find the subarray with smallest sum.
 *
 * Return the sum of the subarray.
 *
 * Note
 * The subarray should contain at least one integer.
 *
 * Example
 * For [1, -1, -2, 1], return -3
 *
 */
public class Solution {

    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }

        // keep the prefix sum
        int sum = 0;

        // keep the maximum prefix sum
        int maxSum = 0;

        // keep the minimum prefix sum difference
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            sum = sum + nums.get(i);
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
        }
        return min;
    }
}
