public class Solution {


    // version 1: original quicksort version
    public void quicksort(int[] A, int l, int h) {
        if (l < h) {
            int p = partition(A, l, h);
            quicksort(A, l, p - 1);
            quicksort(A, p + 1, h);
        }
    }

    private int partition(int[] A, int l, int h) {
        int pivot = pickPivot(l, h);
        swap(A, pivot, h);

        int pos = l;
        for (int i = l; i < h; i++) {
            if (A[i] < A[pivot]) {
                swap(A, i, pos);
                pos++;
            }
        }

        swap(A, pos, h);
        return pos;
    }

    // version 2: quicksort exhibits poor performance for inputs that contain many repeated elements
    // using the new partition to improve the performance
    public void quicksort(int[] A, int l, int h) {
        if (l < h) {
            Tuple tuple = partition(A, l, h);
            System.out.println(tuple);
            quicksort(A, l, tuple.left);
            quicksort(A, tuple.right, h);
        }
    }

    private Tuple partition(int[] A, int l, int h) {
        int pivot = pickPivot(l, h);
        int pivotValue = A[pivot];

        int nextPosLessPivot = l;
        int nextPosLargerPivot = h;
        int i = l;
        while (i <= nextPosLargerPivot) {
            if (A[i] < pivotValue) {
                swap(A, nextPosLessPivot, i);
                nextPosLessPivot++;
                i++;
            } else if (A[i] == pivotValue) {
                i++;
            } else if (A[i] > pivotValue) {
                swap(A, nextPosLargerPivot, i);
                nextPosLargerPivot--;
            }
        }

        return new Tuple(nextPosLessPivot - 1, nextPosLargerPivot);
    }

    private int pickPivot(int l, int h) {
        Random r = new Random();
        return l + r.nextInt(h - l + 1);
    }

    private void swap(int[] A, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public class Tuple {
        public int left;
        public int right;

        public Tuple(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    // quick select to find the kth largest or smallest pos
    //
    // return the pos of kth smallest value
    // the first kth smallest values are from 0 to k
    public int quickselect(int[] A, int l, int h, int k) {
        while (l <= h) {
            int pos = partition(A, l, h);
            if (pos == k) {
                return pos;
            } else if (pos > k) {
                h = pos - 1;
            } else {
                l = pos + 1;
            }
        }
        return -1;
    }
}
