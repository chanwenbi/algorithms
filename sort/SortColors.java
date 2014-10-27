/**
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the
 * color red, white, and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 *
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 *
 * Could you come up with an one-pass algorithm using only constant space?
 */
public class Solution {

    // confirm with interviewer:
    // Can I use counting sort?

    // Version 1: one pass
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        // next pos to put 0
        int pos = 0;
        int begin = 0;
        // next pos to put 2
        int end = A.length - 1;

        while (begin <= end) {
            if (A[begin] == 0) {
                // swap begin with pos
                swap(A, begin, pos);
                begin++;
                pos++;
            } else if (A[begin] == 1) {
                begin++;
            } else {
                swap (A, begin, end);
                end--;
            }
        }
    }

    private void swap(int[] A, int pos1, int pos2) {
        if (pos1 == pos2) {
            return;
        }
        int temp = A[pos1];
        A[pos1] = A[pos2];
        A[pos2] = temp;
    }

    // Version 2: two loop sort
    public void sortColors(int[] A) {
        sortColorsHelper(A, sortColorsHelper(A, 0, 1), 2);
    }

    private int sortColorsHelper(int[] A, int pos, int bar) {
        int index = pos;
        for (int i = pos; i < A.length; i++) {
            if (A[i] < bar) {
                swap(A, index, i);
                index++;
            }
        }
        return index;
    }
}
