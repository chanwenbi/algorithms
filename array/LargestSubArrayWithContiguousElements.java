/**
 *
 * Given an array of <distinct integers>, find length of the longest subarray
 * which contains numbers that can be arranged in a continuous sequence.
 *
 * Examples:
 *
 * Input:  arr[] = {10, 12, 11};
 * Output: Length of the longest contiguous subarray is 3
 *
 * Input:  arr[] = {14, 12, 11, 20};
 * Output: Length of the longest contiguous subarray is 2
 *
 * Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
 * Output: Length of the longest contiguous subarray is 5
 *
 * http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
 */
public class solution {

    // version 1: iterating all ranges, check the (max - min) == (j - i)
    // O(n^2)
    //
    // NOTE: segment tree is helpful for range query, but not quite useful
    // for solving this issue, as the maximum range may cross the root
    public int getLongest(int[] A) {

    }

    // If duplicates are allowed, then we can use a hashset for every
    // subrange start from [0, A.length), if we found an element already in
    // hashset, then we don't consider the current subarray.
    //
    // http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/
}
