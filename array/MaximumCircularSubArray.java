/**
 * http://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
 */
public class Solution {

    public int maxCircularSubArray(int A[]){
        int max = maxSubArray(A);

        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        // minSubArray could get via: - maxSubArray(-A)
        int min = minSubArray(A);

        return Math.max(max, sum - min);
    }
}
