/**
 * Convert an unsorted array into an array with order:
 * a < b > c < d > e < f ...
 */
public class Solution {

    public void convert(int A[]){
        int m = A.length % 2 == 0 ? A.length / 2 : A.length / 2 + 1;

        // partition into two equal set
        // check sort/QuickSort.java
        quickselect(A, 0, A.length, m);

        int h = m;
        int l = 1;
        for (int l = 1, h = m; l < h && h < A.length; l += 2, h++) {
            swap(A, l, h);
        }
    }

    private void swap(int[] A, int l, int h) {
        if (l == h) {
            return;
        }

        int temp = A[l];
        A[l] = A[h];
        A[h] = temp;
    }
}
