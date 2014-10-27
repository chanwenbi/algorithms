/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 */
public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            // invalid input
        }

        String current = "1";
        while (--n > 0) {
            current = getNext(current);
        }
        return current;
    }

    String getNext(String current) {
        StringBuilder sb = new StringBuilder();
        int len = current.length();
        for (int i = 0; i < len; i++) {
            int count = 1;
            while (i + 1 < len && current.charAt(i) == current.charAt(i + 1)) {
                i++;
                count++;
            }
            sb.append(count).append(current.charAt(i));
        }
        return sb.toString();
    }
}
