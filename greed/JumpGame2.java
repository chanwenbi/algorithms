/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example:
 * Given array A = [2,3,1,1,4]
 *
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class Solution {
    // solution 1(recommand): greedy
    // O(n) O(1)
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int steps = 0;
        // the farest index coud reach after steps
        int reach = 0;
        // the current maximum distance could reach after steps + 1
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            if (i > reach) {
                steps++;
                reach = max;

                // could not jump to the last step
                if (reach < i) {
                    return -1;
                }
            }
            max = Math.max(max, i + A[i]);
        }

        return steps;
    }

    // solution 2: dp, O(n^2) O(n)
    public int jump(int[] A) {
        // minimum steps jump from 0 to ith pos
        int[] step = new int[A.length];

        for (int k = 0; k < A.length; k++) {
            step[k] = -1;
        }

        step[0] = 0;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (step[j] >= 0 && j + A[j] >= i) {
                    // actually, this should be steps[i] = min(step[i], step[j] + 1)
                    // but:
                    // the minimum steps jump from 0 to ith pos will always less or equal than
                    // the minimum steps jump from 0 to > ith pos
                    // so could be simplified as this
                    step[i] = step[j] + 1;
                    break;
                }
            }
        }

        return step[A.length - 1];
    }
}
