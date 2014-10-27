/**
 * Divide two integers without using multiplication, division and mod operator.
 */
public class Solution {

    // O(logn) O(1)
    // testcase:
    // 1. (0, 1), (1, 0), (-1, 0), (100 -30), (100, 1), (10, 100), (2147483648, -2147483648)
        // when divisor or dividend is Integer.MIN_VALUE(-2147483648), abs will overflow
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;

        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        int result = 0;

        while (dividendL >= divisorL) {
            int s = 0;
            while ((divisorL << s) <= dividendL) {
                s++;
            }
            dividendL -= divisorL << (s - 1);
            result += 1 << (s - 1);
        }

        return result * sign;
    }
}
