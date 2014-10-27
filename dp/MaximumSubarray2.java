import java.util.ArrayList;

/**
 * Given an array of integers, find two non-overlapping subarrays which have the largest sum.
 *
 * The number in each subarray should be contiguous.
 *
 * Return the largest sum.
 *
 * Note
 * The subarray should contain at least one number
 *
 * Example
 * For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, -2]
 * or [1, 3, -1, 2] and [2], they both have the largest sum 7.
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int[] left = new int[nums.size()];
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            sum = sum + nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);

            left[i] = max;
        }

        int[] right = new int[nums.size()];
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = nums.size() - 1; i >= 0; i--) {
            sum = sum + nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);

            right[i] = max;
        }

        int result = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            result = Math.max(result, left[i] + right[i + 1]);
        }
        return result;
    }
}
