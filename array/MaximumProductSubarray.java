
public class Solution {

    public int maxProduct(int[] A){
        if(A == null || A.length == 0){
            return 0;
        }

        int prod = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            prod *= A[i];
            max = Math.max(max, prod);
            if (A[i] == 0) {
                prod = 1;
            }
        }

        prod = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            prod *= A[i];
            max = Math.max(max, prod);
            if (A[i] == 0) {
                prod = 1;
            }
        }

        return max;
    }
}
