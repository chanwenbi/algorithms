/**
 * Given an array of integers, every element appears twice except for two. Find the two singles.
 *
 * idea:
 * xor all nums, find a bit of 1 in the result, assume it's xth pos.
 * part of the nums to two group:
 * groups A: xth pos are all 1
 * groups B: xth pos are all 0
 */
public class Solution {

    public int[] sinlge(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        int oneBit = (result & (result - 1)) ^ result;

        int result1 = 0;
        int result2 = 0;
        for (int num : nums) {
            if (num & oneBit != 0) {
                result1 ^= num;
            } else {
                result2 ^= num;
            }
        }

        return new int[] { result1, result2 };
    }

}
