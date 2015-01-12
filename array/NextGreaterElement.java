/**
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element on
 * the right side of x in array. Elements for which no greater element exist,
 * consider next greater element as -1.
 *
 * http://www.geeksforgeeks.org/next-greater-element/
 *
 * test case:
 * 1. [4, 5, 2, 25] : [5, 25, 25, -1]
 * 2. [13, 7, 6, 12] : [-1, 12, 12, -1]
 */
public class Solution {

    // O(n), O(n)
    public int[] nextGreater(int[] A) {
        if (A == null) {
            return null;
        }

        int[] result = new int[A.length];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        return result;
    }

}
