/**
 * There are two sorted arrays A and B of size m and n respectively.
 * Find the median of the two sorted arrays.
 *
 * if two arrays length is even, then return the 1/2 of these median elements.
 *
 * The overall run time complexity should be O(log (m+n)).
 */
public class Solution {

    public int findKth(int A[], int startA, int[] B, int startB, int k) {

        if (startA >= A.length) return B[startB + k - 1];
        if (startB >= B.length) return A[startA + k - 1];

        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }

        int halfKPosA = startA + k/2 - 1;
        int halfKPosB = startB + k/2 - 1;

        int halfKatA = halfKPosA < A.length ? A[halfKPosA] : Integer.MAX_VALUE;
        int halfKatB = halfKPosB < B.length ? B[halfKPosB] : Integer.MAX_VALUE;

        if (halfKatA <= halfKatB) {
            return findKth(A, startA + k/2, B, startB, k - k/2);
        } else {
            return findKth(A, startA, B, startB + k/2, k - k/2);
        }
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        int total = A.length + B.length;

        if (total % 2 == 0) {
            int left = findKth(A, 0, B, 0, total/2);
            int right = findKth(A, 0, B, 0, total/2 + 1);
            return ((double) (left + right)) / 2.0;
        } else {
            return findKth(A, 0, B, 0, total/2 + 1);
        }
    }
}
