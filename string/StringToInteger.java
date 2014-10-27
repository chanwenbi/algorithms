/**
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely
 * (ie, no given input specs). You are responsible to gather all the input
 * requirements up front.
 *
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of
 * this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 * If the correct value is out of the range of representable values,
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class Solution {
    // Confirm:
    // 1. what to return if str is null or empty?
    // 2. can be trailing or leading with whitespace?
    // 3. what to return if the string only contains whitespace?
    // 4. can str leading with +/-?
    // 5. what is the base, hexadecimal or decimalism?
    // 6. what value to return if overflow?
    public int atoi(String str) {
        if (str == null) {
            return 0;
        }

        String s = str.trim();
        if (s.length() == 0) {
            return 0;
        }

        char c = s.charAt(0);
        if (c != '+' && c != '-' && (c < '0' || c > '9')) {
            return 0;
        }

        int pos = 0;
        int sign = 1;
        if (c == '+') {
            pos = 1;
        } else if (c == '-') {
            sign = -1;
            pos = 1;
        }


        long value = 0;
        while (pos < s.length()) {
            char cur = s.charAt(pos);
            if (cur < '0' || cur > '9') {
                break;
            }

            value = value * 10 + (cur - '0');
            if (sign == -1 && value >= ((long) -1) * Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (value > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            pos++;
        }

        return (int) value * sign;
    }
}
