public class Solution {

    public void heapSort(int[] A) {
        heapify(A);

        for (int i = A.length - 1; i > 0; i--) {
            swap(A, i, 0);
            siftDown(A, 0, i - 1);
        }
    }

    // version 1: heapify using siftDown
    private void heapify(int[] A) {
        int start = (A.length - 2) / 2;
        while (start >= 0) {
            siftDown(A, start, A.length - 1);
            start--;
        }
    }

    private void siftDown(int[] A, int pos, int end) {
        int i = pos;
        while (i * 2 + 1 <= end) {
            int child = i * 2 + 1;
            int max = i;

            if (A[max] < A[child]) {
                max = child;
            }

            if (child + 1 <= end && A[max] < A[child + 1]) {
                max = child + 1;
            }

            if (max == i) {
                return;
            }

            swap(A, i, max);
            i = max;
        }
    }

    // version 2: heapify using siftUp
    private void heapify(int[] A) {
        int end = 1;
        while (end < A.length) {
            siftUp(A, 0, end);
            end++;
        }
    }

    private void siftUp(int[] A, int start, int pos) {
        int child = pos;
        int parent = (child - 1) / 2;
        while (parent >= start && A[parent] < A[child]) {
            swap(A, child, parent);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    private void swap(int[] A, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
