/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this:
 * you may want to display this pattern in a fixed font for better legibility
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 * convert("PAYPALISHIRING", 4) should return "PINALSIGYAHRPI".
 *
 * P     I     N
 * A   L S   I G
 * Y A   H R
 * P     I
 */
public class Solution {
    public String convert(String s, int nRows) {
        int len = s.length();
        if (len <= nRows || nRows <= 1) {
            return s;
        }

        // check the sample to find the rule for each row
        int steps = 2 * nRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            int step = steps - i * 2;
            if (step == 0) {
                step = steps;
            }

            // the steps for each round is:
            // (steps - 2i), (2i), (steps - 2i), (2i)...
            int j = i;
            while (j < s.length()) {
                sb.append(s.charAt(j));
                j += step;
                if (step != steps) {
                    step = steps - step;
                }
            }
        }
        return sb.toString();
    }
}
