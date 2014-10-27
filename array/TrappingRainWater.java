/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 *
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 * ideas:
 * from left to right, find the first non-zero number, loop:
 *      find the right bar larger or equal than the left bar, add all groove between
 *
 * repeat this from right to the highest bar find in previous loop
 */
public class Solution {

    // version 1: stack
    public int trap(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                int n = stack.pop();
                // need to check empty
                if (stack.isEmpty()) {
                    break;
                }
                int width = i - stack.peek() - 1;
                int height = Math.min(A[stack.peek()], A[i]) - A[n];
                sum += width * height;
            }
            stack.push(i);
        }

        return sum;
    }

    // derived version: if the 0 pos is leaking water
    public int trap(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                int n = stack.pop();
                // need to check empty
                if (stack.isEmpty()) {
                    break;
                }
                int width = i - stack.peek() - 1;
                int height = Math.min(A[stack.peek()], A[i]) - A[n];
                sum += width * height;
            }
            if (A[i] == 0) {
                // pop all existing data
                while (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(i);
            }
        }

        return sum;
    }

    // the water can trap by each column is determined by the min(left, right highest bar)
    // version 2: find the highest bar, seperate to two group, cal each other

    // version 3: treat the current bar as the left bar, add all grooves less than this bar
    // treat the current bar as the right bar, add all grooves less than this bar
    public int trap(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }

        int sum = 0;

        // left to right
        int pos = 0;
        while (pos < A.length && A[pos] == 0) {
            pos++;
        }

        while (pos < A.length) {
            int height = A[pos];
            int j = pos + 1;
            while (j < A.length && A[j] < A[pos]) {
                j++;
            }

            if (j == A.length) {
                break;
            }

            for (int n = pos + 1; n < j; n++) {
                sum += height - A[n];
            }

            pos = j;
        }

        int leftMark = pos;

        // right to left
        pos = A.length - 1;
        while (pos >= leftMark && A[pos] == 0) {
            pos--;
        }

        while (pos >= leftMark) {
            int height = A[pos];
            int j = pos - 1;
            while (j >= leftMark && A[j] < A[pos]) {
                j--;
            }

            if (j < leftMark) {
                break;
            }

            for (int n = pos - 1; n > j; n--) {
                sum += height - A[n];
            }

            pos = j;
        }

        return sum;
    }
}
