/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return true.
 *
 * A = [3,2,1,0,4], return false.
 */
public class Solution {

    // Solution 1(recommand): remember the max position the first point could jump to, O(n)
    // O(n) O(1)
    public boolean canJump(int[] A) {
        // memo the fast step could reach
        int reach = 0;

        for (int i = 0; i <= reach && i < A.length; i++) {
            reach = Math.max(reach, A[i] + i);
            if (reach >= A.length - 1) {
                return true;
            }
        }

        return false;
    }

    // Solution 2: dp from end, O(n^2), will cause time out
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        if (A.length == 1) {
            return true;
        }

        if (A[0] >= A.length - 1) {
            return true;
        }

        // can reach from ith pos to last
        boolean[] canReach = new boolean[A.length];

        canReach[A.length - 1] = true;

        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = A[i]; j > 0; j--) {
                if (canReach[i + j]) {
                    canReach[i] = true;
                    break;
                }
            }
        }

        return canReach[0];
    }

    // Solution 3: for each pos, check whether the first point can jump to, O(n^2),
    // but will not cause time out, maybe the test data is not perfect
    // can jump from 0 to ith pos
    // O(n^2) O(1)
    public boolean canJump(int[] A) {
        boolean[] can = new boolean[A.length];
        can[0] = true;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && j + A[j] >= i) {
                    can[i] = true;
                    break;
                }
            }
        }

        return can[A.length - 1];
    }
}
