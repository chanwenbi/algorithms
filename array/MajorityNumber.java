/**
 * Given an array of integers, the majority number is the number that
 * occurs more than half of the size of the array. Find it.
 *
 * Example
 * For [1, 1, 1, 1, 2, 2, 2], return 1
 *
 * Moore's Voting algorithm
 */
public class Solution {

    // O(n), O(1)
    public int majorityNumber(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            // invalid input
        }

        int result;
        int count = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                result = nums.get(i);
                count++;
                continue;
            }

            if (nums.get(i) == result) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == result) {
                count++;
            }
        }

        if (count > nums.size() / 2) {
            return result;
        }

        return -1;
    }
}
