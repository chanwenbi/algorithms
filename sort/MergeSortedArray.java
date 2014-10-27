/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n)
 * to hold additional elements from B.
 *
 * The number of elements initialized in A and B are m and n respectively.
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null || m < 0 || n < 0) {
            // invalid
            return;
        }

        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }

        while (j >= 0) {
            A[j] = B[j];
            j--;
        }
    }
}
