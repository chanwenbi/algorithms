/**
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * 1. how to deal with int overflow?
 * 2. 10 -> 01 or 10 -> 1?
 *
 * could convert x to long to avoid overlow
 */
public class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}
