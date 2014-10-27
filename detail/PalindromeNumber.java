/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 *
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 *
 * You could also try reversing an integer. However, if you have solved the problem
 * "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 *
 * There is a more generic way of solving this problem.
 */
public class Solution {


    // version 1(recommand): first bit with last bit, second bit with last second bit...
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int d = 1;
        while (x / d >= 10) {
            d *= 10;
        }

        while (x > 0) {
            int a = x / d;
            int b = x % 10;
            if (a != b) {
                return false;
            }

            x = (x % d) / 10;
            d /= 100;
        }

        return true;
    }

    // version 2: based on reverse integer
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        // change to long to avoid overflow
        long lx = (long) x;
        long reversedLx = reverse(lx);
        return lx == reversedLx ? true : false;
    }

    public long reverse(long x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}
