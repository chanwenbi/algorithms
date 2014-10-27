/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 */
public class Solution {
    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }

        int l = 0;
        int h = x;

        // left close, right close
        while (l <= h) {
            int m = l + (h - l) / 2;
            // note: need to change to long, to avoid overflow
            long m2 = (long) m * m;
            if (m2 == x) {
                return m;
            } else if (m2 > x) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l - 1;
    }
}
