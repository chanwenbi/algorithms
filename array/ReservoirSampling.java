
public class Solution {

    public int[] generate(int[] A, int k) {
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = A[i];
        }

        Random r = new Random();
        for (int i = k; i < A.length; i++) {
            int pos = k + r.nextInt(A.length - k);
            if (pos < k) {
                result[pos] = A[i];
            }
        }
    }
}
