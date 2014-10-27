/**
 * Implement strStr().
 *
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 */
public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }

        int hLen = haystack.length();
        int nLen = needle.length();
        for (int i = 0; i < hLen - nLen + 1; i++) {
            int j = 0;
            for (j = 0; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == nLen) {
                return haystack.substring(i);
            }
        }
        return null;
    }

    // version 2: kmp
}
