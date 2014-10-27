/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 *
 * click to show more practice.
 *
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution
 * using the divide and conquer approach, which is more subtle.
 */
public class Solution {
    public int maxSubArray(int[] A) {
        int maxResult = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = max <= 0 ? A[i] : max + A[i];
            maxResult = Math.max(maxResult, max);
        }
        return maxResult;
    }
}

// Version 2: Prefix Sum
public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }
}

// Version 3: divide and conquer
// O(nlogn)
public class Solution {

    public int maxSubArrayHelper(int[] A, int start, int end) {

        if (start == end) {
            return A[start] <= 0 ? 0 : A[start];
        }

        int mid = start + (end - start) / 2;
        int max = Math.max(maxSubArrayHelper(A, start, mid), maxSubArrayHelper(A, mid + 1, end));

        int sum = 0;
        int maxLeft = 0;
        for (int i = mid; i >= start; i--) {
            sum += A[i];
            maxLeft = Math.max(maxLeft, sum);
        }

        sum = 0;
        int maxRight = 0;
        for (int i = mid + 1; i <= end; i++) {
            sum += A[i];
            maxRight = Math.max(maxRight, sum);
        }

        max = Math.max(max, maxLeft + maxRight);

        return max;
    }

    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        return maxSubArrayHelper(A, 0, A.length - 1);
    }

}
