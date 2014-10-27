/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 *
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the
 * emtpy string "".
 *
 * If there are multiple such windows, you are guaranteed that there will
 * always be only one unique minimum window in S.
 */
public class Solution {
    // memo character count in T in map,
    // scan S from left to right, memo the occurrence of character in T
    // in another map, when reach the size of T, which mean s find all
    // characters in T, shrink the left most index to find the minimum
    // window which contains all T.
    //
    // continue scan and shrink till end.
    public String minWindow(String S, String T){
        if (S == null || T == null) {
            return "";
        }

        int[] count = new int[256];

        int tLen = T.length();
        for (int i = 0; i < tLen; i++) {
            count[T.charAt(i)]++;
        }

        int sLen = S.length();
        int start = 0;
        int cur = 0;

        int[] got = new int[256];
        int total = 0;

        int min = Integer.MAX_VALUE;
        String result = "";

        while (cur < sLen) {
            char c = S.charAt(cur);
            if (got[c] < count[c]) {
                total++;
            }

            got[c]++;

            while (start < cur) {
                char s = S.charAt(start);
                if (count[s] >= got[s]) {
                    break;
                }
                got[s]--;
                start++;
            }

            if (total == tLen && cur - start + 1 < min) {
                min = cur - start + 1;
                result = S.substring(start, cur + 1);
            }

            cur++;
        }

        return result;
    }
}
