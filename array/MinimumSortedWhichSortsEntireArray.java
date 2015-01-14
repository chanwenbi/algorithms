package com.interview.array;

/**
 * Given an unsorted array arr[0..n-1] of size n, find the minimum length
 * subarray arr[s..e] such that sorting this subarray makes the whole array sorted.
 *
 * Examples:
 * 1) If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60],
 *    your program should be able to find that the subarray lies between
 *    the indexes 3 and 8.
 *
 * 2) If the input array is [0, 1, 15, 25, 6, 7, 30, 40, 50], your program
 *    should be able to find that the subarray lies between the indexes 2 and 5.
 *
 * http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
 */
public class Solution {

    public int[] minRangeSort(int[] A) {
        // find the left most pos, where have element less than it on right
        int left = -1;
        int min = Integer.MAX_VALUE;

        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] > min) {
                left = i;
            }
            min = Math.min(min, A[i]);
        }

        // find the right most pos, where have element larger than it on left
        int right = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (A[i] < max) {
                right = i;
            }
            max = Math.max(max, A[i]);
        }

        return new int[]{ left, right };
    }
}
