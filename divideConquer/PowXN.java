/**
 * Implement pow(x, n).
 */
public class Solution {

    private static final double PRECISION = 0.000001;

    // O(logn)
    // testcase:
    // (0, 0), (8.2, 0), (0, -1), (0, 1), (8.2, 3), (8.2, 4), (8.2, -2147483648)
    public double pow(double x, int n) {
        if (equal(x, 0) && n <= 0) {
            // invalid input
        }

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n < 0) {
            // pay attention to overflow
            // Integer.MIN_VALUE * -1 == Integer/MIN_VALUE
            if (n == Integer.MIN_VALUE) {
                return 1 / (x * pow(x, Integer.MAX_VALUE));
            } else {
                return 1 / pow(x, -n);
            }
        }

        double half = pow(x, n/2);
        double left = pow(x, n - n/2 - n/2);

        return half * half * left;
    }

    boolean equal(double x, double y) {
        return Math.abs(x - y) < PRECISION;
    }
}
