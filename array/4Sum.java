/**
 * Given an array S of n integers, are there elements a, b, c,
 * and d in S such that a + b + c + d = target?
 *
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */
public class Solution {
    // version 1: O(n^3), O(1)
    public List<List<Integer>> fourSum(int[] num, int target) {
        if (num == null || num.length < 4) {
            // invalid input
        }

        Arrays.sort(num);

        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int l = num.length - 1;
                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];

                    if (sum == target) {
                        ret.add(Arrays.asList(num[i], num[j], num[k], num[l]));
                        do {
                            k++;
                        } while (k < l && num[k] == num[k - 1]);

                        do {
                            l--;
                        } while (k < l && num[l] == num[l + 1]);
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return ret;
    }

    // version 2: hashmap cache two sum
}
