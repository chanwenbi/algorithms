/**
 * Given an array and a value, remove all instances of that value in place
 * and return the new length.
 *
 * The order of elements can be changed. It doesn't matter what you leave
 * beyond the new length.
 *
 * Part of the quick sort.
 */
public class Solution {

    // version 1(recommand): quick sort part
    public int removeElement(int[] A, int elem) {
        int pos = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[pos++] = A[i];
            }
        }
        return pos;
    }

    // version 2: from left/right point
    public int removeElement(int[] A, int elem) {
        if (A.length == 0) {
            return 0;
        }

        if (A.length == 1 && A[0] == elem) {
            return 0;
        }

        int i = 0, j = A.length - 1;
        while (i != j) {
            while (i < A.length && A[i] != elem) {
                i++;
            }

            while (j >= 0 && A[j] == elem) {
                j--;
            }

            if (i > j) {
                break;
            }

            A[i] = A[j];
            A[j] = elem;
        }

        return j+1;
    }
}
