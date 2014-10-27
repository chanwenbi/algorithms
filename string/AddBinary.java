/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aLen = a.length();
        int bLen = b.length();
        int carrying = 0;
        while (aLen > 0 || bLen > 0 || carrying > 0) {
            int abit = aLen - 1 >= 0 ? a.charAt(aLen - 1) - '0' : 0;
            int bbit = bLen - 1 >= 0 ? b.charAt(bLen - 1) - '0' : 0;
            int sum = abit + bbit + carrying;
            sb.insert(0, sum & 0x1);
            carrying = sum >> 1;
            aLen--;
            bLen--;
        }
        return sb.toString();
    }
}
