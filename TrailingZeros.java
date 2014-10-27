/**
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 *
 * Example
 * 11! = 39916800, so the out should be 2
 *
 * http://lintcode.com/en/problem/trailing-zeros/
 */
class Solution {
    //param n : description of n
    //return: description of return
    public long trailingZeros(long n) {
        // 5, 25, 125, 625, ...
        long i = 5;
        long sum = 0;
        while (i < n) {
            sum += n / i;
            i = i * 5;
        }
        return sum;
    }
};
