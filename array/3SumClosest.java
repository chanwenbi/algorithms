/**
 * Given an array S of n integers, find three integers in S such that the sum
 * is closest to a given number, target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
            // invalid input
        }

        Arrays.sort(num);

        int closest = 0;
        int minGap = Integer.MAX_VALUE;

        for (int i = 0; i < num.length - 2; i++) {
            int k = i + 1;
            int l = num.length - 1;
            while (k < l) {
                int sum = num[i] + num[k] + num[l];

                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    l--;
                } else {
                    k++;
                }

                int gap = Math.abs(sum - target);
                if (gap < minGap) {
                    closest = sum;
                    minGap = gap;
                }
            }
        }
        return closest;
    }
}
