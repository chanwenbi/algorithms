/**
 * Given an array containing only 0s and 1s, find the largest subarray which
 * contain equal no of 0s and 1s.
 *
 * Test cases:
 * 1. [1, 0, 1, 1, 1, 0, 0]
 * 2. [1, 1, 1, 1]
 * 3. [0, 0, 1, 1, 0]
 * 4. [1, 1, 0, 0, 0, 0, 0, 1, 1]
 *
 * http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
*/
public class Solution {

    // using prefix sum to calculate the max length with sum 0
    // O(n), O(n)
    public int longestSubArrayWith01(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int[] prefixSum = new int[A.length];
        for (int i = 0, sum = 0; i < A.length; i++) {
            sum += (A[i] == 0) ? -1 : 1;
            prefixSum[i] = sum;
        }

        Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
        pos.put(0, -1);

        int maxLen = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            if (pos.containsKey(prefixSum[i])) {
                maxLen = Math.max(maxLen, i - pos.get(prefixSum[i]));
            } else {
                pos.put(prefixSum[i], i);
            }
        }
        return maxLen;
    }
}
