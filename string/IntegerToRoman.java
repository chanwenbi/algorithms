/**
 * Given an integer, convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {
    int[] keys = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                        "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int pos = 0;
        while (num > 0) {
            int nTimes = num / keys[pos];
            num -= keys[pos] * nTimes;
            while (nTimes-- > 0) {
                sb.append(symbols[pos]);
            }
            pos++;
        }

        return sb.toString();
    }
}
