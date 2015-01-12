public class CountingSort {

    private static int TOTAL = 10;

    public void sort(int[] A) {
        int[] count = new int[TOTAL];

        for (int i = 0; i < A.length; i++) {
            count[A[i]]++;
        }

        int pos = 0;
        for (int i = 0; i < TOTAL; i++) {
            while (count[i]-- > 0) {
                A[pos++] = i;
            }
        }
    }

    public void sort1(int A[]) {
        int[] count = new int[TOTAL];
        int[] output = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            count[A[i]]++;
        }

        for (int i = 1; i < TOTAL; i++) {
            count[i] += count[i - 1];
        }

        for(int i = 0; i < A.length; i++) {
            output[count[A[i]] - 1] = A[i];
            count[A[i]]--;
        }

        for(int i = 0; i < A.length; i++) {
            A[i] = output[i];
        }
    }
}
