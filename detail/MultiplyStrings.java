/**
 * Given two numbers represented as strings,
 * return multiplication of the numbers as a string.
 *
 * Note: The numbers can be arbitrarily large and are non-negative.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }

        int[] bits = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int d = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                bits[i + j + 1] += d * (num2.charAt(j) - '0');
            }
        }

        for (int i = bits.length - 1; i > 0; i--) {
            bits[i - 1] += bits[i] / 10;
            bits[i] = bits[i] % 10;
        }

        int i;
        for (i = 0; i < bits.length - 1; i++) {
            if (bits[i] != 0) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (i < bits.length) {
            sb.append(bits[i]);
            i++;
        }

        return sb.toString();
    }
}
