
public class Solution {

    public int[] generate(int[] A, int k) {
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = A[i];
        }

        Random r = new Random();
        for (; i < A.length; i++) {
            int pos = r.nextInt(i + 1);
            if (pos < k) {
                result[pos] = A[i];
            }
        }

        return result;
    }
}
